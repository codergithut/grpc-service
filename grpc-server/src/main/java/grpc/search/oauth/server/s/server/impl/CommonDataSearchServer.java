package grpc.search.oauth.server.s.server.impl;

import com.alibaba.fastjson.JSON;
import grpc.search.oauth.server.s.config.ResultCode;
import grpc.search.oauth.server.s.model.SearchModeData;
import grpc.search.oauth.server.s.server.DataSearchServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * Created by tianjian on 2019/6/26.
 */
@Service
@ComponentScan
@EnableAsync
public class CommonDataSearchServer extends DataSearchServer {

    /**
     * 异步获取后台数据
     * @param sql 查询sql语句
     * @return
     * @throws InterruptedException
     * @throws SQLException
     */
    @Async("taskExecutor")
    @Override
    protected Future<SearchModeData> getDataBySQLSever(String sql) throws InterruptedException, SQLException {

        //获取数据源连接
        Connection connection = null;
        if(dataSource != null) {
            connection = dataSource.getConnection();
        }
        if(dataSource == null && getConnection() != null) {
            connection = getConnection();
        }
        if(connection == null) {
            return null;
        }
        int code = 0;
        List<Map<String, Object>> data = new ArrayList<>();

        //执行sql获取数据
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            List<String> cloNames = new ArrayList<String>();
            for(int i = 1; i <=col; i++) {
                cloNames.add(rs.getMetaData().getColumnName(i));
            }
            while (rs.next()) {
                Map<String,Object> detail = new HashMap<>();
                for (int i = 1; i <= col; i++) {
                    detail.put(cloNames.get(i-1), rs.getObject(i));
                }
                data.add(detail);
            }
        } catch (SQLException e) {
            code = ResultCode.SEARCH_DATA_ERROR;
            e.printStackTrace();
        } finally {
            // 如果是非数据源需要关闭当前连接
            if(dataSource == null && connection != null) {
                connection.close();
            }
            SearchModeData searchModeData = new SearchModeData();
            searchModeData.setCode(code);
            searchModeData.setMessage(JSON.toJSONString(data));
            return new AsyncResult<>(searchModeData);
        }
    }


}
