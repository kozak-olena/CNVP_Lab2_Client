package CNVP_Lab2_CLient;

import java.io.*;
import java.net.Socket;

public class Client {

    public Socket socket;
    public static BufferedReader in;
    public static BufferedWriter out;
    public static BufferedReader inputUser;
    public static ReadMessageThread readMessageThread = new ReadMessageThread();
    public static WriteMessageThread writeMessageThread = new WriteMessageThread();

    public Client() throws IOException {
        socket = new Socket("127.0.0.1", 5542);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        inputUser = new BufferedReader(new InputStreamReader(System.in));
        readMessageThread.start();
        writeMessageThread.start();
    }
}
