package grpc.search.oauth.server.s.grpc.service;

import grpc.search.common.model.ServerReply;
import grpc.search.common.model.SqlRequest;
import grpc.search.common.model.SqlServerProto;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The greeting server definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.1)",
    comments = "Source: SqlDataService.proto")
public final class GetDataBySqlGrpc {

  private GetDataBySqlGrpc() {}

  public static final String SERVICE_NAME = "helloworld.GetDataBySql";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @Deprecated // Use {@link #getGetDataBySqlMethod()} instead.
  public static final io.grpc.MethodDescriptor<SqlRequest,
          ServerReply> METHOD_GET_DATA_BY_SQL = getGetDataBySqlMethod();

  private static volatile io.grpc.MethodDescriptor<SqlRequest,
          ServerReply> getGetDataBySqlMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<SqlRequest,
          ServerReply> getGetDataBySqlMethod() {
    io.grpc.MethodDescriptor<SqlRequest, ServerReply> getGetDataBySqlMethod;
    if ((getGetDataBySqlMethod = GetDataBySqlGrpc.getGetDataBySqlMethod) == null) {
      synchronized (GetDataBySqlGrpc.class) {
        if ((getGetDataBySqlMethod = GetDataBySqlGrpc.getGetDataBySqlMethod) == null) {
          GetDataBySqlGrpc.getGetDataBySqlMethod = getGetDataBySqlMethod = 
              io.grpc.MethodDescriptor.<SqlRequest, ServerReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.GetDataBySql", "getDataBySql"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SqlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ServerReply.getDefaultInstance()))
                  .setSchemaDescriptor(new GetDataBySqlMethodDescriptorSupplier("getDataBySql"))
                  .build();
          }
        }
     }
     return getGetDataBySqlMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the server
   */
  public static GetDataBySqlStub newStub(io.grpc.Channel channel) {
    return new GetDataBySqlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the server
   */
  public static GetDataBySqlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GetDataBySqlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the server
   */
  public static GetDataBySqlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GetDataBySqlFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting server definition.
   * </pre>
   */
  public static abstract class GetDataBySqlImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void getDataBySql(SqlRequest request,
        io.grpc.stub.StreamObserver<ServerReply> responseObserver) throws InterruptedException, ExecutionException, TimeoutException, SQLException {
      asyncUnimplementedUnaryCall(getGetDataBySqlMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetDataBySqlMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      SqlRequest,
                      ServerReply>(
                  this, METHODID_GET_DATA_BY_SQL)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting server definition.
   * </pre>
   */
  public static final class GetDataBySqlStub extends io.grpc.stub.AbstractStub<GetDataBySqlStub> {
    private GetDataBySqlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetDataBySqlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected GetDataBySqlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetDataBySqlStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void getDataBySql(SqlRequest request,
        io.grpc.stub.StreamObserver<ServerReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDataBySqlMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting server definition.
   * </pre>
   */
  public static final class GetDataBySqlBlockingStub extends io.grpc.stub.AbstractStub<GetDataBySqlBlockingStub> {
    private GetDataBySqlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetDataBySqlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected GetDataBySqlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetDataBySqlBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public ServerReply getDataBySql(SqlRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDataBySqlMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting server definition.
   * </pre>
   */
  public static final class GetDataBySqlFutureStub extends io.grpc.stub.AbstractStub<GetDataBySqlFutureStub> {
    private GetDataBySqlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetDataBySqlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected GetDataBySqlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetDataBySqlFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ServerReply> getDataBySql(
        SqlRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDataBySqlMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DATA_BY_SQL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GetDataBySqlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GetDataBySqlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DATA_BY_SQL:
          try {
            serviceImpl.getDataBySql((SqlRequest) request,
                (io.grpc.stub.StreamObserver<ServerReply>) responseObserver);
          } catch (InterruptedException e) {
            e.printStackTrace();
          } catch (ExecutionException e) {
            e.printStackTrace();
          } catch (TimeoutException e) {
            e.printStackTrace();
          } catch (SQLException e) {
            e.printStackTrace();
          }
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GetDataBySqlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GetDataBySqlBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return SqlServerProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GetDataBySql");
    }
  }

  private static final class GetDataBySqlFileDescriptorSupplier
      extends GetDataBySqlBaseDescriptorSupplier {
    GetDataBySqlFileDescriptorSupplier() {}
  }

  private static final class GetDataBySqlMethodDescriptorSupplier
      extends GetDataBySqlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GetDataBySqlMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GetDataBySqlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GetDataBySqlFileDescriptorSupplier())
              .addMethod(getGetDataBySqlMethod())
              .build();
        }
      }
    }
    return result;
  }
}
