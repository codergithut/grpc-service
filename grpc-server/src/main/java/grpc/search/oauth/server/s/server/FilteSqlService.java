package grpc.search.oauth.server.s.server;

import javax.sql.DataSource;

/**
 * Created by tianjian on 2019/7/11.
 */
public interface FilteSqlService {
    void filteDataSearch(String sql);
}
