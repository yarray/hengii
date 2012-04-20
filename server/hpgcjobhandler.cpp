/*
 * =====================================================================================
 *
 *       Filename:  hpgcjobhandler.cpp
 *
 *    Description:  The class skeleton is generated by thrift compiler. All the service
 *  			  	interface are implemented here.
 *
 *        Version:  0.9
 *        Created:  2012年03月23日 11时47分00秒
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Liu Lu(), nudtlliu@gmail.com
 *   Organization:  
 *
 * =====================================================================================
 */
#include <sys/time.h>
#include <sstream>
#include "hpgcjobhandler.h"
#include "logger.h"

HpgcJobHandler::HpgcJobHandler() {
	for (int i = 0; i < TRACKER_POOL_SIZE; i++) {
		addTracker();
	}
	log = JobLog::Instance();
	pthread_mutex_init(&poolLock, NULL);

	pthread_create(&gctId, NULL, cleanWorker, this);
}

HpgcJobHandler::~HpgcJobHandler() {
	void *tret;
	pthread_join(gctId, &tret);
	pthread_mutex_destroy(&poolLock);
}


int64_t HpgcJobHandler::findEmptyPoolSlot() {
	trackerItr = trackerPool.begin();
	while (trackerItr != trackerPool.end()) {
		if ((trackerItr->second).isAvailable())
			return trackerItr->first;
		trackerItr++;
	}
	return -1;
}

int64_t HpgcJobHandler::generateTrackerId() {
	int64_t id;
	int64_t prefix;

	srand(time(0));
	do {
		prefix = time(0) * 1000;
		id = prefix + rand() % 1000;
	} while(trackerPool.count(id) > 0);
	return id;
}

void HpgcJobHandler::addTracker() {
	int64_t id = generateTrackerId();
	Tracker t(id);
	t.setAvailable(true);
	trackerPool.insert(map<int64_t, Tracker>::value_type(id, t));
}

int64_t HpgcJobHandler::start_single_job(const Job& job, const std::string& user_id) {
	Logger::log(STDOUT, DEBUG, ENGINE, "start single job, which is a just a grammer candy of start job flow");
	JobFlow flow;
	flow.job_count = 1;
	flow.jobs.push_back(job);
	return start(flow, user_id); 
}

int64_t HpgcJobHandler::start(const JobFlow& flow, const std::string& user_id) {
	for (int i = 0; i < flow.job_count; i++) {
		cout << "parent count of job " << flow.jobs[i].id << ": " << flow.jobs[i].parent_count << endl;
	}

	Logger::log(STDOUT, INFO, ENGINE, "Start processing " + PROJECT_NAME + " job flow...");
	stringstream msg;
	msg << "number of jobs in this flow: " << flow.job_count;
	Logger::log(STDOUT, DEBUG, ENGINE, msg.str());
	int64_t idleTrackerId;

	pthread_mutex_lock(&poolLock);
	do {
		idleTrackerId = findEmptyPoolSlot();
	} while (idleTrackerId == -1);

	Tracker *activeTracker =  &trackerPool[idleTrackerId];
	activeTracker->setAvailable(false);
	pthread_mutex_unlock(&poolLock);

	activeTracker->setUserJobFlow(flow);
	activeTracker->setUserId(user_id);
	if (createFlowThread(activeTracker) != 0) {
		Logger::log(STDOUT, ERROR, ENGINE, "Create job flow thread failed. Job flow processing is terminated.");
		activeTracker->finalize();
	}
	return static_cast<int64_t>(idleTrackerId);
}

void HpgcJobHandler::pause(const int64_t client_ticket) {
	string sig = "suspend";
	for (int i = 0; i < trackerPool[client_ticket].getJobCount(); i++) {
		JobTracker tracker = trackerPool[client_ticket].getJobTrackerAt(i);
		if (tracker.getStatus() == JobStatus::RUNNING)
			pbs_sigjob(tracker.getConnection(), 
					const_cast<char*>(tracker.getId().c_str()), 
					const_cast<char*>(sig.c_str()), 0);
		else if (tracker.getStatus() == JobStatus::FINISHED) {
			stringstream msg;
			msg << "job " << tracker.getUserJob().id << "is already done.";
			Logger::log(STDOUT, INFO, ENGINE, msg.str());
		}
		else
			pbs_holdjob(tracker.getConnection(), const_cast<char*>(tracker.getId().c_str()), 0, 0);
	}
	Logger::log(STDOUT, INFO, ENGINE, "job flow paused.");
}

void HpgcJobHandler::resume(const int64_t client_ticket) {
	string sig = "resume";
	for (int i = 0; i < trackerPool[client_ticket].getJobCount(); i++) {
		JobTracker tracker = trackerPool[client_ticket].getJobTrackerAt(i);
		if (tracker.getStatus() == JobStatus::PAUSED) {
			pbs_sigjob(tracker.getConnection(), 
					const_cast<char*>(tracker.getId().c_str()), 
					const_cast<char *>(sig.c_str()), 0);
		}		
		else {
			stringstream msg;
			msg << "job " << tracker.getUserJob().id << " hasn't been suspended!";
			Logger::log(STDOUT, WARN, ENGINE, msg.str());
		}
	}
	Logger::log(STDOUT, INFO, ENGINE, "job flow resumed.");
}

