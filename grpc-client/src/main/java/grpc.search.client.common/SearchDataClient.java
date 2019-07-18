package grpc.search.client.common;

import grpc.search.common.model.ServerReply;
import grpc.search.common.model.SqlRequest;
import grpc.search.common.service.GetDataBySqlGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by tianjian on 2019/6/28.
 */
public class SearchDataClient {

    private ManagedChannel server_channel;

    private GetDataBySqlGrpc.GetDataBySqlBlockingStub serverBlockingStub;


    public void shutdown() throws InterruptedException {
        server_channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public ResponseMessage getDataByServer(ClientInfo clientInfo) {
        if(server_channel == null) {
            server_channel = ManagedChannelBuilder.forAddress(clientInfo.getServerIp(), clientInfo.getPort())
                    .usePlaintext(true)
                    .build();
            serverBlockingStub = GetDataBySqlGrpc.newBlockingStub(server_channel);
        }
        SqlRequest request = SqlRequest.newBuilder().setSql(clientInfo.getSql())
                .setRoleId(clientInfo.getRoleId())
                .setType(clientInfo.getType())
                .setDataSourceName(clientInfo.getDataSourceName())
                .setToken(clientInfo.getToken()).setName(clientInfo.getClientName())
                .build();
        ServerReply response = serverBlockingStub.getDataBySql(request);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(response.getMessagecode());
        responseMessage.setData(response.getMessage());
        return responseMessage;
    }

    //你好
    public static void main(String[] args) throws InterruptedException {
        SearchDataClient searchDataClient = new SearchDataClient();
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setRoleId("1");
        clientInfo.setDataSourceName("mysql1");
        clientInfo.setClientName("client1");
        clientInfo.setToken("5550ea50-f129-4ce0-80e0-3a0d7dadf8b3");
        clientInfo.setType("IDE");
        clientInfo.setSql("select * from docker.test");
        clientInfo.setServerIp("127.0.0.1");
        clientInfo.setPort(3000);

        for(int i = 0; i < 100; i++) {
            System.out.println(searchDataClient.getDataByServer(clientInfo));
            Thread.sleep(100);
        }
        searchDataClient.shutdown();

    }



}
