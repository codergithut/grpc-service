package grpc.search.oauth.server.s.server;

import com.google.common.cache.*;
import com.zaxxer.hikari.HikariDataSource;
import grpc.search.oauth.server.s.config.ResultCode;
import grpc.search.oauth.server.s.grpc.mdoel.SqlRequest;
import grpc.search.oauth.server.s.grpc.service.GetDataBySqlGrpc;
import grpc.search.oauth.server.s.model.CacheModel;
import grpc.search.oauth.server.s.model.SearchModeData;
import grpc.search.oauth.server.s.model.ServiceLogModel;
import grpc.search.oauth.server.s.grpc.mdoel.ServerReply;
import grpc.search.oauth.server.s.util.HiveConnectinInfo;
import grpc.search.oauth.server.s.util.ResourceIsolate;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by tianjian on 2019/6/26.
 */
public class GetDataBySqlServer
        extends GetDataBySqlGrpc.GetDataBySqlImplBase {

    @Value("${queue.url}")
    private String queueUrl;

    //缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
    Cache<String,String> searchCache
            //CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
            = CacheBuilder.newBuilder()
            //设置并发级别为8，并发级别是指可以同时写缓存的线程数
            .concurrencyLevel(8)
            //设置写缓存后8秒钟过期
            .expireAfterWrite(20, TimeUnit.SECONDS)
            //设置缓存容器的初始容量为10
            .initialCapacity(10)
            //设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
            .maximumSize(100)
            //设置要统计缓存的命中率
            .recordStats()
            //设置缓存的移除通知
            .removalListener(new RemovalListener<Object, Object>() {
                @Override
                public void onRemoval(RemovalNotification<Object, Object> notification) {
                    System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
                }
            })
            .build();

    private static final String SQL_TYPE = "mysql";

    @Value("${timeout.value}")
    private int timeout;

    /**
     * 底层数据获取
     */
    @Autowired
    private DataSearchServerManage dataSearchServerManage;

    /**
     * 校验请求数据合法性
     */
    @Autowired
    private VerifySqlRequest verifySqlRequest;

    /**
     * 业务日志收集服务
     */
    @Autowired
    private ServiceLogServer serviceLogServer;

    /**
     * 系统日志收集服务
     */
    @Autowired
    private SystemLogServer systemLogServer;

    @Autowired
    private MulDataSourceManage mulDataSourceManage;

    /**
     * 获取数据库数据
     * @param request
     * @param responseObserver
     */
    @Override
    public void getDataBySql(SqlRequest request,
                             StreamObserver<ServerReply> responseObserver) throws InterruptedException, ExecutionException, SQLException {
        int messageCode = ResultCode.SUCCESS;

        String dataSourceName = request.getDataSourceName();

        DataSearchServer dataSearchServer = dataSearchServerManage.getDataSearchSeverByType
                (mulDataSourceManage.getTypeByName(dataSourceName));

        if(dataSearchServer == null) {
            systemLogServer.error("can not found type");
            messageCode = ResultCode.SEARCH_TYPE_UNFOUND;
            writeResponseMessage(responseObserver, "can not foud type", messageCode, request.getSql());
            return ;
        }

        HikariDataSource hikariDataSource = mulDataSourceManage
                .getHikariDataSourceByName(dataSourceName);

        if(hikariDataSource != null) {
            dataSearchServer.setDataSource(hikariDataSource);
        } else {
            HiveConnectinInfo hiveConnectinInfo = mulDataSourceManage.getHiveConnectionInfoByName(dataSourceName);
            if(hiveConnectinInfo == null) {
                messageCode = ResultCode.SEARCH_DATA_ERROR;
                writeResponseMessage(responseObserver, "can not find connection", messageCode, request.getSql());
                return ;
            }
            dataSearchServer.setConnection(ResourceIsolate.getConnection(hiveConnectinInfo, queueUrl));
        }


        if(!verifySqlRequest.verifyTokenPermission(request)) {
            messageCode = ResultCode.AUTH_ERROR_CODE;
            systemLogServer.error("Auth fail");
            writeResponseMessage(responseObserver, "verfiy fail", messageCode, request.getSql());
            return ;
        }

        if(!verifySqlRequest.verifySqlPermission(request)) {
            messageCode = ResultCode.AUTH_ERROR_CODE;
            systemLogServer.error("Data Auth fail");
            writeResponseMessage(responseObserver, "Data verfiy fail", messageCode, request.getSql());
            return ;
        }
        CacheModel cacheModel = new CacheModel();
        cacheModel.setReadCache(true);
        cacheModel.setWriteCache(true);
        String message = null;
        Future<SearchModeData> searchModeData = null;

        /**
         * 判断是否可以缓存
         */
        if(cacheModel.isReadCache()) {
            message = searchCache.getIfPresent(getSqlRequestParamSign(request));
            if(message != null) {
                systemLogServer.info("read data from cache ...");
                writeResponseMessage(responseObserver, message, messageCode, request.getSql());
                return ;
            }
        }


        /**
         * 判断缓存是否命中
         */
        if(message == null) {
            systemLogServer.info("read data from service ...");
            searchModeData = dataSearchServer.getDataBySql(request.getSql());
        }

        try {
            SearchModeData data = searchModeData.get(timeout, TimeUnit.SECONDS);
            message = data.getMessage();
            /**
             * 判断数据是否可以写入缓存
             */
            if(cacheModel.isWriteCache()) {
                systemLogServer.info("write data to cache");
                searchCache.put(getSqlRequestParamSign(request), message);
            }
        } catch (TimeoutException e) {
            systemLogServer.warn("time out error");
            e.printStackTrace();
            message = "time out error";
            messageCode = ResultCode.TIME_OUT_ERROR;
        } finally {
            writeResponseMessage(responseObserver, message, messageCode, request.getSql());
        }
    }

    /**
     * 发送消息到客户端
     * @param responseObserver
     * @param message
     */
    public void writeResponseMessage(StreamObserver<ServerReply> responseObserver,String message,
                                     int messageCode, String sql) {
        //todo 异步插入数据
        ServiceLogModel serviceLogModel = new ServiceLogModel();
        serviceLogModel
                .bulidCode(messageCode)
                .buildSearchTime(new Date().getTime())
                .buildParam(sql);
        serviceLogServer.saveServiceLogToService(serviceLogModel);
        //给客户端返回值
        ServerReply reply = ServerReply.getDefaultInstance().newBuilder()
                .setMessage(message).setMessagecode(messageCode).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    /**
     * 为请求数据进行签名
     * @param sqlRequest
     * @return
     */
    public static String getSqlRequestParamSign(SqlRequest sqlRequest) {
        StringBuffer key = new StringBuffer();
        key.append(sqlRequest.getSql()).append(sqlRequest.getName());
        return key.toString();

    }
}
