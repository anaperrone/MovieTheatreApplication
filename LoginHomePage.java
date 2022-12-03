import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginHomePage  extends JPanel implements ActionListener{
    private CardLayout maincl;
    private JPanel mainPanel;
    private JPanel panel;
    private JButton loginButton;
    private JButton guestButton;
    private JButton regButton;
    private JLabel text;

    public LoginHomePage(CardLayout cl, JPanel pan){
        maincl = cl;
        mainPanel = pan;
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(50, 168, 137));
        GridBagConstraints gbc = new GridBagConstraints();

        text = new JLabel("How would you like to proceed?");
        text.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(text);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,0,10,0);
        loginButton.setBackground(Color.PINK);
        loginButton.setOpaque(true);
        panel.add(loginButton, gbc);

        guestButton = new JButton("Continue as Guest");
        guestButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 4;
        guestButton.setBackground(Color.PINK);
        guestButton.setOpaque(true);
        panel.add(guestButton, gbc);

        regButton = new JButton("Register");
        regButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 6;
        regButton.setBackground(Color.PINK);
        regButton.setOpaque(true);
        panel.add(regButton, gbc);
    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
            maincl.show(mainPanel, "login");
           
        }

        if(e.getSource() == guestButton) {
<<<<<<< Updated upstream:LoginHomePage.java
            maincl.show(mainPanel, "login");
=======
            maincl.show(mainPanel, "movie");
>>>>>>> Stashed changes:GUILoginHomePage.java
        }

        if(e.getSource() == regButton) {
            maincl.show(mainPanel, "signup");
<<<<<<< Updated upstream:LoginHomePage.java
=======
           
>>>>>>> Stashed changes:GUILoginHomePage.java
        }
    }

    public JButton getloginButton() {
        return this.loginButton;
    }

    public JButton getGuestButton() {
        return this.guestButton;
    }

    public JButton getRegButton() {
        return this.regButton;
    }
}
