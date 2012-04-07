/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package HPGC.HiGIS.Server;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum JobStatus implements org.apache.thrift.TEnum {
  FINISHED(1),
  RUNNING(2),
  WAITING_FOR_SUBMIT(3),
  QUEUING(4),
  EXIT_WITH_ERROR(5);

  private final int value;

  private JobStatus(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static JobStatus findByValue(int value) { 
    switch (value) {
      case 1:
        return FINISHED;
      case 2:
        return RUNNING;
      case 3:
        return WAITING_FOR_SUBMIT;
      case 4:
        return QUEUING;
      case 5:
        return EXIT_WITH_ERROR;
      default:
        return null;
    }
  }
}
