package br.edu.utfpr.alunos.bignelli;

import java.net.*;

public class NetUtils {

    //https://stackoverflow.com/questions/9481865/getting-the-ip-address-of-the-current-machine-using-java
    public static String getLocalIP(int port) {
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), port);
            return socket.getLocalAddress().getHostAddress();
        } catch(UnknownHostException | SocketException e) {
            return null;
        }
    }

    public static String getLocalIP() {
        return getLocalIP(10002);
    }

    public static InetSocketAddress getSocket(String porta) {
        try {
            int i = Integer.parseInt(porta);
            return InetSocketAddress.createUnresolved(getLocalIP(), i);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}
