package grpc.search.oauth.server.s.server;

import com.zaxxer.hikari.HikariDataSource;
import grpc.search.oauth.server.s.util.HiveConnectinInfo;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tianjian on 2019/7/12.
 */
public class MulDataSourceManage {

    private DataSource dataSource;

    private ReentrantLock lock  = new ReentrantLock();

    private Map<String, String> nameTypeRef = new ConcurrentHashMap<String, String>();

    private Map<String, HiveConnectinInfo> connectionValue = new ConcurrentHashMap<>();

    private Map<String, HikariDataSource> nameHiariDataSource = new ConcurrentHashMap<>();

    private final String sql = "SELECT * FROM docker.table_info where status = 1";

    public void initDataSource() {
        getDataSourceInfo();
    }

    private void cleanDataSource() {
        nameTypeRef.clear();
        connectionValue.clear();
        nameHiariDataSource.clear();
    }

    private void getDataSourceInfo() {
        lock.lock();
        cleanDataSource();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PreparedStatement pstmt;
        try {
            pstmt = dataSource.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String dataSourceName = rs.getString("name");
                String type = rs.getString("db_type");
                String driveName = rs.getString("jdbc_driver");
                String pwd = rs.getString("jdbc_password");
                String user_name = rs.getString("jdbc_user");
                String url = rs.getString("jdbc_url");
                if(type.equals("hive")) {
                    HiveConnectinInfo hiveConnectinInfo = new HiveConnectinInfo();
                    hiveConnectinInfo.setDriveName(driveName);
                    hiveConnectinInfo.setPassword(pwd);
                    hiveConnectinInfo.setUrl(url);
                    hiveConnectinInfo.setUsername(user_name);
                    connectionValue.put(dataSourceName, hiveConnectinInfo);

                } else {
                    HikariDataSource hikariDataSource = new HikariDataSource();
                    hikariDataSource.setJdbcUrl(url);
                    hikariDataSource.setUsername(user_name);
                    hikariDataSource.setPassword(pwd);
                    hikariDataSource.setDriverClassName(driveName);
                    hikariDataSource.setIdleTimeout(rs.getInt("max_idle_time"));
                    hikariDataSource.setMaximumPoolSize(rs.getInt("initial_pool_size"));
                    nameHiariDataSource.put(dataSourceName, hikariDataSource);
                }
                nameTypeRef.put(dataSourceName, rs.getString("db_type"));
//                dataSourceInfo.setInitPoolSize(rs.getInt(9));
//                dataSourceInfo.setMinPoolSize(rs.getInt(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String getTypeByName(String name) {
        if(nameTypeRef.containsKey(name) || lock.isLocked()) {
            return nameTypeRef.get(name);
        } else {
            return null;
        }
    }

    public HikariDataSource getHikariDataSourceByName(String name) {
        if(nameHiariDataSource.containsKey(name) || lock.isLocked()) {
            return nameHiariDataSource.get(name);
        }
        return null;
    }

    public HiveConnectinInfo getHiveConnectionInfoByName(String name) {
        if(connectionValue.containsKey(name) || lock.isLocked()) {
            return connectionValue.get(name);
        }
        return null;

    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
