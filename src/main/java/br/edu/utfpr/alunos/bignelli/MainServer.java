package br.edu.utfpr.alunos.bignelli;

import java.io.IOException;
import java.util.Arrays;

//Inicialmente copiado de https://www.baeldung.com/a-guide-to-java-sockets
public class MainServer {

    private static int port;
    private static ServerInterface servIf;

    public static void main(String[] args) {
        servIf = new ServerInterface(MainServer::setIp);
    }

    public static void startServer() {
        Server server = new Server();
        //setIp("6666");
        try {
            server.start(port);
            ServerClientResult result = server.receiveMessage();
            String msg = result.getMsg();
            System.out.println("MENSAGEM : " + msg);
            servIf.setMsgs(msg, BitByteUtils.binaryRepresentation(msg), Arrays.toString(result.getArray()), result.getArray());
        } catch (Exception e) {
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
            port = 6666; // default
        }
    }
}

