package br.edu.utfpr.alunos.bignelli;

import java.awt.event.ActionEvent;

public class ClientInterface extends ServerInterface {

    private boolean escolheuIP = false;
    public ClientInterface() {
        super();
        f.setTitle("Comunique com o Servidor");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Enter")) {
            if (!escolheuIP) {
                labelPorta.setText("IP + Porta: " + inputTexto.getText());
                escolheuIP = true;
                setarIp(inputTexto.getText());
            } else {
                MainClient.send(inputTexto.getText());
            }
            inputTexto.setText("");
        }
    }

    private void setarIp(String iporta) {
        int port = 6666; //default
        String host = null;
        if (iporta.indexOf(':') > -1) {
            String[] arr = iporta.split(":");
            host = arr[0];
            try {
                port = Integer.parseInt(arr[1]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
            host = iporta;
        }
        MainClient.setIP(host, port);
    }
}
