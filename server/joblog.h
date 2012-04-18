/*
 * =====================================================================================
 *
 *       Filename:  joblog.h
 *
 *    Description:  
 *
 *        Version:  0.8
 *        Created:  04/08/2012 03:13:05 PM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  WU Jiani
 *         Updator: LIU Lu, YANG Anran
 *   Organization:  
 *
 * =====================================================================================
 */
#include <stdint.h>
#include <stdbool.h>
#include <string>
#include <iostream>
#include <fstream>
#include <vector>
#include <mysql/mysql.h>  


#ifndef  JOBLOG_H_
#define  JOBLOG_H_

using namespace std;

const string PBS_JOB_TABLE_NAME = "gdos_sys_pbsjob";
const string JOB_TABLE_NAME = "gdos_sys_job";
const string JOB_FLOW_TABLE_NAME = "gdos_sys_jobflow";
const string DB_SERVER = "127.0.0.1";
const string DB_USER = "myuser";
const string DB_PASSWORD = "mypassword";
const string DB_NAME = "higis";
const int DB_PORT = 3306;
const int MAX_DB_CONN_NUM = 10; // remember to ensure the db max_connections settings is higher than this

class JobLog {
	private:
		string hosts;
		string userName;
		string password;
		string dbName;
		vector<MYSQL*> connPool;
		vector<pthread_mutex_t*> connLock; // true if free
		static JobLog *m_instance;
		int port;

		JobLog();
		~JobLog();
		JobLog(JobLog const&);
		void operator=(JobLog const&);

		MYSQL *createConn();
		string registerPbsJobSql( int64_t, int, const string&);
		string registerJobSql(int64_t, int, const string&);
		string registerJobFlowSql(int64_t, const string&);
		string updateJobStatusSql(int64_t, int, int, const string&);
		string getPbsJobStatusSql( int64_t, int);
		string getFlowStatusSql( int64_t );
		string getJobStatusSql( int64_t, int );
		string getJobCountSql( int64_t flowId );
		string updateJobFlowStatusSql(int64_t, int, const string&);
		int command(const string&);
		MYSQL_RES* query( const string & );
		MYSQL* borrowConnection();
		int returnConnection(MYSQL *);
		string getCurrentTime();
	public:
		int registerPbsJob(int64_t, int, const string&);
		int registerJob(int64_t, int, const string&);
		int registerJobFlow(int64_t, const string&);
		int updateJobStatus(int64_t, int, int, const string&);
		int updateJobFlowStatus(int64_t, int, const string&);
		int getJobCount( int64_t flowId );
		char getPbsJobStatus( int64_t, int );
		int getFlowStatus( int64_t, string& );
		int getJobStatus( int64_t, int, string& );
		static JobLog *Instance();
};

#endif
