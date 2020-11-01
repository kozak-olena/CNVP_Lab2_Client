package CNVP_Lab2_CLient;

public class UserDisconnectionServerRequest {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String userName;
    public String dateTime;

    @Override
    public String toString() {
        return "[" + dateTime + "] " + "<" + userName + ">" + " closed connection";
    }
}
