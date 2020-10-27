package CNVP_Lab2_CLient;

import java.io.*;
import java.net.Socket;

public class ReadMessageThread extends Thread {

    @Override
    public void run() {
        String message;
        try {
            while (true) {
                System.out.println("waiting for message from server");
                message = Client.in.readLine();  //stop
                System.out.println("received message" + message);
                if (message.equals("stop")) {
                    break;
                }
            }
        } catch (IOException e) {

        }
    }
}

