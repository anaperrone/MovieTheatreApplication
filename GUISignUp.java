import javax.swing.*;
import java.awt.*;

public class GUISignUp extends JPanel {
    private JPanel panel;
    private JLabel username; //this is email
    private JTextField usernameField;
    private JLabel password; 
    private JPasswordField passwordField;
    
    private JLabel streetName;
    private JTextField streetNameField;
    private JLabel number;
    private JTextField numberField;
    private JLabel city;
    private JTextField cityField;
    private JLabel country;
    private JTextField countryField;
    private JLabel postalCode;
    private JTextField postalcodeField;

    private JLabel name;
    private JTextField nameField;
    private JLabel CC;
    private JTextField CCField;
    private JLabel expiry;
    private JTextField expiryField;
    private JLabel CVV;
    private JTextField CVVField;
    private JButton back;
    private JButton enter;



    public GUISignUp() {
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
        //usernameField.setBounds(100,20,165,25);
        panel.add(usernameField, gbc);

        password = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(10,0,10,0);
        //password.setBounds(10,50,80,25);
        panel.add(password, gbc);

        passwordField = new JPasswordField(30);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.insets = new Insets(10,0,10,0);
        //passwordField.setBounds(100,50,165,25);
        panel.add(passwordField, gbc);

        number = new JLabel("Street No: ");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(10,0,10,0);
        panel.add(number, gbc);

        numberField = new JTextField(30);
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.insets = new Insets(10,0,10,0);
        //usernameField.setBounds(100,20,165,25);
        panel.add(numberField, gbc);

        streetName = new JLabel("Street: ");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.insets = new Insets(10,0,10,0);

        panel.add(streetName, gbc);

        streetNameField = new JTextField(30);
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.insets = new Insets(10,0,10,0);
        //usernameField.setBounds(100,20,165,25);
        panel.add(streetNameField, gbc);

        
        city = new JLabel("City: ");
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.insets = new Insets(10,0,10,0);

        panel.add(city, gbc);

        cityField = new JTextField(30);
        gbc.gridx = 2;
        gbc.gridy = 12;
        gbc.insets = new Insets(10,0,10,0);
        //usernameField.setBounds(100,20,165,25);
        panel.add(cityField, gbc);


        country = new JLabel("Country: ");
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.insets = new Insets(10,0,10,0);

        panel.add(country, gbc);

        countryField = new JTextField(30);
        gbc.gridx = 2;
        gbc.gridy = 14;
        gbc.insets = new Insets(10,0,10,0);
        //usernameField.setBounds(100,20,165,25);
        panel.add(countryField, gbc);

        postalCode = new JLabel("Postal Code: ");
        gbc.gridx = 0;
        gbc.gridy = 16;
        gbc.insets = new Insets(10,0,10,0);

        panel.add(postalCode, gbc);

        postalcodeField = new JTextField(30);
        gbc.gridx = 2;
        gbc.gridy = 16;
        gbc.insets = new Insets(10,0,10,0);
        //usernameField.setBounds(100,20,165,25);
        panel.add(postalcodeField, gbc);

        name = new JLabel("Enter Card Holder Name: ");
        gbc.gridx = 0;
        gbc.gridy = 18;
        gbc.insets = new Insets(10,0,10,0);
        panel.add(name, gbc);

        nameField = new JTextField(30);
        gbc.gridx = 2;
        gbc.gridy = 18;
        panel.add(nameField, gbc);

        CC = new JLabel("Enter Card Number: ");
        gbc.gridx = 0;
        gbc.gridy = 20;
        panel.add(CC, gbc);

        CCField = new JTextField(30);
        gbc.gridx = 2;
        gbc.gridy = 20;
        panel.add(CCField, gbc);

        expiry = new JLabel("Enter Expiry Date: ");
        gbc.gridx = 0;
        gbc.gridy = 22;
        panel.add(expiry, gbc);

        expiryField = new JTextField(30);
        gbc.gridx = 2;
        gbc.gridy = 22;
        panel.add(expiryField, gbc);

        CVV = new JLabel("Enter CVV: ");
        gbc.gridx = 0;
        gbc.gridy = 24;
        panel.add(CVV, gbc);

        CVVField = new JTextField(30);
        gbc.gridx = 2;
        gbc.gridy = 24;
        panel.add(CVVField, gbc);

        back = new JButton("<--");
        gbc.gridx = 0;
        gbc.gridy = 28;
        //back.addActionListener(this);
        panel.add(back, gbc);

        enter = new JButton("enter");
        gbc.gridx = 2;
        gbc.gridy = 28;
        //back.addActionListener(this);
        panel.add(enter, gbc);

    }

    public JPanel getPanel() {
        return this.panel;
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

    public String getStreetNameField() {
        return this.streetNameField.getText();
    }

    public String getNumberField() {
        return this.numberField.getText();
    }

    public String getCityField() {
        return this.cityField.getText();
    }

    public String getPostalcodeField() {
        return this.postalcodeField.getText();
    }

    public String getCountryField() {
        return this.countryField.getText();
    }

    public void clear() {
        usernameField.setText("");
        passwordField.setText("");
        streetNameField.setText("");
        numberField.setText("");
        cityField.setText("");
        countryField.setText("");
        postalcodeField.setText("");
        nameField.setText("");
        CCField.setText("");
        expiryField.setText("");
        CVVField.setText("");
    }

}
