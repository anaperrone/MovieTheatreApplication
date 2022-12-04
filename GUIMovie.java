import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class GUIMovie extends JFrame {
    private JPanel panel;
    JComboBox<String> movie;
    JComboBox<String> date;
    JComboBox<String> theatre;
    JComboBox<Integer> tickets;
    private JComboBox<String> show;
    String[] movies = {"Finding Nemo", "One Direction: This is Us", "Black Panther"};
    String[] dates = {"July 18", "March 4", "Dec 2"};
    String[] theatres = {"Signal Hill", "Chinook", "Rio"};
    String[] showTime = {"1:20", "4:30", "6:00", "9:15", "11:00"};
    Integer[] ticketNo = {1,2,3,4,5,6,7,8,9,10};
    private JButton back;
    private JButton seat;
    private JButton next;
    private JButton submit;
    GridBagConstraints gbc = new GridBagConstraints();

    public GUIMovie() {

        panel = new JPanel();
        
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(50, 168, 137));
    
        movie = new JComboBox<String>(movies);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,10,0);
        panel.add(movie, gbc);

        theatre = new JComboBox<String>(theatres);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,10,0);
        panel.add(theatre, gbc);

        back = new JButton("<--");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0,0,10,0);
        //back.addActionListener(this);
        panel.add(back, gbc);

        next = new JButton("Next");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(0,0,10,0);
        //back.addActionListener(this);
        panel.add(next, gbc);

        seat = new JButton("Show Seats");
        gbc.gridx = 8;
        gbc.gridy = 0;
        panel.add(seat, gbc);
        seat.setVisible(false);

        submit = new JButton("Submit");
        gbc.gridx = 10;
        gbc.gridy = 0;
        panel.add(submit, gbc);
        submit.setVisible(false);

    }

    public void showDate() {
        date = new JComboBox<String>(dates);
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,10,0);
        panel.add(date, gbc);
        panel.validate();
    }

    public void showShowTimes() {
        show = new JComboBox<String>(showTime);
        gbc.gridx = 6;
        gbc.gridy = 2;
        gbc.insets = new Insets(0,0,10,0);
        panel.add(show, gbc);

        tickets = new JComboBox<Integer>(ticketNo);
        gbc.gridx = 8;
        gbc.gridy = 2;
        gbc.insets = new Insets(0,0,10,0);
        panel.add(tickets, gbc);

        seat.setVisible(true);
        submit.setVisible(true);
        panel.validate();
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public JButton getBack() {
        return this.back;
    }

    public JButton getNext() {
        return this.next;
    }

    public JButton getSeat() {
        return this.seat;
    }
}