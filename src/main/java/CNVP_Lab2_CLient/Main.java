package CNVP_Lab2_CLient;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            Client.startReadAndWriteThread();
            try {
                Client.writeMessageThread.join();
                Client.readMessageThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Client.downService();
    }
}