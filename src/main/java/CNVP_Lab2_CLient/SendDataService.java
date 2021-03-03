package CNVP_Lab2_CLient;

import java.io.IOException;

public class SendDataService {
    public static void sendMessage(String message) throws IOException {
        ServerRequestWrapper wrapper = new ServerRequestWrapper();

        if (message.equals("stop")) {
            UserDisconnectionServerRequest disconnection = new UserDisconnectionServerRequest();
            disconnection.setUserName(UserName.name);
            disconnection.setDateTime(DateTimeHelper.getFormattedDateTime());
            wrapper.setOperation("Disconnect");
            wrapper.setData(disconnection);
            String json = JsonParser.serialize(wrapper);
            send(json);
        } else {
            MessageServerRequest messageServerRequest = new MessageServerRequest();
            messageServerRequest.setData(message);
            messageServerRequest.setUserName(UserName.name);
            messageServerRequest.setDateTime(DateTimeHelper.getFormattedDateTime());
            wrapper.setOperation("Message");
            wrapper.setData(messageServerRequest);
            String json = JsonParser.serialize(wrapper);
            send(json);
        }
    }

    private static void send(String data) throws IOException {
        Client.writer.write(data+"\n");
        Client.writer.flush();
    }
}
