package br.edu.utfpr.alunos.bignelli;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;

class EncryptionUtils {
    public static byte[] encrypt(String text, String Key) throws Exception {

        try
        {
            System.out.println("string:"+text);

            Key aesKey = getEncryptKeyFromString(Key);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);

            byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
            System.out.println("Encrypted string:"+new String(encrypted,"UTF-8"));

            byte[] encryptedBase64 = Base64.getEncoder().encode(encrypted);
            System.out.println("Encrypted string:"+new String(encrypted,"UTF-8"));

            return encryptedBase64;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static String Decrypt(byte[] textArray, String Key) throws Exception {
        Key aesKey = getDecryptKeyFromString(Key);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(textArray));

        return new String(decrypted, "UTF-8");
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
