package grpc.search.oauth.server.s.util;

/**
 * Created by tianjian on 2019/7/15.
 */
public class HiveConnectinInfo {

    private String driveName;

    private String url;

    private String username;

    private String password;

    public String getDriveName() {
        return driveName;
    }

    public void setDriveName(String driveName) {
        this.driveName = driveName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
