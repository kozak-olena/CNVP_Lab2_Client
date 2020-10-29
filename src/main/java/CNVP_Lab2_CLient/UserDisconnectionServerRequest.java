package CNVP_Lab2_CLient;

import java.time.Instant;

public class UserDisconnectionServerRequest {
    public String userName = UserInput.name;
    public Instant timestamp = Instant.now();

    @Override
    public String toString() {
        return timestamp + " User " + userName + " close connection";
    }
}
