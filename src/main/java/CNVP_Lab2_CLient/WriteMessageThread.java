package CNVP_Lab2_CLient;

import java.io.*;

public class WriteMessageThread extends Thread {

    @Override
    public void run() {

        while (true) {
            String inputMessage;

            try {
                inputMessage = Client.in.readLine();
                if (inputMessage.equals("stop")) {
                    Client.out.write("stop" + "\n");
                    break;
                } else {
                    Client.out.write(inputMessage + "\n");
                }
                Client.out.flush();

            } catch (IOException e) {

            }

        }
    }
}

