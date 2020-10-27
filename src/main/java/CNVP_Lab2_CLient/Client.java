package CNVP_Lab2_CLient;

import java.io.*;
import java.net.Socket;

public class Client {

    public Socket socket;
    public static BufferedReader in;
    public static BufferedWriter out;

    public Client() throws IOException {

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

    }
}
