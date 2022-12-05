import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.time.*;

public class GUIEndPage extends JPanel {
    private JPanel panel;
    private JLabel title;
    private JLabel subtitle;
    private JButton backToMovies;

    public GUIEndPage() {
        panel = new JPanel();

        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(50, 168, 137));
        GridBagConstraints gbc = new GridBagConstraints();

        title = new JLabel("Thank you for your purchase!");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        gbc.gridwidth = 7;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(title);

        subtitle = new JLabel("A copy of your receipt has been sent to your email");
        subtitle.setFont(new Font("Serif", Font.PLAIN, 15));
        gbc.gridwidth = 7;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(subtitle);

        //display ticket details?

        backToMovies = new JButton("Back to Home Page");
        gbc.gridwidth = 7;
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(backToMovies, gbc);

    }

    public JPanel getPanel() {
        return this.panel;
    }

    public JButton getBackToMovies() {
        return this.backToMovies;
    }

    public void showTicketDetails() {
        
    }

}
