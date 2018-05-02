package step002.web.domain;

import java.util.Objects;

public class ServerInfo {

    String HostName;
    String ServerIP;

    public String getHostName() {
        return HostName;
    }

    public void setHostName(String hostName) {
        HostName = hostName;
    }

    @Override
    public String toString() {
        return "ServerInfo{" +
                "HostName='" + HostName + '\'' +
                ", ServerIP='" + ServerIP + '\'' +
                '}';
    }

    public String getServerIP() {
        return ServerIP;
    }

    public void setServerIP(String serverIP) {
        ServerIP = serverIP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServerInfo)) return false;
        ServerInfo that = (ServerInfo) o;
        return Objects.equals(getHostName(), that.getHostName()) &&
                Objects.equals(getServerIP(), that.getServerIP());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHostName(), getServerIP());
    }
}
