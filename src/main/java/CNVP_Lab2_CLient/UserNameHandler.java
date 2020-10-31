package CNVP_Lab2_CLient;

import com.fasterxml.jackson.core.JsonProcessingException;


public class UserNameHandler {

    public static String getSerializedName(String name) throws JsonProcessingException {
        ServerRequestWrapper wrapper = new ServerRequestWrapper();
        UserConnectionServerRequest userConnectionServerRequest = new UserConnectionServerRequest();
        userConnectionServerRequest.setUserName(name);
        userConnectionServerRequest.setDateTime(DateTime.getDateTime());
        wrapper.setOperation("UserConnection");
        wrapper.setData(userConnectionServerRequest);
        return JsonParser.serialize(wrapper);
    }
}

