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
        
        panel.setLayout(null);
        panel.setBackground(new Color(50, 168, 137));

        username = new JLabel("Username: ");
        username.setBounds(10,20,80,25);
        panel.add(username);

        usernameField = new JTextField(30);
        usernameField.setBounds(100,20,165,25);
        panel.add(usernameField);

        password = new JLabel("Password");
        password.setBounds(10,50,80,25);
        panel.add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(100,50,165,25);
        panel.add(passwordField);

        back = new JButton("<--");
        back.setBounds(50,80,80,25);
        back.addActionListener(this);
        panel.add(back);

        enter = new JButton("Enter");
        enter.setBounds(160,80,80,25);
        enter.addActionListener(this);
        panel.add(enter);


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
