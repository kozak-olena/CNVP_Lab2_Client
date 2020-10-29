package CNVP_Lab2_CLient;

import com.fasterxml.jackson.core.JsonProcessingException;

public class SendData {
    ServerRequestWrapper serverRequestWrapper = new ServerRequestWrapper();

    public static String getDataToSend(String message) throws JsonProcessingException {
        ServerRequestWrapper wrapper = new ServerRequestWrapper();

        if (message.equals("stop")) {
            UserDisconnectionServerRequest disconnection = new UserDisconnectionServerRequest();
            wrapper.setOperation("stop");
            wrapper.setData(disconnection);
            return JsonParser.serialize(wrapper);
        } else {
            MessageServerRequest messageServerRequest = new MessageServerRequest();
            messageServerRequest.setData(message);
            wrapper.setOperation("Message");
            wrapper.setData(messageServerRequest);
            return JsonParser.serialize(wrapper);
        }
    }
}
