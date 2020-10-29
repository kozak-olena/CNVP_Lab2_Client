package CNVP_Lab2_CLient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonParser {

    public static String serialize(ServerRequestWrapper serverRequestWrapper) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(serverRequestWrapper);
    }

    public static String deserializeOperation(String received) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json = objectMapper.readTree(received);
        String operation = json.get("operation").toString();
        return operation;
    }

    public static UserConnectionServerRequest deserializeUserConnectionRequest(String receivedData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        UserConnectionServerRequest userConnectionServerRequest = new UserConnectionServerRequest();
        objectMapper.readValue(receivedData, UserConnectionServerRequest.class);
        return userConnectionServerRequest;
    }

    public static MessageServerRequest deserializeMessageServerRequest(String receivedData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MessageServerRequest messageServerRequest = new MessageServerRequest();
        objectMapper.readValue(receivedData, MessageServerRequest.class);
        return messageServerRequest;
    }

    public static UserDisconnectionServerRequest deserializeDisconnectionRequest(String receivedData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        UserDisconnectionServerRequest userDisconnectionServerRequest = new UserDisconnectionServerRequest();
        objectMapper.readValue(receivedData, UserDisconnectionServerRequest.class);
        return userDisconnectionServerRequest;
    }
}

