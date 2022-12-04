import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUITicket extends JPanel {
    private JPanel panel;
    private JLabel title;

    public GUITicket() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(50, 168, 137));
        GridBagConstraints gbc = new GridBagConstraints();

        title = new JLabel("Here Are Your Ticket Details: ");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(title);
    }

    public JPanel getPanel() {
        return this.panel;
    }
}