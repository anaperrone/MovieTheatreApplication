/*
* GUIEndPage.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie

About this Class: 
    Final page of GUI, which thanks user for their payment and notifies them that their receipt has been sent to their email
    User can then click the "Back to Home Page" button to be redirected to the starting page
*
*/

package GUI;
import User.*;
import Movies.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.time.*;

public class GUIEndPage extends JPanel {
    private JPanel panel;
    private JLabel title;
    private JLabel subtitle;
    private JButton backToMovies; // --> Back to home page

    // private JLabel totalprice;
    // private JLabel movie;
    // private JLabel date;
    // private JLabel time;
    // private JLabel theatre;
    // private JLabel seatNumber;
    // private JLabel ticketNum;

    public GUIEndPage() {
        panel = new JPanel();

        //setting layout, background colour and constraints on grid
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(50, 168, 137));
        GridBagConstraints gbc = new GridBagConstraints();

        //creating label for main title
        title = new JLabel("Thank you for your purchase!");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        gbc.gridwidth = 7;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(title);

        //creating label for subtitle
        subtitle = new JLabel("Your receipt has been sent to your email");
        subtitle.setFont(new Font("Serif", Font.PLAIN, 15));
        gbc.gridwidth = 7;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(10,5,10,5);
        panel.add(subtitle);

        //creating back button
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

    // public void showTicketDetails() {

    // }

}
