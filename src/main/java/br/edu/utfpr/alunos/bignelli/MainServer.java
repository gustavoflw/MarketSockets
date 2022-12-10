package br.edu.utfpr.alunos.bignelli;

import java.io.IOException;

//Inicialmente copiado de https://www.baeldung.com/a-guide-to-java-sockets
public class MainServer {

    public static void main(String[] args) {
       Server server = new Server();
        try {
            server.start(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

