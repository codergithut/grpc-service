package grpc.search.oauth.server.s.server;

import com.google.common.util.concurrent.RateLimiter;
import grpc.search.common.model.ServerReply;
import grpc.search.common.model.SqlRequest;
import grpc.search.common.service.GetDataBySqlGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Created by tianjian on 2019/6/26.
 */
// 流量控制 guava 控制
public class GetDataBySqlServerProxy extends GetDataBySqlGrpc.GetDataBySqlImplBase {

    @Autowired
    private GetDataBySqlServer getDataBySqlServer;

    @Autowired
    private RateLimiter rateLimiter;

    public void getDataBySql(SqlRequest request,
                             StreamObserver<ServerReply> responseObserver) throws ExecutionException, InterruptedException, SQLException, TimeoutException {
        rateLimiter.acquire();
        getDataBySqlServer.getDataBySql(request, responseObserver);
    }
}
