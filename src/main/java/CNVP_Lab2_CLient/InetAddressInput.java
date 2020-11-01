package CNVP_Lab2_CLient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAddressInput {

    public static InetAddress getInetAddress() throws UnknownHostException {
        System.out.println("Input server's IP address or to use default press 1");
        Scanner in = new Scanner(System.in);
        while (true) {
            String ipAddressOfServer = in.nextLine();
            if (ipAddressOfServer.equals("1")) {
                ipAddressOfServer = "127.0.0.1";
            }
            boolean validation = validateIp(ipAddressOfServer);
            if (validation) {
                return InetAddress.getByName(ipAddressOfServer);
            } else {
                System.out.println("Input server's IP address or to use default press 1");
            }
        }
    }

    public static boolean validateIp(String inputedIp) {
        if (Validation.isValidInetAddress(inputedIp)) {
            return true;
        } else {
            System.out.print("The IP address " + inputedIp + " isn't valid");
            return false;
        }

    }
}
