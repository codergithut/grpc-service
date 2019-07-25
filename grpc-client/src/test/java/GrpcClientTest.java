
import grpc.search.client.common.ClientInfo;
import grpc.search.client.common.ResponseMessage;
import grpc.search.client.common.SearchDataClient;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by tianjian on 2019/7/22.
 */
public class GrpcClientTest {
    SearchDataClient searchDataClient;

    ClientInfo clientInfo;

    ResponseMessage responseMessage;

    @Before
    public void initSearchDataClient() {
        searchDataClient = new SearchDataClient();
        resetClientInfo();
    }

    public void resetClientInfo() {
        clientInfo = new ClientInfo();
        clientInfo.setRoleId("1");
        clientInfo.setDataSourceName("mysql1");
        clientInfo.setClientName("client1");
        clientInfo.setToken("5550ea50-f129-4ce0-80e0-3a0d7dadf8b3");
        clientInfo.setType("IDE");
        clientInfo.setSql("select * from docker.test");
        clientInfo.setServerIp("127.0.0.1");
        clientInfo.setPort(3000);
    }


    @Test
    public void ipGrpcTest() throws InterruptedException {
        responseMessage = searchDataClient.getDataByServer(clientInfo);
        assertEquals(responseMessage.getCode(), 0);
    }

    @Test
    public void tokenGrpcTest() {
        clientInfo.setToken("sss");
        responseMessage = searchDataClient.getDataByServer(clientInfo);
        assertNotEquals(responseMessage.getCode(), 0);
    }

    @Test
    public void roleGrpcTest() {
        resetClientInfo();
        clientInfo.setRoleId("2");
        responseMessage = searchDataClient.getDataByServer(clientInfo);
        assertNotEquals(responseMessage.getCode(), 0);
    }

    @Test
    public void clientGrpcTest() {
        resetClientInfo();
        clientInfo.setClientName("client2");
        responseMessage = searchDataClient.getDataByServer(clientInfo);
        assertNotEquals(responseMessage.getCode(), 0);
        resetClientInfo();
        clientInfo.setToken("ssss");
        responseMessage = searchDataClient.getDataByServer(clientInfo);
        assertNotEquals(responseMessage.getCode(), 0);
    }

    @Test
    public void dataSourceGrpcTest() {
        resetClientInfo();
        clientInfo.setDataSourceName("mysql12");
        responseMessage = searchDataClient.getDataByServer(clientInfo);
        assertNotEquals(responseMessage.getCode(), 0);
    }

    @Test
    public void sqlGrpcTest() {
        resetClientInfo();
        clientInfo.setSql("select * from test.xx");
        responseMessage = searchDataClient.getDataByServer(clientInfo);
        assertNotEquals(responseMessage.getCode(), 0);
    }



//    @After
//    public void shutDownClient() throws InterruptedException {
//        searchDataClient.shutdown();
//    }
}
