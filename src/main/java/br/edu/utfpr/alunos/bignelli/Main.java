package br.edu.utfpr.alunos.bignelli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Inicialmente copiado de https://www.baeldung.com/a-guide-to-java-sockets
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        HDB3Encoder.stringToBitArray("oi");
/*        Server server = new Server();
        try {
            server.start(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}

class HDB3Encoder{

    public static ArrayList<Integer> encodeString(String text){
        ArrayList<Integer> result = new ArrayList<Integer>();

        return result;
    };

    public static ArrayList<Integer> stringToBitArray(String text){
        try{
            ArrayList<Integer> result = new ArrayList<Integer> () ;
            byte[] byteArr = text.getBytes();
            // print the byte[] elements
            System.out.println("String to byte array: " + Arrays.toString(byteArr));

            byte a[]=new byte[160];

            a=text.getBytes();

            for(int i=0;i<text.length();i++) {

                result.addAll(byteToBit(a[i]));
            }
            return result;
        }catch (Exception ex){
            throw ex;
        }

    }

    public static ArrayList<Integer> byteToBit(int intByte){
        ArrayList<Integer> result = new ArrayList<Integer>();

        while(intByte > 0){
            if(intByte%2 == 0){
                result.add(0);
            }else{
                result.add(1);
                intByte--;
            }
            intByte = intByte/2;
        }

        if(result.size()<8){
            while(result.size() <8){
                result.add(0);
            }
        }
        Collections.reverse(result);

        return result;
    }
    public static  int bitToByte(ArrayList<Integer> intByte){
        try{
            int result = 0;
            for (int i = 0; i<intByte.size(); i++){
                if(intByte.get(i) == 1){
                    result = result+ (int)Math.pow(2, 7-i);
                }
            }
            return result;
        }catch(Exception ex){
            throw ex;
        }
    }

}

class HDB3Decoder{

}