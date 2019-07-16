package grpc.search.oauth.server.s.server.impl;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.druid.util.JdbcConstants;
import grpc.search.oauth.server.s.grpc.mdoel.SqlRequest;
import grpc.search.oauth.server.s.model.SqlSearchField;
import grpc.search.oauth.server.s.server.CheckSqlPermissionStream;
import grpc.search.oauth.server.s.server.VerifySqlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by tianjian on 2019/6/26.
 * 用户sql验证
 */
@Service
@ComponentScan
public class VerifySqlRequestImpl implements VerifySqlRequest {

    private final String SEARCH = "select value from config_system where type = '" ;

    private final String CLIENTSEARCH = "select secret_key from auth_client where client_name = '";

    /**
     * 项目基础数据库
     */
    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource dataSource;

    @Autowired
    private CheckSqlPermissionStream checkSqlPermissionStream;

    /**
     * 白名单ip
     */
    private final Set<String> receiveIps = new HashSet();

    /**
     * 认证token
     */
    private final Map<String, Set<String>> tokens = new HashMap();

    /**
     * token验证器
     * @param sqlRequest
     * @return
     */
    @Override
    public boolean verifyTokenPermission(SqlRequest sqlRequest) {
        String token = sqlRequest.getToken();

        if(!tokens.containsKey(sqlRequest.getName())) {
            Set<String> details = getTokenByClientName(sqlRequest.getName());
            tokens.put(sqlRequest.getName(), details);
        }

        Set<String> details = tokens.get(sqlRequest.getName());

        if(details != null && details.contains(token)) {
            return true;
        }

        return false;
    }

    /**
     * sql 验证器
     * @param sqlRequest
     * @return
     */
    @Override
    public boolean verifySqlPermission(SqlRequest sqlRequest) {
        List<SqlSearchField> fields = parseSql(sqlRequest.getSql());
        String roleId = sqlRequest.getRoleId();
        return checkSqlPermissionStream.checkSqlPermissions(fields, roleId, sqlRequest.getType());
    }

    /**
     * IP 验证器
     * @param ip
     * @return
     */
    @Override
    public boolean verifyIpPermission(String ip) {

        if(CollectionUtils.isEmpty(receiveIps)) {
            receiveIps.addAll(initVerifyData("1"));
        }

        if(receiveIps.contains(ip)) {
            return true;
        }

        return false;
    }

    /**
     * 初始化用户白名单
     * @param type
     * @return
     */
    private Set<String> initVerifyData(String type) {
        Set<String> data = new HashSet<String>();
        PreparedStatement pstmt;
        try {
            pstmt = dataSource.getConnection().prepareStatement(SEARCH + type + "'");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                data.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 获取client对应的token
     * @param clientName
     * @return
     */
    private Set<String> getTokenByClientName(String clientName) {
        PreparedStatement pstmt;
        Set<String> data = new HashSet<>();
        try {
            pstmt = dataSource.getConnection().prepareStatement(CLIENTSEARCH + clientName + "'");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                data.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * sql解析
     * @param sql
     * @return
     */
    public List<SqlSearchField> parseSql(String sql) {
        String dbType = JdbcConstants.MYSQL;
        List<SqlSearchField> datas = new ArrayList<>();

        //格式化输出
        String result = SQLUtils.format(sql, dbType);

        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);

        if(CollectionUtils.isEmpty(stmtList)) {
            return null;
        }

        for (int i = 0; i < stmtList.size(); i++) {

            SQLStatement stmt = stmtList.get(i);
            MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
            stmt.accept(visitor);
            Map<String, List<TableStat.Column>> filterData =
                    visitor.getColumns().stream()
                            .filter(e -> e.isSelect())
                            .collect(Collectors.groupingBy(e -> e.getTable()));
            for( Map.Entry<String, List<TableStat.Column>> entry : filterData.entrySet()) {
                SqlSearchField sqlSearchField = new SqlSearchField();
                sqlSearchField.setTableName(entry.getKey());
                Set<String> searchColumns = entry.getValue().stream()
                        .map(e -> e.getName()).collect(Collectors.toSet());
                sqlSearchField.setSearchCloumNames(searchColumns);
                sqlSearchField.setOpt("select");
                datas.add(sqlSearchField);
            }
        }
        return datas;
    }
}
