package grpc.search.oauth.server.s;

import grpc.search.oauth.server.s.grpc.server.GrpcServer;
import grpc.search.oauth.server.s.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Properties;


/**
 * Created by tianjian on 2019/6/26.
 */
public class ServerApp {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();
        ctx.register(BeanConfig.class);
        ctx.refresh();
        GrpcServer helloWorldServer = ctx.getBean(GrpcServer.class);
        helloWorldServer.startServer();
    }
}
