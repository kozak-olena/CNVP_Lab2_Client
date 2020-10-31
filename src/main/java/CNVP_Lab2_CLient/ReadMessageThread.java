package CNVP_Lab2_CLient;

import java.io.*;

public class ReadMessageThread extends Thread {

    @Override
    public void run() {
        String received;

        while (true) {
            try {
                received = Client.reader.readLine();
                OperationDispatch.dispatch(received);
                boolean status = true;
                status = WriteMessageThread.status;
                if (status == false) {
                    break;
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

    }
}

