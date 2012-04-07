/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package HPGC.HiGIS.Server;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Job implements org.apache.thrift.TBase<Job, Job._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Job");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField PARENTS_FIELD_DESC = new org.apache.thrift.protocol.TField("parents", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField PARENT_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("parent_count", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField CHILDREN_FIELD_DESC = new org.apache.thrift.protocol.TField("children", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField CHILD_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("child_count", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField APP_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("app_id", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField APP_OPTIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("app_options", org.apache.thrift.protocol.TType.MAP, (short)7);
  private static final org.apache.thrift.protocol.TField RUNTIME_CONTEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("runtime_context", org.apache.thrift.protocol.TType.STRUCT, (short)8);
  private static final org.apache.thrift.protocol.TField APP_URI_FIELD_DESC = new org.apache.thrift.protocol.TField("app_uri", org.apache.thrift.protocol.TType.STRING, (short)9);

  public int id; // required
  public List<Integer> parents; // required
  public int parent_count; // required
  public List<Integer> children; // required
  public int child_count; // required
  public int app_id; // required
  public Map<String,String> app_options; // required
  public Context runtime_context; // required
  public String app_uri; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    PARENTS((short)2, "parents"),
    PARENT_COUNT((short)3, "parent_count"),
    CHILDREN((short)4, "children"),
    CHILD_COUNT((short)5, "child_count"),
    APP_ID((short)6, "app_id"),
    APP_OPTIONS((short)7, "app_options"),
    RUNTIME_CONTEXT((short)8, "runtime_context"),
    APP_URI((short)9, "app_uri");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // PARENTS
          return PARENTS;
        case 3: // PARENT_COUNT
          return PARENT_COUNT;
        case 4: // CHILDREN
          return CHILDREN;
        case 5: // CHILD_COUNT
          return CHILD_COUNT;
        case 6: // APP_ID
          return APP_ID;
        case 7: // APP_OPTIONS
          return APP_OPTIONS;
        case 8: // RUNTIME_CONTEXT
          return RUNTIME_CONTEXT;
        case 9: // APP_URI
          return APP_URI;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ID_ISSET_ID = 0;
  private static final int __PARENT_COUNT_ISSET_ID = 1;
  private static final int __CHILD_COUNT_ISSET_ID = 2;
  private static final int __APP_ID_ISSET_ID = 3;
  private BitSet __isset_bit_vector = new BitSet(4);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PARENTS, new org.apache.thrift.meta_data.FieldMetaData("parents", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.PARENT_COUNT, new org.apache.thrift.meta_data.FieldMetaData("parent_count", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CHILDREN, new org.apache.thrift.meta_data.FieldMetaData("children", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.CHILD_COUNT, new org.apache.thrift.meta_data.FieldMetaData("child_count", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.APP_ID, new org.apache.thrift.meta_data.FieldMetaData("app_id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.APP_OPTIONS, new org.apache.thrift.meta_data.FieldMetaData("app_options", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.RUNTIME_CONTEXT, new org.apache.thrift.meta_data.FieldMetaData("runtime_context", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Context.class)));
    tmpMap.put(_Fields.APP_URI, new org.apache.thrift.meta_data.FieldMetaData("app_uri", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Job.class, metaDataMap);
  }

  public Job() {
  }

  public Job(
    int id,
    List<Integer> parents,
    int parent_count,
    List<Integer> children,
    int child_count,
    int app_id,
    Map<String,String> app_options,
    Context runtime_context,
    String app_uri)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.parents = parents;
    this.parent_count = parent_count;
    setParent_countIsSet(true);
    this.children = children;
    this.child_count = child_count;
    setChild_countIsSet(true);
    this.app_id = app_id;
    setApp_idIsSet(true);
    this.app_options = app_options;
    this.runtime_context = runtime_context;
    this.app_uri = app_uri;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Job(Job other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.id = other.id;
    if (other.isSetParents()) {
      List<Integer> __this__parents = new ArrayList<Integer>();
      for (Integer other_element : other.parents) {
        __this__parents.add(other_element);
      }
      this.parents = __this__parents;
    }
    this.parent_count = other.parent_count;
    if (other.isSetChildren()) {
      List<Integer> __this__children = new ArrayList<Integer>();
      for (Integer other_element : other.children) {
        __this__children.add(other_element);
      }
      this.children = __this__children;
    }
    this.child_count = other.child_count;
    this.app_id = other.app_id;
    if (other.isSetApp_options()) {
      Map<String,String> __this__app_options = new HashMap<String,String>();
      for (Map.Entry<String, String> other_element : other.app_options.entrySet()) {

        String other_element_key = other_element.getKey();
        String other_element_value = other_element.getValue();

        String __this__app_options_copy_key = other_element_key;

        String __this__app_options_copy_value = other_element_value;

        __this__app_options.put(__this__app_options_copy_key, __this__app_options_copy_value);
      }
      this.app_options = __this__app_options;
    }
    if (other.isSetRuntime_context()) {
      this.runtime_context = new Context(other.runtime_context);
    }
    if (other.isSetApp_uri()) {
      this.app_uri = other.app_uri;
    }
  }

  public Job deepCopy() {
    return new Job(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.parents = null;
    setParent_countIsSet(false);
    this.parent_count = 0;
    this.children = null;
    setChild_countIsSet(false);
    this.child_count = 0;
    setApp_idIsSet(false);
    this.app_id = 0;
    this.app_options = null;
    this.runtime_context = null;
    this.app_uri = null;
  }

  public int getId() {
    return this.id;
  }

  public Job setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bit_vector.clear(__ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return __isset_bit_vector.get(__ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bit_vector.set(__ID_ISSET_ID, value);
  }

  public int getParentsSize() {
    return (this.parents == null) ? 0 : this.parents.size();
  }

  public java.util.Iterator<Integer> getParentsIterator() {
    return (this.parents == null) ? null : this.parents.iterator();
  }

  public void addToParents(int elem) {
    if (this.parents == null) {
      this.parents = new ArrayList<Integer>();
    }
    this.parents.add(elem);
  }

  public List<Integer> getParents() {
    return this.parents;
  }

  public Job setParents(List<Integer> parents) {
    this.parents = parents;
    return this;
  }

  public void unsetParents() {
    this.parents = null;
  }

  /** Returns true if field parents is set (has been assigned a value) and false otherwise */
  public boolean isSetParents() {
    return this.parents != null;
  }

  public void setParentsIsSet(boolean value) {
    if (!value) {
      this.parents = null;
    }
  }

  public int getParent_count() {
    return this.parent_count;
  }

  public Job setParent_count(int parent_count) {
    this.parent_count = parent_count;
    setParent_countIsSet(true);
    return this;
  }

  public void unsetParent_count() {
    __isset_bit_vector.clear(__PARENT_COUNT_ISSET_ID);
  }

  /** Returns true if field parent_count is set (has been assigned a value) and false otherwise */
  public boolean isSetParent_count() {
    return __isset_bit_vector.get(__PARENT_COUNT_ISSET_ID);
  }

  public void setParent_countIsSet(boolean value) {
    __isset_bit_vector.set(__PARENT_COUNT_ISSET_ID, value);
  }

  public int getChildrenSize() {
    return (this.children == null) ? 0 : this.children.size();
  }

  public java.util.Iterator<Integer> getChildrenIterator() {
    return (this.children == null) ? null : this.children.iterator();
  }

  public void addToChildren(int elem) {
    if (this.children == null) {
      this.children = new ArrayList<Integer>();
    }
    this.children.add(elem);
  }

  public List<Integer> getChildren() {
    return this.children;
  }

  public Job setChildren(List<Integer> children) {
    this.children = children;
    return this;
  }

  public void unsetChildren() {
    this.children = null;
  }

  /** Returns true if field children is set (has been assigned a value) and false otherwise */
  public boolean isSetChildren() {
    return this.children != null;
  }

  public void setChildrenIsSet(boolean value) {
    if (!value) {
      this.children = null;
    }
  }

  public int getChild_count() {
    return this.child_count;
  }

  public Job setChild_count(int child_count) {
    this.child_count = child_count;
    setChild_countIsSet(true);
    return this;
  }

  public void unsetChild_count() {
    __isset_bit_vector.clear(__CHILD_COUNT_ISSET_ID);
  }

  /** Returns true if field child_count is set (has been assigned a value) and false otherwise */
  public boolean isSetChild_count() {
    return __isset_bit_vector.get(__CHILD_COUNT_ISSET_ID);
  }

  public void setChild_countIsSet(boolean value) {
    __isset_bit_vector.set(__CHILD_COUNT_ISSET_ID, value);
  }

  public int getApp_id() {
    return this.app_id;
  }

  public Job setApp_id(int app_id) {
    this.app_id = app_id;
    setApp_idIsSet(true);
    return this;
  }

  public void unsetApp_id() {
    __isset_bit_vector.clear(__APP_ID_ISSET_ID);
  }

  /** Returns true if field app_id is set (has been assigned a value) and false otherwise */
  public boolean isSetApp_id() {
    return __isset_bit_vector.get(__APP_ID_ISSET_ID);
  }

  public void setApp_idIsSet(boolean value) {
    __isset_bit_vector.set(__APP_ID_ISSET_ID, value);
  }

  public int getApp_optionsSize() {
    return (this.app_options == null) ? 0 : this.app_options.size();
  }

  public void putToApp_options(String key, String val) {
    if (this.app_options == null) {
      this.app_options = new HashMap<String,String>();
    }
    this.app_options.put(key, val);
  }

  public Map<String,String> getApp_options() {
    return this.app_options;
  }

  public Job setApp_options(Map<String,String> app_options) {
    this.app_options = app_options;
    return this;
  }

  public void unsetApp_options() {
    this.app_options = null;
  }

  /** Returns true if field app_options is set (has been assigned a value) and false otherwise */
  public boolean isSetApp_options() {
    return this.app_options != null;
  }

  public void setApp_optionsIsSet(boolean value) {
    if (!value) {
      this.app_options = null;
    }
  }

  public Context getRuntime_context() {
    return this.runtime_context;
  }

  public Job setRuntime_context(Context runtime_context) {
    this.runtime_context = runtime_context;
    return this;
  }

  public void unsetRuntime_context() {
    this.runtime_context = null;
  }

  /** Returns true if field runtime_context is set (has been assigned a value) and false otherwise */
  public boolean isSetRuntime_context() {
    return this.runtime_context != null;
  }

  public void setRuntime_contextIsSet(boolean value) {
    if (!value) {
      this.runtime_context = null;
    }
  }

  public String getApp_uri() {
    return this.app_uri;
  }

  public Job setApp_uri(String app_uri) {
    this.app_uri = app_uri;
    return this;
  }

  public void unsetApp_uri() {
    this.app_uri = null;
  }

  /** Returns true if field app_uri is set (has been assigned a value) and false otherwise */
  public boolean isSetApp_uri() {
    return this.app_uri != null;
  }

  public void setApp_uriIsSet(boolean value) {
    if (!value) {
      this.app_uri = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Integer)value);
      }
      break;

    case PARENTS:
      if (value == null) {
        unsetParents();
      } else {
        setParents((List<Integer>)value);
      }
      break;

    case PARENT_COUNT:
      if (value == null) {
        unsetParent_count();
      } else {
        setParent_count((Integer)value);
      }
      break;

    case CHILDREN:
      if (value == null) {
        unsetChildren();
      } else {
        setChildren((List<Integer>)value);
      }
      break;

    case CHILD_COUNT:
      if (value == null) {
        unsetChild_count();
      } else {
        setChild_count((Integer)value);
      }
      break;

    case APP_ID:
      if (value == null) {
        unsetApp_id();
      } else {
        setApp_id((Integer)value);
      }
      break;

    case APP_OPTIONS:
      if (value == null) {
        unsetApp_options();
      } else {
        setApp_options((Map<String,String>)value);
      }
      break;

    case RUNTIME_CONTEXT:
      if (value == null) {
        unsetRuntime_context();
      } else {
        setRuntime_context((Context)value);
      }
      break;

    case APP_URI:
      if (value == null) {
        unsetApp_uri();
      } else {
        setApp_uri((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return Integer.valueOf(getId());

    case PARENTS:
      return getParents();

    case PARENT_COUNT:
      return Integer.valueOf(getParent_count());

    case CHILDREN:
      return getChildren();

    case CHILD_COUNT:
      return Integer.valueOf(getChild_count());

    case APP_ID:
      return Integer.valueOf(getApp_id());

    case APP_OPTIONS:
      return getApp_options();

    case RUNTIME_CONTEXT:
      return getRuntime_context();

    case APP_URI:
      return getApp_uri();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case PARENTS:
      return isSetParents();
    case PARENT_COUNT:
      return isSetParent_count();
    case CHILDREN:
      return isSetChildren();
    case CHILD_COUNT:
      return isSetChild_count();
    case APP_ID:
      return isSetApp_id();
    case APP_OPTIONS:
      return isSetApp_options();
    case RUNTIME_CONTEXT:
      return isSetRuntime_context();
    case APP_URI:
      return isSetApp_uri();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Job)
      return this.equals((Job)that);
    return false;
  }

  public boolean equals(Job that) {
    if (that == null)
      return false;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_parents = true && this.isSetParents();
    boolean that_present_parents = true && that.isSetParents();
    if (this_present_parents || that_present_parents) {
      if (!(this_present_parents && that_present_parents))
        return false;
      if (!this.parents.equals(that.parents))
        return false;
    }

    boolean this_present_parent_count = true;
    boolean that_present_parent_count = true;
    if (this_present_parent_count || that_present_parent_count) {
      if (!(this_present_parent_count && that_present_parent_count))
        return false;
      if (this.parent_count != that.parent_count)
        return false;
    }

    boolean this_present_children = true && this.isSetChildren();
    boolean that_present_children = true && that.isSetChildren();
    if (this_present_children || that_present_children) {
      if (!(this_present_children && that_present_children))
        return false;
      if (!this.children.equals(that.children))
        return false;
    }

    boolean this_present_child_count = true;
    boolean that_present_child_count = true;
    if (this_present_child_count || that_present_child_count) {
      if (!(this_present_child_count && that_present_child_count))
        return false;
      if (this.child_count != that.child_count)
        return false;
    }

    boolean this_present_app_id = true;
    boolean that_present_app_id = true;
    if (this_present_app_id || that_present_app_id) {
      if (!(this_present_app_id && that_present_app_id))
        return false;
      if (this.app_id != that.app_id)
        return false;
    }

    boolean this_present_app_options = true && this.isSetApp_options();
    boolean that_present_app_options = true && that.isSetApp_options();
    if (this_present_app_options || that_present_app_options) {
      if (!(this_present_app_options && that_present_app_options))
        return false;
      if (!this.app_options.equals(that.app_options))
        return false;
    }

    boolean this_present_runtime_context = true && this.isSetRuntime_context();
    boolean that_present_runtime_context = true && that.isSetRuntime_context();
    if (this_present_runtime_context || that_present_runtime_context) {
      if (!(this_present_runtime_context && that_present_runtime_context))
        return false;
      if (!this.runtime_context.equals(that.runtime_context))
        return false;
    }

    boolean this_present_app_uri = true && this.isSetApp_uri();
    boolean that_present_app_uri = true && that.isSetApp_uri();
    if (this_present_app_uri || that_present_app_uri) {
      if (!(this_present_app_uri && that_present_app_uri))
        return false;
      if (!this.app_uri.equals(that.app_uri))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Job other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Job typedOther = (Job)other;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(typedOther.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, typedOther.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetParents()).compareTo(typedOther.isSetParents());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParents()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parents, typedOther.parents);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetParent_count()).compareTo(typedOther.isSetParent_count());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParent_count()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parent_count, typedOther.parent_count);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChildren()).compareTo(typedOther.isSetChildren());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChildren()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.children, typedOther.children);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChild_count()).compareTo(typedOther.isSetChild_count());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChild_count()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.child_count, typedOther.child_count);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetApp_id()).compareTo(typedOther.isSetApp_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetApp_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.app_id, typedOther.app_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetApp_options()).compareTo(typedOther.isSetApp_options());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetApp_options()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.app_options, typedOther.app_options);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRuntime_context()).compareTo(typedOther.isSetRuntime_context());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRuntime_context()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.runtime_context, typedOther.runtime_context);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetApp_uri()).compareTo(typedOther.isSetApp_uri());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetApp_uri()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.app_uri, typedOther.app_uri);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // ID
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.id = iprot.readI32();
            setIdIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // PARENTS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list9 = iprot.readListBegin();
              this.parents = new ArrayList<Integer>(_list9.size);
              for (int _i10 = 0; _i10 < _list9.size; ++_i10)
              {
                int _elem11; // required
                _elem11 = iprot.readI32();
                this.parents.add(_elem11);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // PARENT_COUNT
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.parent_count = iprot.readI32();
            setParent_countIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // CHILDREN
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list12 = iprot.readListBegin();
              this.children = new ArrayList<Integer>(_list12.size);
              for (int _i13 = 0; _i13 < _list12.size; ++_i13)
              {
                int _elem14; // required
                _elem14 = iprot.readI32();
                this.children.add(_elem14);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // CHILD_COUNT
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.child_count = iprot.readI32();
            setChild_countIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // APP_ID
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.app_id = iprot.readI32();
            setApp_idIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 7: // APP_OPTIONS
          if (field.type == org.apache.thrift.protocol.TType.MAP) {
            {
              org.apache.thrift.protocol.TMap _map15 = iprot.readMapBegin();
              this.app_options = new HashMap<String,String>(2*_map15.size);
              for (int _i16 = 0; _i16 < _map15.size; ++_i16)
              {
                String _key17; // required
                String _val18; // required
                _key17 = iprot.readString();
                _val18 = iprot.readString();
                this.app_options.put(_key17, _val18);
              }
              iprot.readMapEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 8: // RUNTIME_CONTEXT
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.runtime_context = new Context();
            this.runtime_context.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 9: // APP_URI
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.app_uri = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(ID_FIELD_DESC);
    oprot.writeI32(this.id);
    oprot.writeFieldEnd();
    if (this.parents != null) {
      oprot.writeFieldBegin(PARENTS_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, this.parents.size()));
        for (int _iter19 : this.parents)
        {
          oprot.writeI32(_iter19);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(PARENT_COUNT_FIELD_DESC);
    oprot.writeI32(this.parent_count);
    oprot.writeFieldEnd();
    if (this.children != null) {
      oprot.writeFieldBegin(CHILDREN_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, this.children.size()));
        for (int _iter20 : this.children)
        {
          oprot.writeI32(_iter20);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(CHILD_COUNT_FIELD_DESC);
    oprot.writeI32(this.child_count);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(APP_ID_FIELD_DESC);
    oprot.writeI32(this.app_id);
    oprot.writeFieldEnd();
    if (this.app_options != null) {
      oprot.writeFieldBegin(APP_OPTIONS_FIELD_DESC);
      {
        oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, this.app_options.size()));
        for (Map.Entry<String, String> _iter21 : this.app_options.entrySet())
        {
          oprot.writeString(_iter21.getKey());
          oprot.writeString(_iter21.getValue());
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.runtime_context != null) {
      oprot.writeFieldBegin(RUNTIME_CONTEXT_FIELD_DESC);
      this.runtime_context.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.app_uri != null) {
      oprot.writeFieldBegin(APP_URI_FIELD_DESC);
      oprot.writeString(this.app_uri);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Job(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("parents:");
    if (this.parents == null) {
      sb.append("null");
    } else {
      sb.append(this.parents);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("parent_count:");
    sb.append(this.parent_count);
    first = false;
    if (!first) sb.append(", ");
    sb.append("children:");
    if (this.children == null) {
      sb.append("null");
    } else {
      sb.append(this.children);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("child_count:");
    sb.append(this.child_count);
    first = false;
    if (!first) sb.append(", ");
    sb.append("app_id:");
    sb.append(this.app_id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("app_options:");
    if (this.app_options == null) {
      sb.append("null");
    } else {
      sb.append(this.app_options);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("runtime_context:");
    if (this.runtime_context == null) {
      sb.append("null");
    } else {
      sb.append(this.runtime_context);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("app_uri:");
    if (this.app_uri == null) {
      sb.append("null");
    } else {
      sb.append(this.app_uri);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}

