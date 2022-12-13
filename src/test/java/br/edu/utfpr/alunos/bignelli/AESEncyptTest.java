package br.edu.utfpr.alunos.bignelli;

import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESEncyptTest {

    public static String encrypt(final String secret, final String data) {


        byte[] decodedKey = Base64.getDecoder().decode(secret);

        try {
            Cipher cipher = Cipher.getInstance("AES");
            // rebuild key using SecretKeySpec
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(data.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error occured while encrypting data", e);
        }

    }

    public static String decrypt(final String secret,
                                 final String encryptedString) {


        byte[] decodedKey = Base64.getDecoder().decode(secret);

        try {
            Cipher cipher = Cipher.getInstance("AES");
            // rebuild key using SecretKeySpec
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.DECRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
            return new String(cipherText);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error occured while decrypting data", e);
        }
    }


    public static void main(String[] args) {

        String data = "Pellentesque non orci dignissim, euismod urna at, fringilla libero. Ut tempus dictum velit, vel elementum tortor vehicula non. Pellentesque sodales augue in aliquet posuere. Pellentesque quis nibh eu sem rhoncus euismod et sed tellus. Nam id lectus quis ligula interdum tempus sit amet vitae ipsum. Nulla iaculis rhoncus dapibus. Integer accumsan justo risus, nec rhoncus elit dapibus vitae. Donec lacinia diam ut metus finibus, non rhoncus dui condimentum. Pellentesque at tellus nec nunc semper fermentum non at lorem. Duis gravida augue ornare purus feugiat, at sagittis justo tincidunt. Proin aliquet nibh ut purus pulvinar mattis eget vel erat. Aliquam erat volutpat. Donec quis cursus ligula, quis sollicitudin elit. Integer lacinia mauris ac justo egestas egestas. Aenean elementum ante nec malesuada dapibus";
        String key = "ewa24C37TwGh6qv2BmqeHg==";
        String encrypted = encrypt(key, data);
        System.out.println(encrypted);
        System.out.println(decrypt(key, encrypted));
    }
}