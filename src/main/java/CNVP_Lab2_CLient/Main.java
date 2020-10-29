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

            } finally {
                if (socket != null) {
                    socket.close();
                    System.out.println("client is closed");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            Client.writeMessageThread.join();
            Client.readMessageThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}