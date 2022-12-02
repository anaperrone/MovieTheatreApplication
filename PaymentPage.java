/*
* PaymentPage.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaymentPage extends JPanel implements ActionListener {
    CardLayout maincl;
    JPanel mainPanel;
    private JPanel panel;
    private JLabel name;
    private JTextField nameField;
    private JLabel CC;
    private JTextField CCField;
    private JLabel expiry;
    private JTextField expiryField;
    private JLabel CVV;
    private JTextField CVVField;
    private JButton back;
    private JButton pay;


    public PaymentPage(CardLayout cl, JPanel pan) {
        maincl = cl;
        mainPanel = pan;
        panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(new Color(50, 168, 137));

        name = new JLabel("Enter Card Holder Name: ");
        name.setBounds(10, 20, 80, 25);
        panel.add(name);

        nameField = new JTextField(20);
        nameField.setBounds(100, 20, 165, 25);
        panel.add(nameField);

        CC = new JLabel("Enter Card Number: ");
        CC.setBounds(10, 50, 80, 25);
        panel.add(CC);

        CCField = new JTextField(20);
        CCField .setBounds(100, 50, 165, 25);
        panel.add(CCField);

        expiry = new JLabel("Enter Expiry Date: ");
        expiry.setBounds(10, 80, 80, 25);
        panel.add(expiry);

        expiryField = new JTextField(20);
        expiryField.setBounds(100, 80, 165, 25);
        panel.add(expiryField);

        CVV = new JLabel("Enter CVV: ");
        CVV.setBounds(10, 80, 80, 25);
        panel.add(CVV);

        CVVField = new JTextField(20);
        CVVField.setBounds(100, 110, 165, 25);
        panel.add(CVVField);

        back = new JButton("<--");
        back.setBounds(50,140,80,25);
        back.addActionListener(this);
        panel.add(back);

        pay = new JButton("Proceed with Payment");
        pay.setBounds(160, 140, 150, 25);
        pay.addActionListener(this);
        panel.add(pay);

        panel.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            maincl.show(mainPanel, "1");
        }

        // if(e.getSource() == pay) {
        //    maincl.show(mainPanel, "");
        // }
    }

    public JPanel getPanel() {
        return panel;
    }
}
