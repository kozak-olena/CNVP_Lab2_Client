package CNVP_Lab2_CLient;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.*;

public class WriteMessageThread extends Thread {

    @Override
    public void run() {

        String inputMessage;
        try {
            while (true) {
                System.out.println("write your message");
                inputMessage = Client.clientInput.readLine();
                if (inputMessage.equals("stop")) {
                    break;
                }
            }
            String data = SendData.getDataToSend(inputMessage);
            Client.writer.write(data);
            Client.writer.flush();
        } catch (JsonProcessingException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

