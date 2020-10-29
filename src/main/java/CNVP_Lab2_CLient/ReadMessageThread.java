package CNVP_Lab2_CLient;

import java.io.*;

public class ReadMessageThread extends Thread {

    @Override
    public void run() {
        String received;

        while (true) {
            System.out.println("waiting for received from server");
            try {
                received = Client.reader.readLine();
                OperationDispatch.dispatch(received);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

    }
}

