package CNVP_Lab2_CLient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

public class InetAddressInput {

    public static InetAddress getInetAddress() throws UnknownHostException {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Input server's IP address or press enter to use default (127.0.0.1)");
            String ipAddressOfServer = in.nextLine();
            if (ipAddressOfServer.equals("")) {
                ipAddressOfServer = "127.0.0.1";
            }
            boolean validation = validateIp(ipAddressOfServer);
            if (validation) {
                return InetAddress.getByName(ipAddressOfServer);
            }
            else {
                System.out.print("The IP address " + ipAddressOfServer + " isn't valid");
            }
        }
    }

    public static boolean validateIp(String ipAddress) {
        String[] groups = ipAddress.split("\\.");

        if (groups.length != 4)
            return false;

        try {
            return Arrays.stream(groups)
                    .filter(s -> s.length() >= 1)
                    .map(Integer::parseInt)
                    .filter(i -> (i >= 0 && i <= 255))
                    .count() == 4;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
