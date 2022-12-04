import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class GUIMovie extends JFrame {
    private JPanel panel;
    JComboBox<String> movie;
    JComboBox<String> date;
    JComboBox<String> theatre;
    String[] movies = {"Finding Nemo", "One Direction: This is Us", "Black Panther"};
    String[] dates = {"July 18", "March 4", "Dec 2"};
    String[] theatres = {"Signal Hill", "Chinook", "Rio"};
    private JButton back;
    private JButton seat;

    public GUIMovie() {

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
        //back.addActionListener(this);
        panel.add(back, gbc);

        seat = new JButton("Show Seats");
        gbc.gridx = 1;
        gbc.gridy = 2;
        //seat.addActionListener(this);
        panel.add(seat, gbc);

    }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     if(e.getSource() == back) {
    //         maincl.show(mainPanel, "home");
    //     }

    //     if(e.getSource() == seat) {
    //        maincl.show(mainPanel, "seats");
    //     }
    // }

    public JPanel getPanel() {
        return this.panel;
    }
}