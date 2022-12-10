package br.edu.utfpr.alunos.bignelli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Inicialmente copiado de https://www.baeldung.com/a-guide-to-java-sockets
public class Main {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString("".getBytes()));

        int [] encodedSignal = HDB3Encoder.encodeString("oiê");


        //System.out.println(Arrays.toString(encodedSignal));
        HDB3Encoder.decodeSignalArray(encodedSignal);
        //System.out.println(HDB3Encoder.decodeSignalArray(encodedSignal));


        ;
/*        Server server = new Server();
        try {
            server.start(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}

