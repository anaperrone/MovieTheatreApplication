import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class GUIMovie extends JFrame implements ActionListener {
    CardLayout maincl;
    JPanel mainPanel;
    private JPanel panel;
    JComboBox<String> movie;
    JComboBox<String> date;
    JComboBox<String> theatre;
    String[] movies = {"Finding Nemo", "One Direction: This is Us", "Black Panther"};
    String[] dates = {"July 18", "March 4", "Dec 2"};
    String[] theatres = {"Signal Hill", "Chinook", "Rio"};
    private JButton back;

    public GUIMovie(CardLayout cl, JPanel pan) {
        mainPanel = pan;
        maincl = cl;
        panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        panel.setBackground(new Color(50, 168, 137));
        GridBagConstraints gbc = new GridBagConstraints();
        movie = new JComboBox<String>(movies);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,10,0);
        panel.add(movie, gbc);
        date = new JComboBox<String>(dates);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,10,0);
        panel.add(date, gbc);
        theatre = new JComboBox<String>(theatres);
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,10,0);
        panel.add(theatre, gbc);

        back = new JButton("<--");
        gbc.gridx = 0;
        gbc.gridy = 2;
        back.addActionListener(this);
        panel.add(back, gbc);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            maincl.show(mainPanel, "home");
        }

        // // if(e.getSource() == pay) {
        // //    maincl.show(mainPanel, "");
        // // }
    }

    public JPanel getPanel() {
        return this.panel;
    }
}