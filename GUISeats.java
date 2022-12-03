import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUISeats extends JPanel implements ActionListener{
    private JPanel mainPanel;
    private CardLayout maincl;
    private JPanel panel;
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

    public GUISeats(CardLayout cl, JPanel pan) {
        mainPanel = pan;
        maincl = cl;
        panel = new JPanel();

        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(50, 168, 137));
        GridBagConstraints gbc = new GridBagConstraints();

        seat1 = new JButton("1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,5,10,5);
        //enter.setBounds(160,80,80,25);
        seat1.addActionListener(this);
        panel.add(seat1, gbc);

        seat2 = new JButton("2");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,5,10,5);
        //enter.setBounds(160,80,80,25);
        seat2.addActionListener(this);
        panel.add(seat2, gbc);

        seat3 = new JButton("3");
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,5,10,5);
        //enter.setBounds(160,80,80,25);
        seat3.addActionListener(this);
        panel.add(seat3, gbc);

        seat4 = new JButton("4");
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,5,10,5);
        //enter.setBounds(160,80,80,25);
        seat4.addActionListener(this);
        panel.add(seat4, gbc);

        seat5 = new JButton("5");
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,5,10,5);
        //enter.setBounds(160,80,80,25);
        seat5.addActionListener(this);
        panel.add(seat5, gbc);

        seat6 = new JButton("6");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,5,10,5);
        //enter.setBounds(160,80,80,25);
        seat6.addActionListener(this);
        panel.add(seat6, gbc);

        seat7 = new JButton("7");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,5,10,5);
        //enter.setBounds(160,80,80,25);
        seat7.addActionListener(this);
        panel.add(seat7, gbc);

        seat8 = new JButton("8");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,5,10,5);
        //enter.setBounds(160,80,80,25);
        seat8.addActionListener(this);
        panel.add(seat8, gbc);

        seat9 = new JButton("9");
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,5,10,5);
        //enter.setBounds(160,80,80,25);
        seat9.addActionListener(this);
        panel.add(seat9, gbc);

        seat10 = new JButton("10");
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,5,10,5);
        //enter.setBounds(160,80,80,25);
        seat10.addActionListener(this);
        panel.add(seat10, gbc);
    }

    public void actionPerformed(ActionEvent e) {
        // if(e.getSource() == back) {
        //     maincl.show(mainPanel, "home");
        // }

        // if(e.getSource() == enter) {
           
        // }
    }

    public JPanel getPanel() {
        return this.panel;
    }
    
}