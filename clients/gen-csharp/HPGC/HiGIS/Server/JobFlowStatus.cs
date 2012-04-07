/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
using System.IO;
using Thrift;
using Thrift.Collections;
using Thrift.Protocol;
using Thrift.Transport;
namespace HPGC.HiGIS.Server
{

  [Serializable]
  public partial class JobFlowStatus : TBase
  {
    private List<JobStatus> _job_status_list;

    public List<JobStatus> Job_status_list
    {
      get
      {
        return _job_status_list;
      }
      set
      {
        __isset.job_status_list = true;
        this._job_status_list = value;
      }
    }


    public Isset __isset;
    [Serializable]
    public struct Isset {
      public bool job_status_list;
    }

    public JobFlowStatus() {
    }

    public void Read (TProtocol iprot)
    {
      TField field;
      iprot.ReadStructBegin();
      while (true)
      {
        field = iprot.ReadFieldBegin();
        if (field.Type == TType.Stop) { 
          break;
        }
        switch (field.ID)
        {
          case 1:
            if (field.Type == TType.List) {
              {
                Job_status_list = new List<JobStatus>();
                TList _list0 = iprot.ReadListBegin();
                for( int _i1 = 0; _i1 < _list0.Count; ++_i1)
                {
                  JobStatus _elem2 = (JobStatus)0;
                  _elem2 = (JobStatus)iprot.ReadI32();
                  Job_status_list.Add(_elem2);
                }
                iprot.ReadListEnd();
              }
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          default: 
            TProtocolUtil.Skip(iprot, field.Type);
            break;
        }
        iprot.ReadFieldEnd();
      }
      iprot.ReadStructEnd();
    }

    public void Write(TProtocol oprot) {
      TStruct struc = new TStruct("JobFlowStatus");
      oprot.WriteStructBegin(struc);
      TField field = new TField();
      if (Job_status_list != null && __isset.job_status_list) {
        field.Name = "job_status_list";
        field.Type = TType.List;
        field.ID = 1;
        oprot.WriteFieldBegin(field);
        {
          oprot.WriteListBegin(new TList(TType.I32, Job_status_list.Count));
          foreach (JobStatus _iter3 in Job_status_list)
          {
            oprot.WriteI32((int)_iter3);
          }
          oprot.WriteListEnd();
        }
        oprot.WriteFieldEnd();
      }
      oprot.WriteFieldStop();
      oprot.WriteStructEnd();
    }

    public override string ToString() {
      StringBuilder sb = new StringBuilder("JobFlowStatus(");
      sb.Append("Job_status_list: ");
      sb.Append(Job_status_list);
      sb.Append(")");
      return sb.ToString();
    }

  }

}
