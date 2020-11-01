package CNVP_Lab2_CLient;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.*;

public class WriteMessageThread extends Thread {

    public static boolean status = true;

    @Override
    public void run() {
        try {
            String inputMessage;
            while (true) {

                inputMessage = readLine();
                if (inputMessage.equals("stop")) {
                    String data = SendData.getDataToSend(inputMessage);
                    send(data + "\n");
                    status = getStatus(inputMessage);

                    break;
                } else {
                    String data = SendData.getDataToSend(inputMessage);
                    send(data + "\n");
                }
            }
        } catch (InterruptedIOException exception) {
            System.out.println("User input listener thread stopped");
        } catch (JsonProcessingException exception) {
            exception.printStackTrace();
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

    public static boolean getStatus(String input) {
        if (input.equals("stop")) {
            return false;
        } else {
            return true;
        }
    }

    public static void send(String data) throws IOException {
        Client.writer.write(data);
        Client.writer.flush();
    }


}

