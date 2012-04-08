/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef hpgcjob_TYPES_H
#define hpgcjob_TYPES_H

#include <Thrift.h>
#include <TApplicationException.h>
#include <protocol/TProtocol.h>
#include <transport/TTransport.h>



namespace HPGC { namespace HiGIS { namespace Server {

struct ParallelEnv {
  enum type {
    MPI = 1,
    OPENMP = 2,
    CUDA = 3,
    MAPREDUCE = 4
  };
};

extern const std::map<int, const char*> _ParallelEnv_VALUES_TO_NAMES;

struct JobStatus {
  enum type {
    FINISHED = 1,
    RUNNING = 2,
    WAITING_FOR_SUBMIT = 3,
    QUEUING = 4,
    FAILED = 5,
    NOT_EXIST = 6,
    PAUSED = 7
  };
};

extern const std::map<int, const char*> _JobStatus_VALUES_TO_NAMES;

struct Status {
  enum type {
    FINISHED = 1,
    RUNNING = 2,
    FAILED = 3,
    NOT_EXIST = 4
  };
};

extern const std::map<int, const char*> _Status_VALUES_TO_NAMES;

typedef struct _Context__isset {
  _Context__isset() : parallel_env(false), options(false) {}
  bool parallel_env;
  bool options;
} _Context__isset;

class Context {
 public:

  static const char* ascii_fingerprint; // = "B089C846F881A6F18D64AA924E6643EF";
  static const uint8_t binary_fingerprint[16]; // = {0xB0,0x89,0xC8,0x46,0xF8,0x81,0xA6,0xF1,0x8D,0x64,0xAA,0x92,0x4E,0x66,0x43,0xEF};

  Context() : parallel_env((ParallelEnv::type)0) {
  }

  virtual ~Context() throw() {}

  ParallelEnv::type parallel_env;
  std::map<std::string, std::string>  options;

  _Context__isset __isset;

  void __set_parallel_env(const ParallelEnv::type val) {
    parallel_env = val;
  }

  void __set_options(const std::map<std::string, std::string> & val) {
    options = val;
  }

