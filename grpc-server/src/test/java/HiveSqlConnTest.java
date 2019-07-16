import com.zaxxer.hikari.HikariDataSource;
import org.apache.hive.jdbc.HiveConnection;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by tianjian on 2019/7/12.
 */
public class HiveSqlConnTest {
    @Test
    public void hiveSqlTest() throws SQLException {
        // HiveConnection
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        hikariDataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/docker");
        hikariDataSource.setUsername("root");
        hikariDataSource.setPassword("123456");
        hikariDataSource.setValidationTimeout(10000l);

        //hikariDataSource.setConnectionTimeout(1000);
        Connection connection = hikariDataSource.getConnection();
        System.out.println();
    }
}
