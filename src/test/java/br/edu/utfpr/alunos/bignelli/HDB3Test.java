package br.edu.utfpr.alunos.bignelli;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HDB3Test {

    private static final String TEXTO = "Bora rapaziadaaaa!!! Passar Ihaaa";

    @Test
    public void testarEncodeDecode() {
        int [] encodedSignal = HDB3Encoder.encodeString(TEXTO);

        assertEquals(HDB3Encoder.decodeSignalArray(encodedSignal), TEXTO);
        //System.out.println(Arrays.toString("".getBytes()));

        //System.out.println(Arrays.toString(encodedSignal));
        //System.out.println(HDB3Encoder.decodeSignalArray(encodedSignal));
    }
}
