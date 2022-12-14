package br.edu.utfpr.alunos.bignelli;

import java.util.Arrays;

public class MainClient {

    private static String ip;
    private static int port;

    private static ClientInterface clientIf;

    public static void main(String[] args) {

        clientIf = new ClientInterface();

    }

    public static void send(String msg) {
        Client client = new Client();
        try {
            client.startConnection(ip, port);
            int arr[] = client.sendMessage(msg);
            clientIf.setMsgs(msg, BitByteUtils.binaryRepresentation(msg), Arrays.toString(arr), arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setIP(String ip, int port) {
        MainClient.ip = ip;
        MainClient.port = port;
    }
}
