package quentinetpierre.calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SampleForm {
    private JPanel panel1;
    private JButton plus;
    private JButton moins;
    private JButton multiplication;
    private JButton division;
    private JTextField champ1;
    private JTextField champ2;
    private JTextField result;

    private SuperCalculator1998Application calculator;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new SampleForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public SampleForm(){
        this.calculator = new SuperCalculator1998Application();

        plus.addActionListener(new PlusButtonClicked());
        moins.addActionListener(new MoinsButtonClicked());
        multiplication.addActionListener(new MultiButtonClicked());
        division.addActionListener(new DivisionButtonClicked());
    }

    private class PlusButtonClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            result.setText( Integer.toString(calculator.plus(Integer.parseInt(champ1.getText()), Integer.parseInt(champ2.getText()))) );
        }
    }

    private class MoinsButtonClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            result.setText( Integer.toString(calculator.minus(Integer.parseInt(champ1.getText()), Integer.parseInt(champ2.getText()))) );
        }
    }

    private class MultiButtonClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            result.setText( Integer.toString(calculator.multiply(Integer.parseInt(champ1.getText()), Integer.parseInt(champ2.getText()))) );
        }
    }

    private class DivisionButtonClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            result.setText( Integer.toString(calculator.divide(Integer.parseInt(champ1.getText()), Integer.parseInt(champ2.getText()))) );
        }
    }



}
