package CNVP_Lab2_CLient;

import java.time.Instant;

public class UserConnectionServerRequest {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String userName;
    public Instant timestamp = Instant.now();

    @Override
    public String toString() {
        return timestamp + " Hello, my username is:" + userName;
    }
}
