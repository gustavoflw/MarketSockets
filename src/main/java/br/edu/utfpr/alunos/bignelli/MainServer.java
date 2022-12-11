package br.edu.utfpr.alunos.bignelli;

import java.net.InetSocketAddress;

//Inicialmente copiado de https://www.baeldung.com/a-guide-to-java-sockets
public class MainServer {

    private static InetSocketAddress ip;

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
        ip = NetUtils.getSocket(pos);
        System.out.println("Colocado IP: " + ip.getHostName() + " com porta: " + ip.getPort());
    }
}

