package CNVP_Lab2_CLient;

import java.time.Instant;

public class MessageServerRequest {
    public String data;
    public String userName = UserName.name;

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String dataTime;

    @Override
    public String toString() {
        return "[" + dataTime + "]" + userName + ":" + data;
    } //TODO:DATATiME

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
