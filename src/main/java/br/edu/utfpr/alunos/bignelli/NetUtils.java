package br.edu.utfpr.alunos.bignelli;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

    public static void sendIntArray(DataOutputStream os, int[] data) throws IOException {
        os.writeInt(data.length);
        for (int valor : data) {
            os.writeInt(valor);
        }
    }

    public static int[] recvIntArray(DataInputStream is) throws IOException {
        int len = is.readInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = is.readInt();
        }
        return arr;
    }
}
