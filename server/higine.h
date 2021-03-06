/*
 * =====================================================================================
 *
 *       Filename:  higine.h
 *
 *    Description:  define the necessary dependencies of higisen main program 
 *
 *        Version:  1.0
 *        Created:  03/12/2012 09:47:27 AM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  LIU Lu (), luliu@nudt.edu.cn
 *   Organization:  
 *
 * =====================================================================================
 */
#ifndef _HIGINE_H_
#define _HIGINE_H_
//#include <thrift>
// this is for PBS-like HPC job scheduler
//#include <jobscheduler> 
// this is for accessing hpgc app metadata databse
//#include <dbclient>
// this is for managing the user-submitted job
//#include <jobmanager>
#include <concurrency/ThreadManager.h>
#include <concurrency/PosixThreadFactory.h>
#include <protocol/TBinaryProtocol.h>
#include <server/TSimpleServer.h>
#include <server/TNonblockingServer.h>
#include <transport/TServerSocket.h>
#include <transport/TBufferTransports.h>

using namespace ::apache::thrift;
using namespace ::apache::thrift::protocol;
using namespace ::apache::thrift::transport;
using namespace ::apache::thrift::server;
using namespace ::apache::thrift::concurrency;

#endif
