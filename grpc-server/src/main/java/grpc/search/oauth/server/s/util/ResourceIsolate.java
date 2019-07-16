package grpc.search.oauth.server.s.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ResourceIsolate {

    public static String getQueueName() throws Exception {

        URL urlScheduler =
                new URL("http://30.99.137.101:8088/ws/v1/cluster/scheduler");

        URLConnection urlConnection = urlScheduler.openConnection();

        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;

        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type", "application/text");

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();
        String templine = null;

        if (httpURLConnection.getResponseCode() >= 300) {
            throw new Exception("Http request failed, response code is" +
                    httpURLConnection.getResponseCode());
        }

        inputStream = httpURLConnection.getInputStream();
        inputStreamReader = new InputStreamReader(inputStream);
        bufferedReader = new BufferedReader(inputStreamReader);

        while ((templine = bufferedReader.readLine()) != null) {
            stringBuffer.append(templine);
        }

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

        JSONObject jsonObject = (JSONObject) JSONObject.parse(stringBuffer.toString());


        JSONObject jsonObjectInfo = jsonObject.getJSONObject("scheduler").getJSONObject("schedulerInfo").getJSONObject("queues");


        ArrayList<QueueUsedInfo> queueUsedInfos = new ArrayList<>();

        queueUsedInfos = analysisJson(jsonObjectInfo, "root", new ArrayList<QueueUsedInfo>());

        QueueUsedInfo[] queueInfos = new QueueUsedInfo[queueUsedInfos.size()];

        int i = 0;

        for (QueueUsedInfo queueUsedInfo : queueUsedInfos) {

            queueInfos[i] = queueUsedInfo;
            i += 1;
        }

        Arrays.sort(queueInfos);

        //        for(int j = 0; j < queueInfos.length; j++){
//            System.out.println(queueInfos[j]);
//        }

        System.out.println(queueInfos[0].queueName);

        return queueInfos[0].queueName;

    }

    public static ArrayList<QueueUsedInfo> analysisJson(JSONObject objJson, String parentQueue, ArrayList<QueueUsedInfo> list) {


        JSONArray objArray = objJson.getJSONArray("queue");

//        System.out.println(objArray);

        for (int i = 0; i < objArray.size(); i++) {

            String queueName = ((JSONObject) objArray.get(i)).getString("queueName");
            JSONObject jsonObject = ((JSONObject) objArray.get(i)).getJSONObject("queues");

            String parent = parentQueue + "," + queueName;

            if (jsonObject != null)
                analysisJson(jsonObject, parent, list);
            else {

                String absoluteUsedCapacity = ((JSONObject) objArray.get(i)).getString("absoluteUsedCapacity");
                String absoluteMaxCapacity = ((JSONObject) objArray.get(i)).getString("absoluteMaxCapacity");
                String absoluteUnUsedCapacity = Float.parseFloat(absoluteMaxCapacity) - Float.parseFloat(absoluteUsedCapacity)
                        + "";

                QueueUsedInfo queueUsedInfo = new QueueUsedInfo();

                queueUsedInfo.setParentQueueName(parent);
                queueUsedInfo.setQueueName(queueName);
                queueUsedInfo.setAbsoluteMaxCapacity(absoluteMaxCapacity);
                queueUsedInfo.setAbsoluteUsedCapacity(absoluteUsedCapacity);
                queueUsedInfo.setAbsoluteUnUsedCapacity(absoluteUnUsedCapacity);

                list.add(queueUsedInfo);
            }
        }

        return list;
    }

    public static Connection getConnection(HiveConnectinInfo hiveConnectinInfo) {

        String driverName = hiveConnectinInfo.getDriveName();
        String url = hiveConnectinInfo.getUrl();

        String queueName = "";
        try {
            queueName = getQueueName();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!queueName.isEmpty())
            url +=  "?mapred.job.queue.name=" + queueName;

        Connection conn = null;

        try {
            Class.forName(driverName);
            try {
                conn = DriverManager
                        .getConnection(url, hiveConnectinInfo.getUsername(), hiveConnectinInfo.getPassword());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return conn;
    }

}

