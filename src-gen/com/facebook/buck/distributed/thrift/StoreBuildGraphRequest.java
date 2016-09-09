/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.buck.distributed.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-09-05")
public class StoreBuildGraphRequest implements org.apache.thrift.TBase<StoreBuildGraphRequest, StoreBuildGraphRequest._Fields>, java.io.Serializable, Cloneable, Comparable<StoreBuildGraphRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("StoreBuildGraphRequest");

  private static final org.apache.thrift.protocol.TField BUILD_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("buildId", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField BUILD_GRAPH_FIELD_DESC = new org.apache.thrift.protocol.TField("buildGraph", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new StoreBuildGraphRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new StoreBuildGraphRequestTupleSchemeFactory());
  }

  public BuildId buildId; // optional
  public ByteBuffer buildGraph; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BUILD_ID((short)1, "buildId"),
    BUILD_GRAPH((short)2, "buildGraph");

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
        case 1: // BUILD_ID
          return BUILD_ID;
        case 2: // BUILD_GRAPH
          return BUILD_GRAPH;
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
  private static final _Fields optionals[] = {_Fields.BUILD_ID,_Fields.BUILD_GRAPH};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BUILD_ID, new org.apache.thrift.meta_data.FieldMetaData("buildId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, BuildId.class)));
    tmpMap.put(_Fields.BUILD_GRAPH, new org.apache.thrift.meta_data.FieldMetaData("buildGraph", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(StoreBuildGraphRequest.class, metaDataMap);
  }

  public StoreBuildGraphRequest() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public StoreBuildGraphRequest(StoreBuildGraphRequest other) {
    if (other.isSetBuildId()) {
      this.buildId = new BuildId(other.buildId);
    }
    if (other.isSetBuildGraph()) {
      this.buildGraph = org.apache.thrift.TBaseHelper.copyBinary(other.buildGraph);
    }
  }

  public StoreBuildGraphRequest deepCopy() {
    return new StoreBuildGraphRequest(this);
  }

  @Override
  public void clear() {
    this.buildId = null;
    this.buildGraph = null;
  }

  public BuildId getBuildId() {
    return this.buildId;
  }

  public StoreBuildGraphRequest setBuildId(BuildId buildId) {
    this.buildId = buildId;
    return this;
  }

  public void unsetBuildId() {
    this.buildId = null;
  }

  /** Returns true if field buildId is set (has been assigned a value) and false otherwise */
  public boolean isSetBuildId() {
    return this.buildId != null;
  }

  public void setBuildIdIsSet(boolean value) {
    if (!value) {
      this.buildId = null;
    }
  }

  public byte[] getBuildGraph() {
    setBuildGraph(org.apache.thrift.TBaseHelper.rightSize(buildGraph));
    return buildGraph == null ? null : buildGraph.array();
  }

  public ByteBuffer bufferForBuildGraph() {
    return org.apache.thrift.TBaseHelper.copyBinary(buildGraph);
  }

  public StoreBuildGraphRequest setBuildGraph(byte[] buildGraph) {
    this.buildGraph = buildGraph == null ? (ByteBuffer)null : ByteBuffer.wrap(Arrays.copyOf(buildGraph, buildGraph.length));
    return this;
  }

  public StoreBuildGraphRequest setBuildGraph(ByteBuffer buildGraph) {
    this.buildGraph = org.apache.thrift.TBaseHelper.copyBinary(buildGraph);
    return this;
  }

  public void unsetBuildGraph() {
    this.buildGraph = null;
  }

  /** Returns true if field buildGraph is set (has been assigned a value) and false otherwise */
  public boolean isSetBuildGraph() {
    return this.buildGraph != null;
  }

  public void setBuildGraphIsSet(boolean value) {
    if (!value) {
      this.buildGraph = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case BUILD_ID:
      if (value == null) {
        unsetBuildId();
      } else {
        setBuildId((BuildId)value);
      }
      break;

    case BUILD_GRAPH:
      if (value == null) {
        unsetBuildGraph();
      } else {
        setBuildGraph((ByteBuffer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case BUILD_ID:
      return getBuildId();

    case BUILD_GRAPH:
      return getBuildGraph();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case BUILD_ID:
      return isSetBuildId();
    case BUILD_GRAPH:
      return isSetBuildGraph();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof StoreBuildGraphRequest)
      return this.equals((StoreBuildGraphRequest)that);
    return false;
  }

  public boolean equals(StoreBuildGraphRequest that) {
    if (that == null)
      return false;

    boolean this_present_buildId = true && this.isSetBuildId();
    boolean that_present_buildId = true && that.isSetBuildId();
    if (this_present_buildId || that_present_buildId) {
      if (!(this_present_buildId && that_present_buildId))
        return false;
      if (!this.buildId.equals(that.buildId))
        return false;
    }

    boolean this_present_buildGraph = true && this.isSetBuildGraph();
    boolean that_present_buildGraph = true && that.isSetBuildGraph();
    if (this_present_buildGraph || that_present_buildGraph) {
      if (!(this_present_buildGraph && that_present_buildGraph))
        return false;
      if (!this.buildGraph.equals(that.buildGraph))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_buildId = true && (isSetBuildId());
    list.add(present_buildId);
    if (present_buildId)
      list.add(buildId);

    boolean present_buildGraph = true && (isSetBuildGraph());
    list.add(present_buildGraph);
    if (present_buildGraph)
      list.add(buildGraph);

    return list.hashCode();
  }

  @Override
  public int compareTo(StoreBuildGraphRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetBuildId()).compareTo(other.isSetBuildId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBuildId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.buildId, other.buildId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBuildGraph()).compareTo(other.isSetBuildGraph());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBuildGraph()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.buildGraph, other.buildGraph);
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
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("StoreBuildGraphRequest(");
    boolean first = true;

    if (isSetBuildId()) {
      sb.append("buildId:");
      if (this.buildId == null) {
        sb.append("null");
      } else {
        sb.append(this.buildId);
      }
      first = false;
    }
    if (isSetBuildGraph()) {
      if (!first) sb.append(", ");
      sb.append("buildGraph:");
      if (this.buildGraph == null) {
        sb.append("null");
      } else {
        org.apache.thrift.TBaseHelper.toString(this.buildGraph, sb);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (buildId != null) {
      buildId.validate();
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class StoreBuildGraphRequestStandardSchemeFactory implements SchemeFactory {
    public StoreBuildGraphRequestStandardScheme getScheme() {
      return new StoreBuildGraphRequestStandardScheme();
    }
  }

  private static class StoreBuildGraphRequestStandardScheme extends StandardScheme<StoreBuildGraphRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, StoreBuildGraphRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BUILD_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.buildId = new BuildId();
              struct.buildId.read(iprot);
              struct.setBuildIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BUILD_GRAPH
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.buildGraph = iprot.readBinary();
              struct.setBuildGraphIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, StoreBuildGraphRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.buildId != null) {
        if (struct.isSetBuildId()) {
          oprot.writeFieldBegin(BUILD_ID_FIELD_DESC);
          struct.buildId.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.buildGraph != null) {
        if (struct.isSetBuildGraph()) {
          oprot.writeFieldBegin(BUILD_GRAPH_FIELD_DESC);
          oprot.writeBinary(struct.buildGraph);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class StoreBuildGraphRequestTupleSchemeFactory implements SchemeFactory {
    public StoreBuildGraphRequestTupleScheme getScheme() {
      return new StoreBuildGraphRequestTupleScheme();
    }
  }

  private static class StoreBuildGraphRequestTupleScheme extends TupleScheme<StoreBuildGraphRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, StoreBuildGraphRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetBuildId()) {
        optionals.set(0);
      }
      if (struct.isSetBuildGraph()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetBuildId()) {
        struct.buildId.write(oprot);
      }
      if (struct.isSetBuildGraph()) {
        oprot.writeBinary(struct.buildGraph);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, StoreBuildGraphRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.buildId = new BuildId();
        struct.buildId.read(iprot);
        struct.setBuildIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.buildGraph = iprot.readBinary();
        struct.setBuildGraphIsSet(true);
      }
    }
  }

}

