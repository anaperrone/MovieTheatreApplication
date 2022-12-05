/*
* GUICancelTicket.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie

About this Class: 
    Takes in a unique ticket number and a corresponding email that is related to the user 
    User can then click a cancel ticket button to cancel their ticket or they can go back to GUILoginHomePage
*
*/

import javax.swing.*;
import java.awt.*;


public class GUICancelTicket extends JPanel {
    private JPanel panel;
    private JLabel ticketNo;
    private JLabel email;
    private JTextField ticketNoField;
    private JTextField emailField;
    private JButton back; // --> Back to home pageg 
    private JButton cancel; // --> Takes user input fields and attempts to verify it to cancel the ticket

    public GUICancelTicket() {
        panel = new JPanel();
        
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(50, 168, 137));
        GridBagConstraints gbc = new GridBagConstraints();


        email = new JLabel("Email: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,0,10,0);

        panel.add(email, gbc);

        emailField = new JTextField(30);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,0,10,0);
        panel.add(emailField, gbc);

        ticketNo = new JLabel("Ticket Number: ");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(10,0,10,0);
        panel.add(ticketNo, gbc);

        ticketNoField = new JTextField(30);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.insets = new Insets(10,0,10,0);
        panel.add(ticketNoField, gbc);

        back = new JButton("<--");
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(back, gbc);

        cancel = new JButton("Cancel Ticket");
        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(cancel, gbc);

    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getCancel() {
        return this.cancel;
    }

    public JButton getBack() {
        return this.back;
    }

    public String getEmailText() {
        return this.emailField.getText();
    }

    public String getTicketNoText() {
        return this.ticketNoField.getText();
    }

} 