package br.edu.utfpr.alunos.bignelli;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private DataOutputStream os;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        os = new DataOutputStream(clientSocket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public int[] sendMessage(String msg) {
        String encrypted = EncryptionUtils.encrypt(msg, ServerClientResult.KEY);

        try {
            System.out.println("Mandando criptografada");
            int[] arr = HDB3Encoder.encodeString(encrypted);
            NetUtils.sendIntArray(os, arr);
            return arr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        os.close();
        clientSocket.close();
    }
}
