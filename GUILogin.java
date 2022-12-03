import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUILogin extends JPanel implements ActionListener {
    CardLayout maincl;
    JPanel mainPanel;
    private JPanel panel;
    private JLabel username;
    private JLabel password;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton back;
    private JButton enter;

    public GUILogin(CardLayout cl, JPanel pan) {
        maincl = cl;
        mainPanel = pan;
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

        back = new JButton("<--");
<<<<<<< Updated upstream
        gbc.gridx = 2;
=======
        gbc.gridx = 1;
>>>>>>> Stashed changes
        gbc.gridy = 8;
        gbc.insets = new Insets(10,5,10,5);
        //back.setBounds(50,80,80,25);
        back.addActionListener(this);
        panel.add(back, gbc);

        enter = new JButton("Enter");
        gbc.gridx = 2;
<<<<<<< Updated upstream
        gbc.gridy = 11;
=======
        gbc.gridy = 8;
>>>>>>> Stashed changes
        gbc.insets = new Insets(10,5,10,5);
        //enter.setBounds(160,80,80,25);
        enter.addActionListener(this);
        panel.add(enter, gbc);


        panel.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            maincl.show(mainPanel, "home");
        }

        if(e.getSource() == enter) {
           
        }
    }

    public JPanel getPanel() {
        return panel;
    }

}
