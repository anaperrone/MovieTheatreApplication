/*
* GUILogin.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie

About this class:
    Allows the user to input their username and password and login into their account
    If the user decides to go back to home page their last login information will be cleared
*/

package GUI;
import User.*;
import Movies.*;

import javax.swing.*;
import java.awt.*;

public class GUILogin extends JPanel {
    private JPanel panel;
    private JLabel username;
    private JLabel password;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton back; // --> Back to home page
    private JButton enter; // --> Takes login and attempts to verify it

    public GUILogin() {
        panel = new JPanel();
        
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(50, 168, 137));
        GridBagConstraints gbc = new GridBagConstraints();


        username = new JLabel("Username: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,0,10,0);

        panel.add(username, gbc);

        usernameField = new JTextField(30);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,0,10,0);
        panel.add(usernameField, gbc);

        password = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(10,0,10,0);
        panel.add(password, gbc);

        passwordField = new JPasswordField(30);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.insets = new Insets(10,0,10,0);
        panel.add(passwordField, gbc);

        back = new JButton("<--");
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(back, gbc);

        enter = new JButton("Enter");
        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(enter, gbc);
        
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getEnter() {
        return this.enter;
    }

    public JButton getBack() {
        return this.back;
    }

    public String getUserText() {
        return this.usernameField.getText();
    }

    public String getPasswordText() {
        return String.valueOf(passwordField.getPassword());
    }

    public void clear() { //Clears jtextfield
        usernameField.setText("");
        passwordField.setText("");
    }

}
