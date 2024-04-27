package org.example.GUI;

import org.example.Logic.Operatii;
import org.example.Model.Polinom;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public class View extends JFrame{

    private JTextField userInputTf1 = new JTextField(30);
    private JTextField userInputTf2 = new JTextField(30);
    private JTextField totalTf = new JTextField(30);
    private JButton addBtn = new JButton("+");
    private JButton subBtn = new JButton("-");
    private JButton mulBtn = new JButton("*");
    private JButton intBtn = new JButton("Integrare");
    private JButton derBtn = new JButton("Derivare");
    private JButton clearBtn=new JButton("Clear");

    private Operatii calculator;

    public View(Operatii o){
        this.calculator=o;
        Polinom p=new Polinom(Operatii.INITIAL_VALUE);
        this.calculator.setResult(p);
        totalTf.setText(calculator.getResult());
        totalTf.setEditable(false);

        JPanel panel1 = new JPanel();
        panel1.add(addBtn);
        panel1.add(mulBtn);
        panel1.add(intBtn);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        JPanel panel2 = new JPanel();
        panel2.add(subBtn);
        panel2.add(derBtn);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Polinom 1"));
        panel3.add(userInputTf1);
        panel3.add(new JLabel("Polinom 2"));
        panel3.add(userInputTf2);
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(panel3);
        content.add(panel1);
        content.add(panel2);
        content.add(new JLabel("Total"));
        content.add(totalTf);
        content.add(clearBtn);

        this.setContentPane(content);
        this.pack();

        this.setTitle("Calculator polinomial");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void reset(){
        totalTf.setText(Operatii.INITIAL_VALUE);
    }
    String getUserInput1(){
        return userInputTf1.getText();
    }
    String getUserInput2(){
        return userInputTf2.getText();
    }
    void setTotal(String newTotal){
        totalTf.setText(newTotal);
    }
    void showError(String errMessage){
        JOptionPane.showMessageDialog(this,errMessage);
    }
    void addAddListener(ActionListener mal){
        addBtn.addActionListener(mal);
    }
    void addSubListener(ActionListener mal){
        subBtn.addActionListener(mal);
    }
    void addMulListener(ActionListener mal){
        mulBtn.addActionListener(mal);
    }
    void addIntegralListener(ActionListener mal){
        intBtn.addActionListener(mal);
    }
    void addDerListener(ActionListener mal){
        derBtn.addActionListener(mal);
    }
    void addClearListener(ActionListener mal){
        clearBtn.addActionListener(mal);
    }
}
