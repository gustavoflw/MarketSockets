package br.edu.utfpr.alunos.bignelli;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HDB3Encoder {
    public static int[] encodeString(String text,String desKey) throws Exception {
        try{
            List<Integer> bitList = BitByteUtils.stringToBitArray(text,desKey);
            int[] bitArray = bitList.stream().mapToInt(i -> i).toArray();
            int totalInversions = 0;
            boolean invert = false;

            for (int i = 0; i < bitArray.length; i++) {
                if (bitArray[i] == 1) {
                    if (invert) {
                        bitArray[i] = -1;
                    }
                    invert = !invert;
                    totalInversions++;
                } else{
                    if(i+3<bitArray.length-1){
                        if(bitArray[i] == 0 && bitArray[i + 1] == 0 && bitArray[i + 2] == 0 && bitArray[i + 3] == 0) {
                            if (totalInversions % 2 == 0) {
                                if (invert) {
                                    bitArray[i] = -1;
                                    bitArray[i + 3] = -1;
                                } else {
                                    bitArray[i] = 1;
                                    bitArray[i + 3] = 1;
                                }
                                invert = !invert;

                            } else {
                                bitArray[i + 3] = bitArray[i - 1];
                            }

                            totalInversions = 0;
                            i = i + 3;
                        }
                    }
                }
            }
            return bitArray;
        }catch(Exception ex){
            throw ex;
        }


    }

    public static void decodeToBitArray(int[] signal){
        for (int i = 0; i < signal.length; i++) {
            if(signal[i] != 0) {
                if(signal.length-1 > i+4){
                    if (signal[i + 1] == 0 && signal[i + 2] == 0&&signal[i + 3]==0&& signal[i + 4]==signal[i]){
                        signal[i + 4] = 0;
                        signal[i] = 1;
                        i = i+4;
                    } else if (signal[i + 1] == 0 && signal[i + 2] == 0 && signal[i + 3] == signal[i]) {
                        signal[i + 3] = 0;
                        signal[i] = 0;
                        i = i + 3;
                    }else{
                        signal[i] = 1;
                    }
                } else if (signal.length-1 > i+3) {
                    if (signal[i + 1] == 0 && signal[i + 2] == 0 && signal[i + 3] == signal[i]) {
                        signal[i + 3] = 0;
                        signal[i] = 0;
                        i = i + 3;
                    }
                    else{
                        signal[i] = 1;
                    }
                }
                else{
                    signal[i] = 1;
                }
            }
        }
    }

    public static String decodeSignalArray(int[] signal,String desKey) throws Exception {
        ArrayList<Byte> byteArray = new ArrayList<>();


        //System.out.println(Arrays.toString(signal));

        decodeToBitArray(signal);

        //System.out.println(Arrays.toString(signal));

        for (int i = 0; i< signal.length; i=i+8){
            int[] singleByte= Arrays.copyOfRange(signal, i, i+8);
            byte b = (byte)BitByteUtils.bitArrayToIntegerByte(singleByte);
            int intB = b & 0xFF;
            byteArray.add(b);
        }

        byte[] byteText = new byte[byteArray.size()];

        for(int i = 0; i < byteArray.size(); i++) {
            byteText[i] = byteArray.get(i).byteValue();
        }

        return EncryptionUtils.Decrypt(byteText,desKey);
    }
}
