package br.edu.utfpr.alunos.bignelli;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;

class EncryptionUtils {
    public static String encrypt(String text, String Key) throws Exception {

        try
        {
            System.out.println("string:"+text);

            Key aesKey = getEncryptKeyFromString(Key);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);

            byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
            System.out.println("Encrypted string:"+new String(encrypted,"UTF-8"));

            byte[] encryptedBase64 = Base64.getEncoder().encode(encrypted);

            String encryptedBase64String = new String(encryptedBase64);
            System.out.println("Encrypted string:"+encryptedBase64String);

            return encryptedBase64String ;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String text, String Key) throws Exception {
        System.out.println("Encrypted string:"+text);

        Key aesKey = getDecryptKeyFromString(Key);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, aesKey);

        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(text.getBytes()));

        String decryptedText = new String(decrypted);
        System.out.println("Decrypted string:"+decryptedText);


        return decryptedText;
    }
    public static SecretKey getDecryptKeyFromString(String Key) throws Exception {

        byte[] byteKey =  Base64.getDecoder().decode(Key);
        SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(byteKey, 16), "AES");
        return originalKey;
    }

    public static Key getEncryptKeyFromString(String Key) throws Exception {

        byte[] byteKey =  Base64.getDecoder().decode(Key);

        SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(byteKey, 16), "AES");

        return originalKey;
    }
}