void HpgcJobHandler::cancel(const int64_t client_ticket) {
	// need ticket validation!!! by YANG Anran at 20120415
	for (int i = 0; i < trackerPool[client_ticket].getJobCount(); i++) {	
		JobTracker tracker = trackerPool[client_ticket].getJobTrackerAt(i);
		if (tracker.getStatus() != JobStatus::RUNNING && tracker.getStatus() != JobStatus::FAILED ) {
			pbs_deljob(tracker.getConnection(), 
					const_cast<char*>((tracker.getId()).c_str()), 0);
		}
		else {
			stringstream msg;
			msg << "job " << tracker.getUserJob().id << "is already done.";
			Logger::log(STDOUT, INFO, ENGINE, msg.str());
		}
	}
	Logger::log(STDOUT, INFO, ENGINE, "job flow canceled.");
}

void HpgcJobHandler::get_status(Result& _return, const int64_t client_ticket) {
	int status = log->getFlowStatus(client_ticket, _return.message);
	while (status < 0) {
		status = log->getFlowStatus(client_ticket, _return.message);
		if (trackerPool.count(client_ticket) == 0) {
			_return.flow_status = Status::NOT_EXIST;
			_return.message = "get status error, job flow id not exist";
			Logger::log(STDOUT, ERROR, ENGINE, _return.message);
			return;
		}
	}

	_return.flow_status = (Status::type)status;
	//Logger::log(STDOUT, DEBUG, ENGINE, "return status is: " + Utility::intToString(_return.flow_status));
	_return.message = "";

	for (int i = 0; i < log->getJobCount(client_ticket); i++) {
		// !!!! The logistics here implicit that the index of Job in the list is identical to the Job ID !!!!
		JobResult jr;

		string msg = "";
		int jobStatus = log->getJobStatus( client_ticket, i, msg ); 
		while (jobStatus < 0) {
			jr.status = JobStatus::WAITING_FOR_SUBMIT;
			jobStatus = log->getJobStatus( client_ticket, i, msg ); 
		}
		jr.message = msg;
		jr.status = (JobStatus::type)jobStatus; 

		_return.job_result_list.push_back(jr);

		if (_return.flow_status == Status::FINISHED 
				|| _return.flow_status == Status::FAILED ) {
			Severity lvl = INFO;
			Logger::log(STDOUT, lvl, ENGINE, "The result sent to client is: ");
			Logger::log(LOG_FILE, lvl, APPLICATION, "message of job: " + jr.message);	
			Logger::log(STDOUT, lvl, APPLICATION, "message of job: " + jr.message);	
		}
	}
}

void HpgcJobHandler::get_my_requests(std::vector<int64_t> & _return, const std::string& user_id) {
	// warning!!!
	// Not implemente yet. The clients now rely on database for fast implementation
}

void HpgcJobHandler::get_all_requests(std::vector<int64_t> & _return) {
	// warning!!!
	// Not implemente yet. The clients now rely on database for fast implementation
}

int HpgcJobHandler::createFlowThread( Tracker *tracker ) {
	int ret;
	pthread_t tid;
	if ((ret = pthread_create(&tid, 
					NULL,
					&Tracker::flowWorker, 
					tracker)) != 0) {
		return ret;
	}
	return 0;
}

void *HpgcJobHandler::cleanWorker( void *handler ) {
	HpgcJobHandler* master = (HpgcJobHandler*)handler;
	map<int64_t, Tracker>::iterator it = master->trackerPool.begin();
	vector<int64_t> garbageIds;
	unsigned int i;

	do {
		// scan
		while(it != master->trackerPool.end()) {
			if (!(it->second).isAvailable()) {
				if ( (it->second).getStatus() == Status::FAILED 
						|| (it->second).getStatus() == Status::FINISHED) {
					garbageIds.push_back(it->first);
				}
			}
			it++;
		}

		// clean
		for (i = 0; i < garbageIds.size(); i++) {
			master->trackerPool[garbageIds[i]].finalize();
			pthread_mutex_lock(&(master->poolLock));
			master->trackerPool.erase(garbageIds[i]);
			Logger::log(STDOUT, DEBUG, ENGINE, 
					"garbage cleaned, now there are " 
					+ Utility::intToString(master->trackerPool.size()) 
					+ " trackers in pool");
			master->addTracker();
			Logger::log(STDOUT, DEBUG, ENGINE, 
					"new resource added, now there are " 
					+ Utility::intToString(master->trackerPool.size()) 
					+ " trackers in pool");
			pthread_mutex_unlock(&(master->poolLock));
		}

		garbageIds.clear();
		sleep(TRACKER_GC_INTERVAL_S);
		it = master->trackerPool.begin();

	} while(true);
}
