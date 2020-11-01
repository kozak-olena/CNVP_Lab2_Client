package CNVP_Lab2_CLient;

import java.io.*;
import java.net.SocketException;

public class ReadMessageThread extends Thread {

    @Override
    public void run() {
        try {
            while (true) {
                if (Client.isShutdownRequested) {
                    break;
                }

                String received = Client.reader.readLine();
                if (received == null) {
                    Client.isShutdownRequested = true;
                    break;
                }
                OperationDispatch.dispatch(received);
            }
        } catch (SocketException exception) {
            System.out.println("Server closed connection");
            Client.isShutdownRequested = true;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}


