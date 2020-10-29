package CNVP_Lab2_CLient;

import java.io.IOException;

public class OperationDispatch {
    public static void dispatch(String receivedData) throws IOException {
        String operation = JsonParser.deserializeOperation(receivedData);
        if (operation.equals("UserConnection")) {
            UserConnectedHandler(receivedData);
        } else if (operation.equals("Message")) {
            MessageHandler(receivedData);
        } else if (operation.equals("Disconnect")) {
            DisconnectionRequest(receivedData);
        } else {
            throw new UnsupportedOperationException();
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
