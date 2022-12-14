package br.edu.utfpr.alunos.bignelli;

import java.io.IOException;

//Inicialmente copiado de https://www.baeldung.com/a-guide-to-java-sockets
public class MainServer {

    private static int port;

    public static void main(String[] args) {
        new ServerInterface(MainServer::setIp);
    }

    public static void startServer() {
        Server server = new Server();
        //setIp("6666");
        try {
            server.start(port);
            System.out.println("MENSAGEM : " + server.receiveMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //chamado pela interface de usuario
    private static void setIp(String pos) {
        try {
            port = Integer.parseInt(pos);
            startServer();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}

