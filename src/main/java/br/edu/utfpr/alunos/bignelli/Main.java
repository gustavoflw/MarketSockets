package br.edu.utfpr.alunos.bignelli;

import java.io.IOException;

//Inicialmente copiado de https://www.baeldung.com/a-guide-to-java-sockets
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Server server = new Server();
        try {
            server.start(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}