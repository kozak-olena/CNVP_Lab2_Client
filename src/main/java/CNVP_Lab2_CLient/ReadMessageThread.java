package CNVP_Lab2_CLient;

import java.io.*;
import java.net.Socket;

public class ReadMessageThread extends Thread {

    @Override
    public void run() {
        String message;
        try {
            while (true) {
                message = Client.in.readLine();

                if (message.equals("stop")) {
                    break;
                }
            }
        } catch (IOException e) {

        }
    }
}

