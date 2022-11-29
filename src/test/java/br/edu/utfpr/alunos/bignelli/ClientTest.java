package br.edu.utfpr.alunos.bignelli;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    @Test
    public void testarClienteEServidor() {
        Client client = new Client();
        String response = "";

        try {
            client.startConnection("127.0.0.1", 6666);
            response = client.sendMessage("hello server");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("hello client", response);
    }
}
