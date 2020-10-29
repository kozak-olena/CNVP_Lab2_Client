package CNVP_Lab2_CLient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static BufferedReader reader;
    public static BufferedWriter writer;
    public static BufferedReader clientInput;
    public static ReadMessageThread readMessageThread = new ReadMessageThread();
    public static WriteMessageThread writeMessageThread = new WriteMessageThread();

    public static Socket createSocket(InetAddress ipAddress) throws IOException {

        Socket clientSocket = new Socket(ipAddress, 5542);
        if (clientSocket.isConnected()) {
            System.out.println("Connected to server" + "\n");
        }
        return clientSocket;
    }

    public static void startReadAndWriteThread(Socket socket) {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            clientInput = new BufferedReader(new InputStreamReader(System.in));
            String name = UserInput.inputYourName();
            UserNameHandler.getSerializedName(name);
            readMessageThread.start();
            writeMessageThread.start();
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            Client.downService(socket);
        }

    }

    private static void downService(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
                reader.close();
                writer.close();
            }
        } catch (IOException ignored) {
        }
    }
}
