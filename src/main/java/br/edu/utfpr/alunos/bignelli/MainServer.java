package br.edu.utfpr.alunos.bignelli;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

//Inicialmente copiado de https://www.baeldung.com/a-guide-to-java-sockets
public class MainServer {

    private static InetAddress ip;

    public static void main(String[] args) {
       /*Server server = new Server();
        try {
            server.start(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        new ChooseSocketInterface(MainServer::setIp);
    }

    //chamado pela interface de usuario
    private static void setIp(String pos) {
        try {
            ip = InetAddress.getByName(pos);
            System.out.println("Colocado IP: " + ip.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

