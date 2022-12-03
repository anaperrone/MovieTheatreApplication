import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUISignUp extends JPanel implements ActionListener {
    CardLayout maincl;
    JPanel mainPanel;
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



    public GUISignUp(CardLayout cl, JPanel pan) {
        mainPanel = pan;
        maincl = cl;

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
        back.addActionListener(this);
        panel.add(back, gbc);

        enter = new JButton("enter");
        gbc.gridx = 2;
        gbc.gridy = 28;
        back.addActionListener(this);
        panel.add(enter, gbc);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            maincl.show(mainPanel, "home");
        }

        if(e.getSource() == enter) {
           
        }
    }

    public JPanel getPanel() {
        return this.panel;
    }
}
