package br.edu.utfpr.alunos.bignelli;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BitByteUtils {
    public static ArrayList<Integer> stringToBitArray(String text){
        try{
            ArrayList<Integer> result = new ArrayList<Integer> () ;

            byte byteArray[] = text.getBytes();
            System.out.println(Arrays.toString(byteArray));


            for(int i=0;i<text.length();i++) {
                result.addAll(byteToBitArray(byteArray[i]));
            }
            System.out.println(result.toString());
            return result;
        }catch (Exception ex){
            throw ex;
        }

    }

    public static ArrayList<Integer> byteToBitArray(int intByte){
        ArrayList<Integer> result = new ArrayList<Integer>();

/*      if(intByte<0){
            result.add(1);
            intByte = -intByte;
        }else{
            result.add(0);
        }*/

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

    public static int bitArrayToIntegerByte(int[] bitArray){
        int result = 0;

        for(int i = 0; i < 8; i++){
            if(bitArray[i]==1){
                result = result + (int)Math.pow(2,7-i);
            }
        }

        return result;
    }

}

