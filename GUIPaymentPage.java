/*
* PaymentPage.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
About this class: 
    Takes in the users information for buying a ticket and uses those details to book a ticket
*/

import java.awt.*;
import javax.swing.*;

public class GUIPaymentPage extends JPanel {
    private JPanel panel;
    private JLabel message;
    private JLabel email;
    private JTextField emailField;
    private JLabel name;
    private JTextField nameField;
    private JLabel CC; // --> credit card number
    private JTextField CCField;
    private JLabel expiry;
    private JTextField expiryField;
    private JLabel CVV;
    private JTextField CVVField;
    private JButton back; // --> Goes back to seat selection
    private JButton pay; // --> Attempts to confirm payment when this button is pressed
    GridBagConstraints gbc = new GridBagConstraints();


    public GUIPaymentPage() {
        panel = new JPanel();

        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(50, 168, 137));

        email = new JLabel("Enter Email: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,0,10,0);
        panel.add(email, gbc);

        emailField = new JTextField(20);
        gbc.gridx = 6;
        gbc.gridy = 2;
        panel.add(emailField, gbc);

        name = new JLabel("Enter Card Holder Name: ");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(10,0,10,0);
        panel.add(name, gbc);

        nameField = new JTextField(20);
        gbc.gridx = 6;
        gbc.gridy = 4;
        panel.add(nameField, gbc);

        CC = new JLabel("Enter Card Number: ");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(CC, gbc);

        CCField = new JTextField(20);
        gbc.gridx = 6;
        gbc.gridy = 6;
        panel.add(CCField, gbc);

        expiry = new JLabel("Enter Expiry Date: ");
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(expiry, gbc);

        expiryField = new JTextField(20);
        gbc.gridx = 6;
        gbc.gridy = 8;
        panel.add(expiryField, gbc);

        CVV = new JLabel("Enter CVV: ");
        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(CVV, gbc);

        CVVField = new JTextField(20);
        gbc.gridx = 6;
        gbc.gridy = 10;
        panel.add(CVVField, gbc);

        back = new JButton("<--");
        gbc.gridx = 0;
        gbc.gridy = 12;
        panel.add(back, gbc);

        pay = new JButton("Proceed with Payment");
        gbc.gridx = 6;
        gbc.gridy = 12;
        panel.add(pay, gbc);

        panel.setVisible(true);

    }

    public JPanel getPanel() {
        return panel;
    }

    public String getEmailText() {
        return this.emailField.getText();
    }

    public String getNameText() {
        return this.nameField.getText();
    }

    public String getCardText() {
        return this.CCField.getText();
    }

    public String getExpiryText() {
        return this.expiryField.getText();
    }

    public String getCVVText() {
        return this.CVVField.getText();
    }

    public JButton getBack() {
        return this.back;
    }

    public JButton getPay() {
        return this.pay;
    }

    public void displayPrice(int selectedTicketNum) {
        int total = selectedTicketNum * 8;
        message = new JLabel("Your total is: " + total);
        gbc.gridwidth = 7;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(message, gbc);
        panel.validate();
    }

    public void setTexts(String email, String name, String card) { //If the user is registered it will retrive data from registered user and set the text fields
        emailField.setText(email);
        nameField.setText(name);
        CCField.setText(card);
    }
}
