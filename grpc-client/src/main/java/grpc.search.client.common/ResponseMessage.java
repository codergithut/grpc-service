package grpc.search.client.common;

/**
 * Created by tianjian on 2019/7/17.
 */
public class ResponseMessage {

    private int code;

    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
