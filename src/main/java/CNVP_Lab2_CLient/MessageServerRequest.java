package CNVP_Lab2_CLient;

import java.time.Instant;

public class MessageServerRequest {
    public String data;
    public String userName = UserInput.name;
    public Instant timestamp = Instant.now();

    @Override
    public String toString() {
        return data + '\'' + userName + '\'' + timestamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
