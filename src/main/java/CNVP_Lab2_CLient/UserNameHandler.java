package CNVP_Lab2_CLient;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;


public class UserNameHandler {

    private static String getSerializedName(String name) throws JsonProcessingException {
        ServerRequestWrapper wrapper = new ServerRequestWrapper();
        UserConnectionServerRequest userConnectionServerRequest = new UserConnectionServerRequest();
        userConnectionServerRequest.setUserName(name);
        userConnectionServerRequest.setDateTime(DateTimeHelper.getFormattedDateTime());
        wrapper.setOperation("UserConnection");
        wrapper.setData(userConnectionServerRequest);
        return JsonParser.serialize(wrapper);
    }

    public static void LoginToServer() throws IOException {
        String userName = UserName.inputYourName();
        String json = UserNameHandler.getSerializedName(userName) + "\n";
        Client.writer.write(json);
        Client.writer.flush();
    }
}

