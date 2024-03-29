package grpc.search.oauth.server.s.config;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.google.common.util.concurrent.RateLimiter;
import com.zaxxer.hikari.HikariDataSource;
import grpc.search.oauth.server.s.grpc.server.GrpcServer;
import grpc.search.oauth.server.s.grpc.server.MyServerInterceptor;
import grpc.search.oauth.server.s.server.*;
import grpc.search.oauth.server.s.server.impl.*;
import grpc.search.oauth.server.s.task.TaskServer;
import grpc.search.oauth.server.s.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by tianjian on 2019/6/26.
 */
@EnableAsync
@Configuration
@EnableScheduling
//@PropertySource({"${SYS_PROP}/config/config.properties"})
@PropertySource("classpath:config.properties")
public class BeanConfig {

    /**
     * 线程池
     * @return
     */
    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(200);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("taskExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }



    @Bean
    public MyServerInterceptor getMyServerInterceptor() {
        return new MyServerInterceptor();
    }


    @Bean
    public Log getLog() {
        return LogFactory.getLog("system");
    }

    @Value("${mysql.drivename}")
    private String driveName;

    @Value("${mysql.username}")
    private String userName;

    @Value("${mysql.password}")
    private String password;

    @Value("${mysql.url}")
    private String url;

    @Autowired
    private Properties properties;

    @Bean(name = "mysqlDataSource")
    @Primary
    public DataSource getDruidDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driveName);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(url);
        dataSource.setMaximumPoolSize(30);
        return dataSource;
    }

    @Value("${mysql.ide.username}")
    private String IdeUserName;

    @Value("${mysql.ide.password}")
    private String IdePassword;

    @Value("${mysql.ide.url}")
    private String IdeUrl;

    @Bean(name = "mysqlIDEDataSource")
    public DataSource getIDEDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driveName);
        dataSource.setUsername(IdeUserName);
        dataSource.setPassword(IdePassword);
        dataSource.setJdbcUrl(IdeUrl);
        dataSource.setMaximumPoolSize(30);
        return dataSource;
    }


    /**
     * 数据服务代理，主要做限流
     * @return
     */
    @Bean("getDataBySqlServerProxy")
    public GetDataBySqlServerProxy getDataBySqlServerProxy(){
        return new GetDataBySqlServerProxy();
    }

    /**
     * 数据服务
     * @return
     */
    @Bean("getDataBySqlServer")
    public GetDataBySqlServer getDataBySqlServer() {
        GetDataBySqlServer getDataBySqlServer = new GetDataBySqlServer();
        return getDataBySqlServer;
    }

    @Value("${guava.RateLimiter.permitsPerSecond}")
    private double permitsPerSecond;
    /**
     * guava 限流器
     * @return
     */
    @Bean
    public RateLimiter getRateLimiter() {
        RateLimiter rateLimiter = RateLimiter.create(1);
        return rateLimiter;
    }

    @Bean
    public BeanUtil getBeanUtil() {
        return new BeanUtil();
    }


    @Bean
    public MulDataSourceManage getDataSearchServerManageFactory() {
        MulDataSourceManage mulDataSourceManage = new MulDataSourceManage();
        mulDataSourceManage.setDataSource(getDruidDataSource());
        mulDataSourceManage.initDataSource();
        return mulDataSourceManage;
    }

    @Bean("dataSearchServer")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DataSearchServer getCommonDataSearchServer() {
        return new CommonDataSearchServer();
    }


    /**
     * 安全验证服务，验证用户信息，验证字段权限信息
     * @return
     */
    @Bean
    public VerifySqlRequest getVerifySqlRequest() {
        return new VerifySqlRequestImpl();
    }

    /**
     * 服务器
     * @return
     */
    @Bean
    public GrpcServer getHelloWorldServer() {
        return new GrpcServer();
    }

    @Bean
    public CheckIDESqlPermission getCheckIDESqlPermission() {
        CheckIDESqlPermission checkIDESqlPermission = new CheckIDESqlPermission();
        return checkIDESqlPermission;
    }

    @Bean
    public TaskServer getTaskServer() {
        return new TaskServer();
    }

    @Bean
    public CheckSysSqlPermission getCheckSysSqlPermission() {
        CheckSysSqlPermission checkSysSqlPermission = new CheckSysSqlPermission();
        return checkSysSqlPermission;
    }

    @Bean
    public  CheckSqlPermissionStream getCheckSqlPermissionStream() {
        CheckSqlPermissionStream checkSqlPermissionStream = new CheckSqlPermissionStream();
        checkSqlPermissionStream.registerCheckSqlPermission("IDE", getCheckIDESqlPermission());
        checkSqlPermissionStream.registerCheckSqlPermission("Sys", getCheckSysSqlPermission());
        return checkSqlPermissionStream;
    }

}
