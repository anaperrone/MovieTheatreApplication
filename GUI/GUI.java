/*
* GUI.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*  

About this Class:
*    Driving controller of the GUI classes
*    Initializes all pages and retrieves them to pass to main controller which switches between them
*    Utilizes the CardLayout structure to switch between every page
*    Any JButton that is connected to any one of these pages will be activated and controlled through main controller
*    Utilizes the MVC pattern in which GUI displays the view which the user can interact with and the main controller and GUI work with ActionListener to munipulate the view and change it 
*/

package GUI;
import User.*;
import Movies.*;


import javax.swing.*;
import java.awt.*;
import java.util.*;


public class GUI {
    private JFrame frame;
    public JPanel mainPanel;
    private GUILoginHomePage loginPage;
    private GUILogin login;
    private GUIPaymentPage payPage;
    private GUISignUp signup;
    private GUIMovie moviePage;
    private GUISeatMap seatMap;
    private GUISeatSelection seatSelection;
    private GUICancelTicket ticketCancel;
    private GUIEndPage end;
    public CardLayout maincl = new CardLayout();

    public GUI(ArrayList<String> movies, ArrayList<String> locations) {
        frame = new JFrame("Cine-Ma-Ma");
        mainPanel = new JPanel();
        mainPanel.setLayout(maincl);

        loginPage = new GUILoginHomePage();
        login = new GUILogin();
        signup = new GUISignUp();
        ticketCancel = new GUICancelTicket();
        seatSelection = new GUISeatSelection();
        seatMap = new GUISeatMap();
        payPage = new GUIPaymentPage();
        moviePage = new GUIMovie(movies, locations);
        end = new GUIEndPage();

        mainPanel.add(loginPage.getPanel(), "home");
        mainPanel.add(login.getPanel(), "login");
        mainPanel.add(signup.getPanel(), "signup");
        mainPanel.add(ticketCancel.getPanel(), "cancelTicket");

        mainPanel.add(moviePage.getPanel(), "movie");
        mainPanel.add(seatMap.getPanel(), "seatMap");
        mainPanel.add(seatSelection.getPanel(), "seatSelection");

        mainPanel.add(payPage.getPanel(), "payment");

        mainPanel.add(end.getPanel(), "end");

        maincl.show(mainPanel, "home");


        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(700,600);
        frame.setVisible(true);

    }

    public void reloadGUIMovie(ArrayList<String> movies, ArrayList<String> locations) {
        mainPanel.remove(moviePage);
        moviePage = new GUIMovie(movies, locations);
        mainPanel.add(moviePage.getPanel(), "movie");
    }

    public GUILoginHomePage getGuiLoginHomePage() {
        return this.loginPage;
    }

    public GUILogin getLogin() {
        return this.login;
    }

    public GUISignUp getSignUp() {
        return this.signup;
    }

    public GUIMovie getMoviePage() {
        return this.moviePage;
    }

    public GUISeatMap getSeatMap() {
        return this.seatMap;
    }

    public GUISeatSelection getSeatSelection() {
        return this.seatSelection;
    }

    public GUIPaymentPage getPaymentPage() {
        return this.payPage;
    }

    public GUICancelTicket getTicketCancel() {
        return this.ticketCancel;
    }

    public GUIEndPage getEndPage() {
        return this.end;
    }
}
