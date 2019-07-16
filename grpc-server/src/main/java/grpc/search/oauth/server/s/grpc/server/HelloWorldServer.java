package grpc.search.oauth.server.s.grpc.server;

import grpc.search.oauth.server.s.server.GetDataBySqlServerProxy;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HelloWorldServer {

    @Value("${server.port}")
    private int port;

    private Server server;

    @Autowired
    private MyServerInterceptor myServerInterceptor;

    @Autowired
    private GetDataBySqlServerProxy getDataBySqlServerProxy;

    public void start() throws IOException, InterruptedException {
        server = ServerBuilder.forPort(port)
                .intercept(myServerInterceptor)
                .addService(getDataBySqlServerProxy)
                .build()
                .start();

        System.out.println("server start...");

        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {

                System.err.println("*** shutting down gRPC service since JVM is shutting down");
                HelloWorldServer.this.stop();
                System.err.println("*** service shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    // block 一直到退出程序
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }


    public void startServer() throws IOException, InterruptedException {
        start();
        blockUntilShutdown();
    }
}
