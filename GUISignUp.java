import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUISignUp extends JPanel implements ActionListener {
    CardLayout maincl;
    JPanel mainPanel;
    private JPanel panel;
    private JLabel username; //this is email
    private JLabel password;
    private JLabel expiry;
    private JTextField usernameField;
    private JPasswordField passwordField;
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
