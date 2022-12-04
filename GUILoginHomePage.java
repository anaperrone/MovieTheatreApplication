import javax.swing.*;
import java.awt.*;

public class GUILoginHomePage extends JPanel {
    private JPanel panel;
    private JButton loginButton;
    private JButton guestButton;
    private JButton regButton;
    private JLabel text;

    public GUILoginHomePage(){
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(50, 168, 137));
        GridBagConstraints gbc = new GridBagConstraints();

        text = new JLabel("How would you like to proceed?");
        text.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(text);

        loginButton = new JButton("Login");
        //loginButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,0,10,0);
        loginButton.setBackground(Color.PINK);
        loginButton.setOpaque(true);
        panel.add(loginButton, gbc);

        guestButton = new JButton("Continue as Guest");
        //guestButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 4;
        guestButton.setBackground(Color.PINK);
        guestButton.setOpaque(true);
        panel.add(guestButton, gbc);

        regButton = new JButton("Register");
        //regButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 6;
        regButton.setBackground(Color.PINK);
        regButton.setOpaque(true);
        panel.add(regButton, gbc);
    }

    public JPanel getPanel() {
        return panel;
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
