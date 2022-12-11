package br.edu.utfpr.alunos.bignelli;

import javax.crypto.SecretKeyFactory;
import javax.crypto.*;
import javax.crypto.SecretKeyFactorySpi;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

class EncryptionUtils {
    public static byte[] encrypt(byte[] byteArray, byte[] byteKey) throws Exception {

        Cipher desCipher;
        desCipher = Cipher.getInstance("DES");

        SecretKey myDesKey = getDesKeyFromStringSecret(byteKey);
        desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

        byte[] byteArrayEncrypted = desCipher.doFinal(byteArray);

        System.out.println("Encrypted array"+Arrays.toString(byteArrayEncrypted));
        System.out.println("Encrypted string"+new String(byteArrayEncrypted));

/*        desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        byte[] byteArrayDecrypted = desCipher.doFinal(byteArrayEncrypted);

        System.out.println(Arrays.toString(byteArrayDecrypted));*/

        return byteArrayEncrypted;
    }

    public static byte[] Decrypt(byte[] byteArrayEncrypted, byte[] stringKey) throws Exception {

        Cipher desCipher;
        desCipher = Cipher.getInstance("DES");

        SecretKey myDesKey = getDesKeyFromStringSecret(stringKey);

        desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        System.out.println(Arrays.toString(byteArrayEncrypted));


        byte[] byteArrayDecrypted = desCipher.doFinal(byteArrayEncrypted);

        System.out.println(Arrays.toString(byteArrayDecrypted));

        return byteArrayDecrypted;
    }

    public static byte[] generateDesKey() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
        SecretKey myDesKey = keygenerator.generateKey();
        byte [] byteKey = myDesKey.getEncoded();

        return byteKey;
    }

    public static SecretKey getDesKeyFromStringSecret(byte[] byteKey) throws Exception {

        if(byteKey.length!=8){
            throw new Exception("Tamanho da chave incompativel");
        }

        SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
        SecretKeySpec keySpec = new SecretKeySpec(byteKey, "DES");
        SecretKey myDesKey = factory.generateSecret(keySpec);

        return myDesKey;
    }
}
