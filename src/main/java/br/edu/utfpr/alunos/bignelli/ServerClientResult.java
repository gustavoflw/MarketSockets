package br.edu.utfpr.alunos.bignelli;

public class ServerClientResult {

    public static final String KEY = "ewa24C37TwGh6qv2BmqeHg==";
    private final int[] arr;
    private final String msg;

    public ServerClientResult(int[] arr, String msg) {
        this.arr = arr;
        this.msg = msg;
    }

    public int[] getArray() {
        return this.arr;
    }

    public String getMsg() {
        return this.msg;
    }

}
