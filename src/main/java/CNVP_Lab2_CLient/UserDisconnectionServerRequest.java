package CNVP_Lab2_CLient;

import java.time.Instant;

public class UserDisconnectionServerRequest {
    public String userName = UserName.name;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String dateTime;

    @Override
    public String toString() {
        return "[" + dateTime + "] " + "<" + userName + ">" + " closed connection";
    }
}
