package grpc.search.oauth.server.s.task;

import grpc.search.oauth.server.s.server.MulDataSourceManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by tianjian on 2019/6/28.
 */
@EnableScheduling
public class TaskServer {

    @Autowired
    private MulDataSourceManage mulDataSourceManage;

    @Scheduled(cron = "0/60 * * * * ? ")
    public void testTask() {
        mulDataSourceManage.initDataSource();
    }

}
