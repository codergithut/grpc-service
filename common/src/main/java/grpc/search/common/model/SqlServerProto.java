// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SqlDataService.proto

package grpc.search.common.model;

public final class SqlServerProto {
  private SqlServerProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_SqlRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_SqlRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_ServerReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_ServerReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\024SqlDataService.proto\022\nhelloworld\"6\n\nSq" +
      "lRequest\022\014\n\004name\030\001 \001(\t\022\r\n\005token\030\002 \001(\t\022\013\n" +
      "\003sql\030\003 \001(\t\"3\n\013ServerReply\022\023\n\013messagecode" +
      "\030\001 \001(\005\022\017\n\007message\030\002 \001(\t2Q\n\014GetDataBySql\022" +
      "A\n\014getDataBySql\022\026.helloworld.SqlRequest\032" +
      "\027.helloworld.ServerReply\"\000B2\n\030grpc.searc" +
      "h.server.grpcB\016SqlServerProtoP\001\242\002\003HLWb\006" +
      "proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_helloworld_SqlRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_helloworld_SqlRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_SqlRequest_descriptor,
        new String[] { "Name", "Token", "Sql", });
    internal_static_helloworld_ServerReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_helloworld_ServerReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_ServerReply_descriptor,
        new String[] { "Messagecode", "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
