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

    public void sendMessage(String msg) {
        String encrypted = EncryptionUtils.encrypt(msg, SecretConstant.KEY);

        try {
            System.out.println("Mandando criptografada");
            NetUtils.sendIntArray(os, HDB3Encoder.encodeString(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        os.close();
        clientSocket.close();
    }
}
