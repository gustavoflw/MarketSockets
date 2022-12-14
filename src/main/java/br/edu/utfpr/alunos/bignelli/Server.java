package br.edu.utfpr.alunos.bignelli;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private DataInputStream in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept(); //esse metodo bloqueia a thread até algum cliente conectar
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new DataInputStream(clientSocket.getInputStream());
    }

    public String receiveMessage() {
        try {
            int[] arr = NetUtils.recvIntArray(in);
            String encrypted = HDB3Encoder.decodeSignalArray(arr);
            return EncryptionUtils.decrypt(encrypted, SecretConstant.KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
