package br.edu.utfpr.alunos.bignelli;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class ServerInterface extends JFrame implements ActionListener {

    protected JTextField inputTexto;
    protected JFrame f;
    private JButton botaoEnter;
    protected JLabel labelPorta;
    private JLabel labelMsg;
    private JLabel labelMsgBin;
    private JLabel labelAlgoritmo1;
    private JLabel labelAlgoritmo2;

    private ChartPanel painelGrafico;

    private Consumer<String> setIP;

    public ServerInterface(Consumer<String> setIP) {
        this.setIP = setIP;
        f = new JFrame("Escolher porta do IP: " + NetUtils.getLocalIP());
        labelPorta = new JLabel(" ");
        labelMsg = new JLabel("Mensagem");
        labelMsgBin = new JLabel("MensagemBinario");
        labelAlgoritmo1 = new JLabel("MensagemAlgoritmo");
        labelAlgoritmo2 = new JLabel("MensagemAlgoritmo2");
        botaoEnter = new JButton("Enter");
        botaoEnter.addActionListener(this);
        inputTexto = new JTextField(16);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        painelGrafico = new ChartPanel(null);
        painelGrafico.setSize(new Dimension(300, 300));
        //painelGrafico.setLayout(new BoxLayout(painelGrafico, BoxLayout.Y_AXIS));

        p.add(inputTexto);
        p.add(botaoEnter);
        p.add(labelPorta);
        p.add(labelMsg);
        p.add(labelMsgBin);
        p.add(labelAlgoritmo1);
        p.add(labelAlgoritmo2);

        f.add(p, BorderLayout.NORTH);
        f.add(painelGrafico, BorderLayout.SOUTH);
        f.setSize(1200, 900);
        f.show();
    }

    public ServerInterface() {
        this(null);
    }

    public void setMsgs(String msg, String msgBin, String algo, int[] arr) {
        labelMsg.setText("Mensagem: " + msg);
        labelMsgBin.setText("Binario: " + msgBin);
        labelAlgoritmo1.setText("Pos algoritmo: " + algo);

        //DefaultXYDataset dataset = new DefaultXYDataset();
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("Sequencia transformada");
        //double[][] data = new double[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            //data[i][0] = i;
            //data[i][1] = arr[i];
            series.add(i, arr[i]);
        }
        dataset.addSeries(series);
        //dataset.addSeries(1, data);
        JFreeChart chart = ChartFactory.createXYLineChart("Grafico", "x", "y", dataset);
        XYPlot plot = (XYPlot) chart.getPlot();
        NumberAxis domain = (NumberAxis) plot.getRangeAxis();
        //domain.setRange(0.00, 1.02);
        //domain.setTickUnit(new NumberTickUnit(0.5));
        painelGrafico.setChart(chart);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Enter")) {
            labelPorta.setText("Porta: " + inputTexto.getText());
            if (setIP != null) {
                setIP.accept(inputTexto.getText()); // chama a funcao setIp do main
            }
            inputTexto.setText("");
        }
    }
}
