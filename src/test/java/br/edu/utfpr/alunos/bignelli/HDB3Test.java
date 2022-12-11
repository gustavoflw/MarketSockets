package br.edu.utfpr.alunos.bignelli;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HDB3Test {

    private static final String TEXTO = "Pellentesque non orci dignissim, euismod urna at, fringilla libero. Ut tempus dictum velit, vel elementum tortor vehicula non. Pellentesque sodales augue in aliquet posuere. Pellentesque quis nibh eu sem rhoncus euismod et sed tellus. Nam id lectus quis ligula interdum tempus sit amet vitae ipsum. Nulla iaculis rhoncus dapibus. Integer accumsan justo risus, nec rhoncus elit dapibus vitae. Donec lacinia diam ut metus finibus, non rhoncus dui condimentum. Pellentesque at tellus nec nunc semper fermentum non at lorem. Duis gravida augue ornare purus feugiat, at sagittis justo tincidunt. Proin aliquet nibh ut purus pulvinar mattis eget vel erat. Aliquam erat volutpat. Donec quis cursus ligula, quis sollicitudin elit. Integer lacinia mauris ac justo egestas egestas. Aenean elementum ante nec malesuada dapibus";
    private static final byte[] desKey = "Djex85fs".getBytes();

/*    static {
        try {
            desKey = EncryptionUtils.generateDesKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

    @Test
    public void testarEncodeDecode() throws Exception {
        int [] encodedSignal = HDB3Encoder.encodeString(TEXTO, desKey);

        assertEquals(HDB3Encoder.decodeSignalArray(encodedSignal, desKey), TEXTO);
    }

    @Test
    public void getEncoding() throws Exception {

    }
}
