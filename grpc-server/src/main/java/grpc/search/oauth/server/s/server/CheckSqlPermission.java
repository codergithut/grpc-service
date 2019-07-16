package grpc.search.oauth.server.s.server;

import grpc.search.oauth.server.s.model.SqlSearchField;

import java.util.List;

/**
 * Created by tianjian on 2019/7/8.
 * 权限控制
 */
public interface CheckSqlPermission {
    boolean checkSqlPermission(List<SqlSearchField> sqlSearchFields, String role_id);
}
