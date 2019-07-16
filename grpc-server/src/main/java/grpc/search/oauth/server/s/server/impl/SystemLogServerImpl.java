package grpc.search.oauth.server.s.server.impl;

import grpc.search.oauth.server.s.server.SystemLogServer;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tianjian on 2019/6/27.
 */
public class SystemLogServerImpl implements SystemLogServer {

    @Autowired
    Log log;

    @Override
    public void warn(Object warn) {
        System.out.println(warn.toString());
        log.warn(warn);
    }

    @Override
    public void info(Object info) {
        System.out.println(info.toString());
        log.info(info);
    }

    @Override
    public void error(Object error) {
        System.out.println(error.toString());
        log.error(error);
    }
}
