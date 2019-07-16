package grpc.search.oauth.server.s.server;

import grpc.search.oauth.server.s.model.SearchModeData;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Future;

/**
 * Created by tianjian on 2019/6/26.
 */
public abstract class DataSearchServer{

    /**
     * 数据查询数据源
     */
    protected DataSource dataSource;

    /**
     * 获取连接
     */
    protected Connection connection;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    public Future<SearchModeData> getDataBySql(String sql) throws InterruptedException, SQLException {
        return getDataBySQLSever(sql);
    }

    /**
     * 异步查询数据库数据
     * @return
     * @throws InterruptedException
     */
    protected abstract Future<SearchModeData> getDataBySQLSever(String sql) throws InterruptedException, SQLException;

    public DataSource getDataSource() {
        return dataSource;
    }

    public Connection getConnection() {
        return connection;
    }
}
