package CNVP_Lab2_CLient;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = null;

        try {
            Client client = new Client();
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