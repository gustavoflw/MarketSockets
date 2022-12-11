package br.edu.utfpr.alunos.bignelli;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class ChooseSocketInterface extends JFrame implements ActionListener {

    private JTextField t;
    private JFrame f;
    private JButton b;
    private JLabel l;

    private Consumer<String> setIP;

    public ChooseSocketInterface(Consumer<String> setIP) {
        this.setIP = setIP;
        f = new JFrame("Escolher IP");
        l = new JLabel(" ");
        b = new JButton("Enter");
        b.addActionListener(this);
        t = new JTextField(16);

        JPanel p = new JPanel();

        p.add(t);
        p.add(b);
        p.add(l);

        f.add(p);
        f.setSize(300, 200);
        f.show();
    }

    public ChooseSocketInterface() {
        this(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Enter")) {
            l.setText(t.getText());
            setIP.accept(t.getText()); // chama a funcao setIp do main
            t.setText("");
        }
    }
}
