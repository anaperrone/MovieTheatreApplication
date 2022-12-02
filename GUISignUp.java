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
    private JTextField streetName;
    private JLabel number;
    private JTextField number;
    private JLabel city;
    private JTextField city;
    private JLabel country;
    private JTextField country;
    private JLabel postalCode;
    private JTextField postalcode;

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

    public JPanel getPanel() {
        return this.panel;
    }
}
