#
# Autogenerated by Thrift Compiler (0.7.0)
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#


class Task
  include ::Thrift::Struct, ::Thrift::Struct_Union
  ID = 1
  PARENTS = 2
  PARENT_COUNT = 3
  CHILDREN = 4
  CHILD_COUNT = 5
  PROCESS_COUNT = 6
  MPI_OPTIONS = 7
  PROGRAM_NAME = 8
  PROGRAM_PARAMS = 9
  PROGRAM_PARAM_COUNT = 10

  FIELDS = {
    ID => {:type => ::Thrift::Types::I32, :name => 'id'},
    PARENTS => {:type => ::Thrift::Types::LIST, :name => 'parents', :element => {:type => ::Thrift::Types::I32}},
    PARENT_COUNT => {:type => ::Thrift::Types::I32, :name => 'parent_count'},
    CHILDREN => {:type => ::Thrift::Types::LIST, :name => 'children', :element => {:type => ::Thrift::Types::I32}},
    CHILD_COUNT => {:type => ::Thrift::Types::I32, :name => 'child_count'},
    PROCESS_COUNT => {:type => ::Thrift::Types::I32, :name => 'process_count'},
    MPI_OPTIONS => {:type => ::Thrift::Types::STRING, :name => 'mpi_options'},
    PROGRAM_NAME => {:type => ::Thrift::Types::STRING, :name => 'program_name'},
    PROGRAM_PARAMS => {:type => ::Thrift::Types::LIST, :name => 'program_params', :element => {:type => ::Thrift::Types::STRING}},
    PROGRAM_PARAM_COUNT => {:type => ::Thrift::Types::I32, :name => 'program_param_count'}
  }

  def struct_fields; FIELDS; end

  def validate
  end

  ::Thrift::Struct.generate_accessors self
end

class JobResult
  include ::Thrift::Struct, ::Thrift::Struct_Union
  STATUS = 1
  RESULT = 2

  FIELDS = {
    STATUS => {:type => ::Thrift::Types::I32, :name => 'status'},
    RESULT => {:type => ::Thrift::Types::STRING, :name => 'result'}
  }

  def struct_fields; FIELDS; end

  def validate
  end

  ::Thrift::Struct.generate_accessors self
end

class Job
  include ::Thrift::Struct, ::Thrift::Struct_Union
  TASKS = 1
  TASK_COUNT = 2
  CHECKSUM = 3

  FIELDS = {
    TASKS => {:type => ::Thrift::Types::LIST, :name => 'tasks', :element => {:type => ::Thrift::Types::STRUCT, :class => Task}},
    TASK_COUNT => {:type => ::Thrift::Types::I32, :name => 'task_count'},
    CHECKSUM => {:type => ::Thrift::Types::STRING, :name => 'checksum'}
  }

  def struct_fields; FIELDS; end

  def validate
  end

  ::Thrift::Struct.generate_accessors self
end

class HpgcAppException < ::Thrift::Exception
  include ::Thrift::Struct, ::Thrift::Struct_Union
  PID = 1
  NAME = 2
  MESSAGE = 3

  FIELDS = {
    PID => {:type => ::Thrift::Types::I32, :name => 'pid'},
    NAME => {:type => ::Thrift::Types::STRING, :name => 'name'},
    MESSAGE => {:type => ::Thrift::Types::STRING, :name => 'message'}
  }

  def struct_fields; FIELDS; end

  def validate
  end

  ::Thrift::Struct.generate_accessors self
end
