import com.zaxxer.hikari.HikariDataSource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.*;

/**
 * Created by tianjian on 2019/7/11.
 */
public class PostgreSqlJdbcConnTest {

    HikariDataSource dataSource;

    @Before
    public void initDataBase() {
        dataSource = new HikariDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("pgadmin");
        dataSource.setPassword("6lcePSo4ypUwe0xB");
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setAutoCommit(false);
    }

    @Test
    @Ignore
    public void createDataBaseTest() throws SQLException {
        Connection c = dataSource.getConnection();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "CREATE TABLE COMPANY02 " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

    }

    @Test
    @Ignore
    public void addDataTest() throws SQLException {
        Connection c = dataSource.getConnection();
        Statement stmt = null;
        try {

            stmt = c.createStatement();

            String sql = "INSERT INTO COMPANY02 (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY02 (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY02 (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY02 (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("新增数据成功！");
    }


    @Test
    public void selectDataTest() throws SQLException {
        Connection c = dataSource.getConnection();
        Statement stmt = null;
        try {
            System.out.println("连接数据库成功！");
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("select * from pcompany02");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println(id + "," + name + "," + age + "," + address.trim() + "," + salary);
            }

            rs.close();
            stmt.close();

            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Test
    public void updateDataTest() throws SQLException {
        Connection c = dataSource.getConnection();
        Statement stmt = null;
        try {

            System.out.println("连接数据库成功！");
            stmt = c.createStatement();

            String sql = "UPDATE COMPANY02 set SALARY = 250 where ID=1 ";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery("select * from company02 order by id");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println(id + "," + name + "," + age + "," + address.trim() + "," + salary);
            }

            rs.close();
            stmt.close();

            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Test
    public void deleteDataTest() throws SQLException {
        Connection c = dataSource.getConnection();
        Statement stmt = null;
        try {

            System.out.println("连接数据库成功！");
            stmt = c.createStatement();

            String sql = "Delete from COMPANY02 where ID=4 ";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery("select * from company02 order by id");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println(id + "," + name + "," + age + "," + address.trim() + "," + salary);
            }

            rs.close();
            stmt.close();

            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
