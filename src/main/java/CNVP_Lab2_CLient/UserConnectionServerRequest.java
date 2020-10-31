package CNVP_Lab2_CLient;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class UserConnectionServerRequest {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String userName;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String dateTime;

    @Override
    public String toString() {
        return "[" + dateTime + "]" + "<" + userName + ">" + " just connected to chat";
    }
}
