package CNVP_Lab2_CLient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static BufferedReader reader;
    public static BufferedWriter writer;
    public static BufferedReader clientInput;

    public static Socket clientSocket;
    public static boolean isShutdownRequested;

    public static void run() {
        try {
            createSocket();
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            clientInput = new BufferedReader(new InputStreamReader(System.in));

            UserNameHandler.LoginToServer();

            ReadMessageThread readMessageThread = new ReadMessageThread();
            readMessageThread.start();
            WriteMessageThread writeMessageThread = new WriteMessageThread();
            writeMessageThread.start();
            try {
                writeMessageThread.join();
                readMessageThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        shutdown();
    }

    private static void createSocket() throws IOException {
        if (clientSocket == null) {
            InetAddress ipAddressOfServer = InetAddressInput.getInetAddress();
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter port");
            int port = scanner.nextInt();
            clientSocket = new Socket(ipAddressOfServer, port);
            if (clientSocket.isConnected()) {
                System.out.println("Connected to server" + "\n");
            }
        }
    }

    private static void shutdown() {
        try {
            if (!clientSocket.isClosed()) {
                clientSocket.close();
            }
            Client.reader.close();
            Client.writer.close();
            System.out.println("client is closed");

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
