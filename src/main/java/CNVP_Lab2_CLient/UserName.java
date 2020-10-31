package CNVP_Lab2_CLient;

import java.io.IOException;

public class UserName {
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
