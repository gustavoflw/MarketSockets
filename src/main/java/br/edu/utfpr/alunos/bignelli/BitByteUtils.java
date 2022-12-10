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
        boolean isNegative = intByte <0;

        if(intByte < 8){
            intByte = 1-intByte;
        }

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

        if(isNegative){
            for (int i = 0; i<result.size();i++){
                if(result.get(i)==0){
                    result.set(i, 1);
                }else{
                    result.set(i, 0);
                }
            }
        }

        Collections.reverse(result);

        return result;
    }

    public static int bitArrayToIntegerByte(int[] bitArray){
        int result = 0;
        if(bitArray[0]==0){
            for(int i = 1; i < 8; i++){
                if(bitArray[i]==1){
                    result = result + (int)Math.pow(2,7-i);
                }
            }
        }else{
            for(int i = 1; i < 8; i++){
                if(bitArray[i]==0){
                    result = result + (int)Math.pow(2,7-i);
                }
            }
            result = result-1;
            result = -result;
        }


        return result;
    }

}

