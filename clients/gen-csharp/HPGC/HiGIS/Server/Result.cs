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
  public partial class Result : TBase
  {
    private int _status;
    private string _message;
    private double _progress;

    public int Status
    {
      get
      {
        return _status;
      }
      set
      {
        __isset.status = true;
        this._status = value;
      }
    }

    public string Message
    {
      get
      {
        return _message;
      }
      set
      {
        __isset.message = true;
        this._message = value;
      }
    }

    public double Progress
    {
      get
      {
        return _progress;
      }
      set
      {
        __isset.progress = true;
        this._progress = value;
      }
    }


    public Isset __isset;
    [Serializable]
    public struct Isset {
      public bool status;
      public bool message;
      public bool progress;
    }

    public Result() {
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
            if (field.Type == TType.I32) {
              Status = iprot.ReadI32();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 2:
            if (field.Type == TType.String) {
              Message = iprot.ReadString();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 3:
            if (field.Type == TType.Double) {
              Progress = iprot.ReadDouble();
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
      TStruct struc = new TStruct("Result");
      oprot.WriteStructBegin(struc);
      TField field = new TField();
      if (__isset.status) {
        field.Name = "status";
        field.Type = TType.I32;
        field.ID = 1;
        oprot.WriteFieldBegin(field);
        oprot.WriteI32(Status);
        oprot.WriteFieldEnd();
      }
      if (Message != null && __isset.message) {
        field.Name = "message";
        field.Type = TType.String;
        field.ID = 2;
        oprot.WriteFieldBegin(field);
        oprot.WriteString(Message);
        oprot.WriteFieldEnd();
      }
      if (__isset.progress) {
        field.Name = "progress";
        field.Type = TType.Double;
        field.ID = 3;
        oprot.WriteFieldBegin(field);
        oprot.WriteDouble(Progress);
        oprot.WriteFieldEnd();
      }
      oprot.WriteFieldStop();
      oprot.WriteStructEnd();
    }

    public override string ToString() {
      StringBuilder sb = new StringBuilder("Result(");
      sb.Append("Status: ");
      sb.Append(Status);
      sb.Append(",Message: ");
      sb.Append(Message);
      sb.Append(",Progress: ");
      sb.Append(Progress);
      sb.Append(")");
      return sb.ToString();
    }

  }

}
