package CNVP_Lab2_CLient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        Socket socket = null;
        try {
            try {
                InetAddress ipAddressOfServer = InetAddressInput.getInetAddress();
                socket = Client.createSocket(ipAddressOfServer);
                Client.startReadAndWriteThread(socket);

                try {
                    Client.writeMessageThread.join();
                    Client.readMessageThread.join();
                    System.out.println("here again");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                Client.downService(socket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}