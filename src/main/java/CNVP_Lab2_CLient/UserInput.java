package CNVP_Lab2_CLient;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public class UserInput {
    public static String name;

    public static String inputYourName() {
        System.out.print("Input your name: ");
        try {
            name = Client.clientInput.readLine();
        } catch (IOException exception) {
        }
        return name;
    }
}
