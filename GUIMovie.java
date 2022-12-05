import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.time.*;
public class GUIMovie extends JFrame {
    private JPanel panel;
    private JLabel label;

    JComboBox<String> movie;
    JComboBox<LocalDate> date;
    JComboBox<String> theatre;
    JComboBox<Integer> tickets;
    private JComboBox<String> show;
    String[] nullvalues = new String[3];
    Integer[] nullvalues2 = new Integer[3];
    LocalDate[]nullvalues3 = new LocalDate[3];
    String[] showTime = {"1:20", "4:30", "6:00", "9:15", "11:00"};
    private JButton back;
    private JButton seat;
    private JButton next;
    private JButton submit;
    GridBagConstraints gbc = new GridBagConstraints();

    public GUIMovie(ArrayList<String> movies, ArrayList<String> locations) {

        panel = new JPanel();
        
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(50, 168, 137));
        //gbc.insets = new Insets(0,0,10,0);

        label = new JLabel("Press 'Next' to get other valid data.");
        //gbc.fill = GridBagConstraints.HORIZONTAL; 
        gbc.gridwidth = 7;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);

        String[] moviesList = movies.toArray(new String[movies.size()]);
        movie = new JComboBox<String>(moviesList);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(movie, gbc);

        String[] locationsList = locations.toArray(new String[locations.size()]);
        theatre = new JComboBox<String>(locationsList);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(theatre, gbc);

        date = new JComboBox<LocalDate>(nullvalues3);
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(date, gbc);

        show = new JComboBox<String>(nullvalues);
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(show, gbc);

        tickets = new JComboBox<Integer>(nullvalues2);
        gbc.gridx = 4;
        gbc.gridy = 2;
        panel.add(tickets, gbc);

        back = new JButton("<--");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(back, gbc);

        next = new JButton("Next");
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(next, gbc);

        seat = new JButton("Show Seats");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(seat, gbc);
        seat.setVisible(false);


        submit = new JButton("Submit");
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(submit, gbc);
        submit.setVisible(false);

    }

    public void showDate(ArrayList<LocalDate> dates) {
        panel.remove(date);
        LocalDate[] localdates = dates.toArray(new LocalDate[dates.size()]);
        date = new JComboBox<LocalDate>(localdates);
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(date, gbc);
        date.setVisible(true);
        panel.validate();
    }

    public void showShowTimes() {
        panel.remove(show);
        show = new JComboBox<String>(nullvalues);
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(show, gbc);
        panel.validate();
    }

    public void showTickets() {
        panel.remove(tickets);
        tickets = new JComboBox<Integer>(nullvalues2);
        gbc.gridx = 4;
        gbc.gridy = 2;
        panel.add(tickets, gbc);

        seat.setVisible(true);
        next.setVisible(false);
        next.setEnabled(false);
        tickets.setVisible(true);
        submit.setVisible(true);
        submit.setEnabled(true);
        panel.validate();
    }

    public void remove() {
        seat.setVisible(false);
        submit.setVisible(false);
        submit.setEnabled(false);
        next.setVisible(true);
        next.setEnabled(true);
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

    public JButton getSubmit() {
        return this.submit;
    }

    public String getMovie() {
        return (String)movie.getSelectedItem();
    }

    public String getLocationSel() {
        return (String)theatre.getSelectedItem();
    }

    public String getDatesSel() {
        return (String) date.getSelectedItem();
    }

    public String getShowtimes() {
        return (String) show.getSelectedItem();
    }

    public String getTickets() {
        return (String) tickets.getSelectedItem();
    }
}