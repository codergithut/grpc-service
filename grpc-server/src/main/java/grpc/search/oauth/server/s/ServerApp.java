package grpc.search.oauth.server.s;

import grpc.search.oauth.server.s.grpc.server.GrpcServer;
import grpc.search.oauth.server.s.config.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Created by tianjian on 2019/6/26.
 */
public class ServerApp {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(BeanConfig.class);

        GrpcServer helloWorldServer = ctx.getBean(GrpcServer.class);
        helloWorldServer.startServer();

    }
}
