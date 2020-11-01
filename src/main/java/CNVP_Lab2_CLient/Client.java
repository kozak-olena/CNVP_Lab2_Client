package CNVP_Lab2_CLient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

    public static BufferedReader reader;
    public static BufferedWriter writer;
    public static BufferedReader clientInput;
    public static ReadMessageThread readMessageThread = new ReadMessageThread();
    public static WriteMessageThread writeMessageThread = new WriteMessageThread();
    public static Socket clientSocket;
    public static boolean isShutdownRequested;


    public static void startReadAndWriteThread() throws IOException {
        try {
            InetAddress ipAddressOfServer = InetAddressInput.getInetAddress();
            clientSocket = new Socket(ipAddressOfServer, 5555);
            if (clientSocket.isConnected()) {
                System.out.println("Connected to server" + "\n");
            }
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try {
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            clientInput = new BufferedReader(new InputStreamReader(System.in));
            String userName = UserName.inputYourName();
            //TODO: validation is stream or server alive
            writer.write(UserNameHandler.getSerializedName(userName) + "\n");
            writer.flush();
            readMessageThread.start();
            writeMessageThread.start();

        } catch (IOException ex) {
            if (!reader.ready()) {
                System.out.println("server closed connection");
            } else {
                ex.printStackTrace();
            }
        }
    }

    public static void downService() {
        try {
            if (!clientSocket.isClosed()) {
                Client.reader.close();
                Client.writer.close();
                clientSocket.close();
                System.out.println("client is closed");
            }
        } catch (IOException ignored) {
        }
    }
}
