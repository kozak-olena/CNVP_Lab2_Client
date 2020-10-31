package CNVP_Lab2_CLient;

import com.fasterxml.jackson.core.JsonProcessingException;

public class SendData {
    public static String getDataToSend(String message) throws JsonProcessingException {
        ServerRequestWrapper wrapper = new ServerRequestWrapper();

        if (message.equals("stop")) {
            UserDisconnectionServerRequest disconnection = new UserDisconnectionServerRequest();
            disconnection.setDateTime(DateTime.getDateTime());
            wrapper.setOperation("Disconnect");
            wrapper.setData(disconnection);
            return JsonParser.serialize(wrapper);
        } else {
            MessageServerRequest messageServerRequest = new MessageServerRequest();
            messageServerRequest.setData(message);
            messageServerRequest.setDataTime(DateTime.getDateTime());
            wrapper.setOperation("Message");
            wrapper.setData(messageServerRequest);
            return JsonParser.serialize(wrapper);
        }
    }
}