  bool operator == (const Context & rhs) const
  {
    if (!(parallel_env == rhs.parallel_env))
      return false;
    if (!(options == rhs.options))
      return false;
    return true;
  }
  bool operator != (const Context &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Context & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _Job__isset {
  _Job__isset() : id(false), parents(false), parent_count(false), children(false), child_count(false), app_id(false), app_options(false), runtime_context(false), app_uri(false) {}
  bool id;
  bool parents;
  bool parent_count;
  bool children;
  bool child_count;
  bool app_id;
  bool app_options;
  bool runtime_context;
  bool app_uri;
} _Job__isset;

class Job {
 public:

  static const char* ascii_fingerprint; // = "AAB3E23D0CA517D25ADE9C7E5242001C";
  static const uint8_t binary_fingerprint[16]; // = {0xAA,0xB3,0xE2,0x3D,0x0C,0xA5,0x17,0xD2,0x5A,0xDE,0x9C,0x7E,0x52,0x42,0x00,0x1C};

  Job() : id(0), parent_count(0), child_count(0), app_id(0), app_uri("") {
  }

  virtual ~Job() throw() {}

  int32_t id;
  std::vector<int32_t>  parents;
  int32_t parent_count;
  std::vector<int32_t>  children;
  int32_t child_count;
  int32_t app_id;
  std::map<std::string, std::string>  app_options;
  Context runtime_context;
  std::string app_uri;

  _Job__isset __isset;

  void __set_id(const int32_t val) {
    id = val;
  }

  void __set_parents(const std::vector<int32_t> & val) {
    parents = val;
  }

  void __set_parent_count(const int32_t val) {
    parent_count = val;
  }

  void __set_children(const std::vector<int32_t> & val) {
    children = val;
  }

  void __set_child_count(const int32_t val) {
    child_count = val;
  }

  void __set_app_id(const int32_t val) {
    app_id = val;
  }

  void __set_app_options(const std::map<std::string, std::string> & val) {
    app_options = val;
  }

  void __set_runtime_context(const Context& val) {
    runtime_context = val;
  }

  void __set_app_uri(const std::string& val) {
    app_uri = val;
  }

  bool operator == (const Job & rhs) const
  {
    if (!(id == rhs.id))
      return false;
    if (!(parents == rhs.parents))
      return false;
    if (!(parent_count == rhs.parent_count))
      return false;
    if (!(children == rhs.children))
      return false;
    if (!(child_count == rhs.child_count))
      return false;
    if (!(app_id == rhs.app_id))
      return false;
    if (!(app_options == rhs.app_options))
      return false;
    if (!(runtime_context == rhs.runtime_context))
      return false;
    if (!(app_uri == rhs.app_uri))
      return false;
    return true;
  }
  bool operator != (const Job &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Job & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _JobResult__isset {
  _JobResult__isset() : message(false), progress(false), status(false) {}
  bool message;
  bool progress;
  bool status;
} _JobResult__isset;

class JobResult {
 public:

  static const char* ascii_fingerprint; // = "51553B00ECD9218B9C31C1EAEC5BD7E5";
  static const uint8_t binary_fingerprint[16]; // = {0x51,0x55,0x3B,0x00,0xEC,0xD9,0x21,0x8B,0x9C,0x31,0xC1,0xEA,0xEC,0x5B,0xD7,0xE5};

  JobResult() : message(""), progress(0), status((JobStatus::type)0) {
  }

  virtual ~JobResult() throw() {}

  std::string message;
  double progress;
  JobStatus::type status;

  _JobResult__isset __isset;

  void __set_message(const std::string& val) {
    message = val;
  }

  void __set_progress(const double val) {
    progress = val;
  }

  void __set_status(const JobStatus::type val) {
    status = val;
  }

  bool operator == (const JobResult & rhs) const
  {
    if (!(message == rhs.message))
      return false;
    if (!(progress == rhs.progress))
      return false;
    if (!(status == rhs.status))
      return false;
    return true;
  }
  bool operator != (const JobResult &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const JobResult & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _Result__isset {
  _Result__isset() : flow_status(false), message(false), progress(false), job_result_list(false) {}
  bool flow_status;
  bool message;
  bool progress;
  bool job_result_list;
} _Result__isset;

class Result {
 public:

  static const char* ascii_fingerprint; // = "83883B3EB12F9C025FF62E89D0830807";
  static const uint8_t binary_fingerprint[16]; // = {0x83,0x88,0x3B,0x3E,0xB1,0x2F,0x9C,0x02,0x5F,0xF6,0x2E,0x89,0xD0,0x83,0x08,0x07};

  Result() : flow_status((Status::type)0), message(""), progress(0) {
  }

  virtual ~Result() throw() {}

  Status::type flow_status;
  std::string message;
  double progress;
  std::vector<JobResult>  job_result_list;

  _Result__isset __isset;

  void __set_flow_status(const Status::type val) {
    flow_status = val;
  }

  void __set_message(const std::string& val) {
    message = val;
  }

  void __set_progress(const double val) {
    progress = val;
  }

  void __set_job_result_list(const std::vector<JobResult> & val) {
    job_result_list = val;
  }

  bool operator == (const Result & rhs) const
  {
    if (!(flow_status == rhs.flow_status))
      return false;
    if (!(message == rhs.message))
      return false;
    if (!(progress == rhs.progress))
      return false;
    if (!(job_result_list == rhs.job_result_list))
      return false;
    return true;
  }
  bool operator != (const Result &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Result & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _JobFlow__isset {
  _JobFlow__isset() : jobs(false), job_count(false) {}
  bool jobs;
  bool job_count;
} _JobFlow__isset;

class JobFlow {
 public:

  static const char* ascii_fingerprint; // = "E4017BBEAB7C3A641127D8FB9488B421";
  static const uint8_t binary_fingerprint[16]; // = {0xE4,0x01,0x7B,0xBE,0xAB,0x7C,0x3A,0x64,0x11,0x27,0xD8,0xFB,0x94,0x88,0xB4,0x21};

  JobFlow() : job_count(0) {
  }

  virtual ~JobFlow() throw() {}

  std::vector<Job>  jobs;
  int32_t job_count;

  _JobFlow__isset __isset;

  void __set_jobs(const std::vector<Job> & val) {
    jobs = val;
  }

  void __set_job_count(const int32_t val) {
    job_count = val;
  }

  bool operator == (const JobFlow & rhs) const
  {
    if (!(jobs == rhs.jobs))
      return false;
    if (!(job_count == rhs.job_count))
      return false;
    return true;
  }
  bool operator != (const JobFlow &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const JobFlow & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

typedef struct _HpgcJobException__isset {
  _HpgcJobException__isset() : app_id(false), name(false), message(false) {}
  bool app_id;
  bool name;
  bool message;
} _HpgcJobException__isset;

class HpgcJobException : public ::apache::thrift::TException {
 public:

  static const char* ascii_fingerprint; // = "3368C2F81F2FEF71F11EDACDB2A3ECEF";
  static const uint8_t binary_fingerprint[16]; // = {0x33,0x68,0xC2,0xF8,0x1F,0x2F,0xEF,0x71,0xF1,0x1E,0xDA,0xCD,0xB2,0xA3,0xEC,0xEF};

  HpgcJobException() : app_id(0), name(""), message("") {
  }

  virtual ~HpgcJobException() throw() {}

  int32_t app_id;
  std::string name;
  std::string message;

  _HpgcJobException__isset __isset;

  void __set_app_id(const int32_t val) {
    app_id = val;
  }

  void __set_name(const std::string& val) {
    name = val;
  }

  void __set_message(const std::string& val) {
    message = val;
  }

  bool operator == (const HpgcJobException & rhs) const
  {
    if (!(app_id == rhs.app_id))
      return false;
    if (!(name == rhs.name))
      return false;
    if (!(message == rhs.message))
      return false;
    return true;
  }
  bool operator != (const HpgcJobException &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const HpgcJobException & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

}}} // namespace

#endif
