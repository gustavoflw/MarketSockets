package br.edu.utfpr.alunos.bignelli;

import java.io.IOException;

public class MainClient {

    public static void main(String[] args) {
        Client client = new Client();
        String response = "";

        try {
            client.startConnection("127.0.0.1", 6666);
            response = client.sendMessage("hello server");
            System.out.println("Resposta: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
