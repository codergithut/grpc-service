package grpc.search.oauth.server.s.server;


import grpc.search.common.model.SqlRequest;

/**
 * Created by tianjian on 2019/6/26.
 */
public interface VerifySqlRequest {

    /**
     * 用户权限验证
     * @param sqlRequest
     * @return
     */
    boolean verifyTokenPermission(SqlRequest sqlRequest);

    /**
     * 用户数据字段验证
     * @param sqlRequest
     * @return
     */
    boolean verifySqlPermission(SqlRequest sqlRequest);


    boolean verifyIpPermission(String ip);

}
