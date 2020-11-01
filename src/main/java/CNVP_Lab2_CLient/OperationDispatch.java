package CNVP_Lab2_CLient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class OperationDispatch {
    public static void dispatch(String receivedData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json = objectMapper.readTree(receivedData);
        String operation = json.get("operation").textValue();
        String data = json.get("data").toString();
        if (operation.equals("UserConnection")) {
            UserConnectedHandler(data);
        } else if (operation.equals("Message")) {
            MessageHandler(data);
        } else if (operation.equals("Disconnect")) {
            DisconnectionRequest(data);
        } else {
            throw new UnsupportedOperationException("operation " + operation + " is not supported");
        }
    }


    public static void UserConnectedHandler(String receivedData) throws IOException {
        UserConnectionServerRequest userConnectionServerRequest = JsonParser.deserializeUserConnectionRequest(receivedData);
        System.out.println(userConnectionServerRequest.toString());
    }

    public static void MessageHandler(String receivedData) throws IOException {
        MessageServerRequest messageServerRequest = JsonParser.deserializeMessageServerRequest(receivedData);
        System.out.println(messageServerRequest.toString());
    }

    public static void DisconnectionRequest(String receivedData) throws IOException {
        UserDisconnectionServerRequest userDisconnectionServerRequest = JsonParser.deserializeDisconnectionRequest(receivedData);
        System.out.println(userDisconnectionServerRequest.toString());
    }
}
