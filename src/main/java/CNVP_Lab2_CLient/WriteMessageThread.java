package CNVP_Lab2_CLient;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.*;

public class WriteMessageThread extends Thread {

    public  static boolean status =true;

    @Override
    public void run() {
        try {
            String inputMessage;
            while (true) {
                //System.out.println("write your message");
                inputMessage = Client.clientInput.readLine();
                if (inputMessage.equals("stop")) {
                    String data = SendData.getDataToSend(inputMessage);
                    send(data + "\n");
                    status = getStatus(inputMessage);

                    break;
                } else {
                    String data = SendData.getDataToSend(inputMessage);
                    send(data + "\n");
                }
            }

        } catch (JsonProcessingException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static boolean getStatus(String input) throws IOException {
        if (input.equals("stop")) {
            return false;
        } else {
            return true;
        }
    }

    public static void send(String data) throws IOException {
        Client.writer.write(data);
        Client.writer.flush();
    }


}

