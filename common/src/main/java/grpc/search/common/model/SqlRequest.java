// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SqlDataService.proto

package grpc.search.common.model;

import com.google.protobuf.AbstractMessageLite;

/**
 * <pre>
 *todo 缺少是否使用缓存，是否允许数据缓存
 * The request message containing the user's name.
 * </pre>
 *
 * Protobuf type {@code helloworld.SqlRequest}
 */
public  final class SqlRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:helloworld.SqlRequest)
    SqlRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SqlRequest.newBuilder() to construct.
  private SqlRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SqlRequest() {
    name_ = "";
    token_ = "";
    sql_ = "";
    type_ = "";
    roleId_ = "";
    dataSourceName_ = "";
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SqlRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            token_ = s;
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            sql_ = s;
            break;
          }
          case 34: {
            String s = input.readStringRequireUtf8();

            type_ = s;
            break;
          }
          case 42: {
            String s = input.readStringRequireUtf8();

            roleId_ = s;
            break;
          }
          case 50: {
            String s = input.readStringRequireUtf8();

            dataSourceName_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return SqlServerProto.internal_static_helloworld_SqlRequest_descriptor;
  }

  @Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return SqlServerProto.internal_static_helloworld_SqlRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            SqlRequest.class, SqlRequest.Builder.class);
  }

  public static final int NAME_FIELD_NUMBER = 1;
  private volatile Object name_;
  /**
   * <code>string name = 1;</code>
   */
  public String getName() {
    Object ref = name_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 1;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    Object ref = name_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TOKEN_FIELD_NUMBER = 2;
  private volatile Object token_;
  /**
   * <code>string token = 2;</code>
   */
  public String getToken() {
    Object ref = token_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      token_ = s;
      return s;
    }
  }
  /**
   * <code>string token = 2;</code>
   */
  public com.google.protobuf.ByteString
      getTokenBytes() {
    Object ref = token_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      token_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SQL_FIELD_NUMBER = 3;
  private volatile Object sql_;
  /**
   * <code>string sql = 3;</code>
   */
  public String getSql() {
    Object ref = sql_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      sql_ = s;
      return s;
    }
  }
  /**
   * <code>string sql = 3;</code>
   */
  public com.google.protobuf.ByteString
      getSqlBytes() {
    Object ref = sql_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      sql_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TYPE_FIELD_NUMBER = 4;
  private volatile Object type_;
  /**
   * <code>string type = 4;</code>
   */
  public String getType() {
    Object ref = type_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      type_ = s;
      return s;
    }
  }
  /**
   * <code>string type = 4;</code>
   */
  public com.google.protobuf.ByteString
      getTypeBytes() {
    Object ref = type_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      type_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ROLEID_FIELD_NUMBER = 5;
  private volatile Object roleId_;
  /**
   * <code>string roleId = 5;</code>
   */
  public String getRoleId() {
    Object ref = roleId_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      roleId_ = s;
      return s;
    }
  }
  /**
   * <code>string roleId = 5;</code>
   */
  public com.google.protobuf.ByteString
      getRoleIdBytes() {
    Object ref = roleId_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      roleId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DATASOURCENAME_FIELD_NUMBER = 6;
  private volatile Object dataSourceName_;
  /**
   * <code>string dataSourceName = 6;</code>
   */
  public String getDataSourceName() {
    Object ref = dataSourceName_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      dataSourceName_ = s;
      return s;
    }
  }
  /**
   * <code>string dataSourceName = 6;</code>
   */
  public com.google.protobuf.ByteString
      getDataSourceNameBytes() {
    Object ref = dataSourceName_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      dataSourceName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (!getTokenBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, token_);
    }
    if (!getSqlBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, sql_);
    }
    if (!getTypeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, type_);
    }
    if (!getRoleIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, roleId_);
    }
    if (!getDataSourceNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, dataSourceName_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (!getTokenBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, token_);
    }
    if (!getSqlBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, sql_);
    }
    if (!getTypeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, type_);
    }
    if (!getRoleIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, roleId_);
    }
    if (!getDataSourceNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, dataSourceName_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof SqlRequest)) {
      return super.equals(obj);
    }
    SqlRequest other = (SqlRequest) obj;

    boolean result = true;
    result = result && getName()
        .equals(other.getName());
    result = result && getToken()
        .equals(other.getToken());
    result = result && getSql()
        .equals(other.getSql());
    result = result && getType()
        .equals(other.getType());
    result = result && getRoleId()
        .equals(other.getRoleId());
    result = result && getDataSourceName()
        .equals(other.getDataSourceName());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + TOKEN_FIELD_NUMBER;
    hash = (53 * hash) + getToken().hashCode();
    hash = (37 * hash) + SQL_FIELD_NUMBER;
    hash = (53 * hash) + getSql().hashCode();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getType().hashCode();
    hash = (37 * hash) + ROLEID_FIELD_NUMBER;
    hash = (53 * hash) + getRoleId().hashCode();
    hash = (37 * hash) + DATASOURCENAME_FIELD_NUMBER;
    hash = (53 * hash) + getDataSourceName().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static SqlRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SqlRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SqlRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SqlRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SqlRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SqlRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SqlRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static SqlRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static SqlRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static SqlRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static SqlRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static SqlRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(SqlRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *todo 缺少是否使用缓存，是否允许数据缓存
   * The request message containing the user's name.
   * </pre>
   *
   * Protobuf type {@code helloworld.SqlRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:helloworld.SqlRequest)
      SqlRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return SqlServerProto.internal_static_helloworld_SqlRequest_descriptor;
    }

    @Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return SqlServerProto.internal_static_helloworld_SqlRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              SqlRequest.class, SqlRequest.Builder.class);
    }

    // Construct using SqlRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      name_ = "";

      token_ = "";

      sql_ = "";

      type_ = "";

      roleId_ = "";

      dataSourceName_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return SqlServerProto.internal_static_helloworld_SqlRequest_descriptor;
    }

    @Override
    public SqlRequest getDefaultInstanceForType() {
      return SqlRequest.getDefaultInstance();
    }

    @Override
    public SqlRequest build() {
      SqlRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw Builder.newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public SqlRequest buildPartial() {
      SqlRequest result = new SqlRequest(this);
      result.name_ = name_;
      result.token_ = token_;
      result.sql_ = sql_;
      result.type_ = type_;
      result.roleId_ = roleId_;
      result.dataSourceName_ = dataSourceName_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof SqlRequest) {
        return mergeFrom((SqlRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(SqlRequest other) {
      if (other == SqlRequest.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (!other.getToken().isEmpty()) {
        token_ = other.token_;
        onChanged();
      }
      if (!other.getSql().isEmpty()) {
        sql_ = other.sql_;
        onChanged();
      }
      if (!other.getType().isEmpty()) {
        type_ = other.type_;
        onChanged();
      }
      if (!other.getRoleId().isEmpty()) {
        roleId_ = other.roleId_;
        onChanged();
      }
      if (!other.getDataSourceName().isEmpty()) {
        dataSourceName_ = other.dataSourceName_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      SqlRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (SqlRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object name_ = "";
    /**
     * <code>string name = 1;</code>
     */
    public String getName() {
      Object ref = name_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     */
    public Builder setName(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     */
    public Builder clearName() {

      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  AbstractMessageLite.checkByteStringIsUtf8(value);

      name_ = value;
      onChanged();
      return this;
    }

    private Object token_ = "";
    /**
     * <code>string token = 2;</code>
     */
    public String getToken() {
      Object ref = token_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        token_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string token = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTokenBytes() {
      Object ref = token_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        token_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string token = 2;</code>
     */
    public Builder setToken(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      token_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string token = 2;</code>
     */
    public Builder clearToken() {

      token_ = getDefaultInstance().getToken();
      onChanged();
      return this;
    }
    /**
     * <code>string token = 2;</code>
     */
    public Builder setTokenBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  AbstractMessageLite.checkByteStringIsUtf8(value);

      token_ = value;
      onChanged();
      return this;
    }

    private Object sql_ = "";
    /**
     * <code>string sql = 3;</code>
     */
    public String getSql() {
      Object ref = sql_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        sql_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string sql = 3;</code>
     */
    public com.google.protobuf.ByteString
        getSqlBytes() {
      Object ref = sql_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        sql_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string sql = 3;</code>
     */
    public Builder setSql(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      sql_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string sql = 3;</code>
     */
    public Builder clearSql() {

      sql_ = getDefaultInstance().getSql();
      onChanged();
      return this;
    }
    /**
     * <code>string sql = 3;</code>
     */
    public Builder setSqlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  AbstractMessageLite.checkByteStringIsUtf8(value);

      sql_ = value;
      onChanged();
      return this;
    }

    private Object type_ = "";
    /**
     * <code>string type = 4;</code>
     */
    public String getType() {
      Object ref = type_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        type_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string type = 4;</code>
     */
    public com.google.protobuf.ByteString
        getTypeBytes() {
      Object ref = type_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        type_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string type = 4;</code>
     */
    public Builder setType(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string type = 4;</code>
     */
    public Builder clearType() {

      type_ = getDefaultInstance().getType();
      onChanged();
      return this;
    }
    /**
     * <code>string type = 4;</code>
     */
    public Builder setTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  AbstractMessageLite.checkByteStringIsUtf8(value);

      type_ = value;
      onChanged();
      return this;
    }

    private Object roleId_ = "";
    /**
     * <code>string roleId = 5;</code>
     */
    public String getRoleId() {
      Object ref = roleId_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        roleId_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string roleId = 5;</code>
     */
    public com.google.protobuf.ByteString
        getRoleIdBytes() {
      Object ref = roleId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        roleId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string roleId = 5;</code>
     */
    public Builder setRoleId(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      roleId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string roleId = 5;</code>
     */
    public Builder clearRoleId() {

      roleId_ = getDefaultInstance().getRoleId();
      onChanged();
      return this;
    }
    /**
     * <code>string roleId = 5;</code>
     */
    public Builder setRoleIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  AbstractMessageLite.checkByteStringIsUtf8(value);

      roleId_ = value;
      onChanged();
      return this;
    }

    private Object dataSourceName_ = "";
    /**
     * <code>string dataSourceName = 6;</code>
     */
    public String getDataSourceName() {
      Object ref = dataSourceName_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        dataSourceName_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string dataSourceName = 6;</code>
     */
    public com.google.protobuf.ByteString
        getDataSourceNameBytes() {
      Object ref = dataSourceName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        dataSourceName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string dataSourceName = 6;</code>
     */
    public Builder setDataSourceName(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      dataSourceName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string dataSourceName = 6;</code>
     */
    public Builder clearDataSourceName() {

      dataSourceName_ = getDefaultInstance().getDataSourceName();
      onChanged();
      return this;
    }
    /**
     * <code>string dataSourceName = 6;</code>
     */
    public Builder setDataSourceNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  AbstractMessageLite.checkByteStringIsUtf8(value);

      dataSourceName_ = value;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:helloworld.SqlRequest)
  }

  // @@protoc_insertion_point(class_scope:helloworld.SqlRequest)
  private static final SqlRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new SqlRequest();
  }

  public static SqlRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SqlRequest>
      PARSER = new com.google.protobuf.AbstractParser<SqlRequest>() {
    @Override
    public SqlRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SqlRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SqlRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<SqlRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public SqlRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

