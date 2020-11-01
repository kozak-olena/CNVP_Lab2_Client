package CNVP_Lab2_CLient;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.*;

public class WriteMessageThread extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                String inputMessage = readLine();
                if (inputMessage.equals("stop")) {
                    SendDataService.sendMessage(inputMessage);
                    Client.isShutdownRequested = true;
                    break;
                } else {
                    SendDataService.sendMessage(inputMessage);
                }
            }
        } catch (InterruptedIOException exception) {
            System.out.println("User input listener thread stopped");
        } catch (IOException exception) {
            if (!Client.clientSocket.isConnected()) {
                System.out.println("server closed connection");
            } else {
                exception.printStackTrace();
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public String readLine() throws IOException, InterruptedException {
        String s = "";
        while (true) {
            if (Client.isShutdownRequested) {
                throw new InterruptedIOException("IO interrupted due to shutdown request");
            }
            if (Client.clientInput.ready()) {
                int c = Client.clientInput.read();
                if (c == -1) throw new IOException("Unexpected end of stream");
                if ((char) c == '\n') break;
                s += (char) c;
            } else {
                sleep(100);
            }
        }
        return s;
    }
}

