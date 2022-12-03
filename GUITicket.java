import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUITicket extends JPanel implements ActionListener {
    CardLayout maincl;
    JPanel mainPanel;
    private JPanel panel;
    private JLabel title;

    public GUITicket(CardLayout cl, JPanel pan) {
        maincl = cl;
        mainPanel = pan;
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(50, 168, 137));
        GridBagConstraints gbc = new GridBagConstraints();

        title = new JLabel("Here Are Your Ticket Details: ");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(title);

        
    }

    public void actionPerformed(ActionEvent e) {
       
        
    }
}