import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUISeatSelection extends JPanel {
    private JPanel panel;
    private JButton back;
    private JButton next;
    private JLabel message;
    private JLabel errorMessage;
    private JButton seat1;
    private JButton seat2;
    private JButton seat3;
    private JButton seat4;
    private JButton seat5;
    private JButton seat6;
    private JButton seat7;
    private JButton seat8;
    private JButton seat9;
    private JButton seat10;
    GridBagConstraints gbc = new GridBagConstraints();

    public GUISeatSelection() {
        panel = new JPanel();

        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(50, 168, 137));

        message = new JLabel("Select Your Seats Below: ");
        gbc.gridwidth = 7;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(message, gbc);

        seat1 = new JButton("1");
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(seat1, gbc);

        seat2 = new JButton("2");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(seat2, gbc);

        seat3 = new JButton("3");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(seat3, gbc);

        seat4 = new JButton("4");
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(seat4, gbc);

        seat5 = new JButton("5");
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(seat5, gbc);

        seat6 = new JButton("6");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(seat6, gbc);

        seat7 = new JButton("7");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(seat7, gbc);

        seat8 = new JButton("8");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(seat8, gbc);

        seat9 = new JButton("9");
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(seat9, gbc);

        seat10 = new JButton("10");
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(seat10, gbc);

        back = new JButton("<--");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(back, gbc);

        next = new JButton("Next");
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(next, gbc);

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

    public JButton getSeat1() {
        return this.seat1;
    }

    public JButton getSeat2() {
        return this.seat2;
    }

    public JButton getSeat3() {
        return this.seat3;
    }

    public JButton getSeat4() {
        return this.seat4;
    }

    public JButton getSeat5() {
        return this.seat5;
    }

    public JButton getSeat6() {
        return this.seat6;
    }

    public JButton getSeat7() {
        return this.seat7;
    }

    public JButton getSeat8() {
        return this.seat8;
    }

    public JButton getSeat9() {
        return this.seat9;
    }

    public JButton getSeat10() {
        return this.seat10;
    }

    public void changeColour(JButton button) {
        button.setBackground(Color.PINK);
        button.setOpaque(true);
        panel.validate();
    }

    public void resetColour(JButton button) {
        button.setBackground(Color.GRAY);
        button.setOpaque(true);
        panel.validate();
    }

    public void displayErrorMsg() {
        message.setVisible(false);
        errorMessage = new JLabel("Oops! Looks like you didn't select enough seats!");
        errorMessage.setForeground(Color.PINK);
        gbc.gridwidth = 7;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(errorMessage, gbc);
        panel.validate();
    }
    
}