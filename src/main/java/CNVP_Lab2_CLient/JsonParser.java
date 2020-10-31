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

    public static UserConnectionServerRequest deserializeUserConnectionRequest(String receivedData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        UserConnectionServerRequest userConnectionServerRequest = objectMapper.readValue(receivedData, UserConnectionServerRequest.class);
        return userConnectionServerRequest;
    }

    public static MessageServerRequest deserializeMessageServerRequest(String receivedData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MessageServerRequest messageServerRequest = objectMapper.readValue(receivedData, MessageServerRequest.class);
        return messageServerRequest;
    }

    public static UserDisconnectionServerRequest deserializeDisconnectionRequest(String receivedData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        UserDisconnectionServerRequest userDisconnectionServerRequest = objectMapper.readValue(receivedData, UserDisconnectionServerRequest.class);
        return userDisconnectionServerRequest;
    }
}

