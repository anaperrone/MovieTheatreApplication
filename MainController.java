/*
* MainController.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie

About this class:
    This is the driving class that initializes and connects the entire program together
    Main controller serves as both the model and controller part of the MVC pattern
    The GUI creates buttons and fields which are then recognized by main controller by action listener
    When a certain button is pressed within any panel main controller will act on it by executing a certain command that is specific to that button
*
*/

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.time.*;



public class MainController implements ActionListener {
    private MoviesController movieController;
    private Payment payment;
    private RegisteredUser registeredUser;
    private DataBase database; 
    private GUI gui;
    Seats seats;
    private int flag = 0;
    private ArrayList<JButton> selectedButtons = new ArrayList<JButton>();
    private int selectedTicketNum = 0;

    public MainController() {
        database = new DataBase(); //Open the database and pass it to other functions so that they can retrieve information
        seats = new Seats(database); //
        registeredUser = new RegisteredUser(database);
        movieController = new MoviesController(database);

        gui = new GUI(movieController.getMovies(), movieController.getLocations()); //Open the GUI for the user to use
       
        addListener(); //Add all the action listeners for every button used in the GUI
    }

    //Function adds all the listener for every button
    public void addListener() {
        gui.getGuiLoginHomePage().getloginButton().addActionListener(this);
        gui.getGuiLoginHomePage().getGuestButton().addActionListener(this);
        gui.getGuiLoginHomePage().getRegButton().addActionListener(this);
        gui.getGuiLoginHomePage().getCancelButton().addActionListener(this);

        gui.getLogin().getEnter().addActionListener(this);
        gui.getLogin().getBack().addActionListener(this);

        gui.getTicketCancel().getBack().addActionListener(this);
        gui.getTicketCancel().getCancel().addActionListener(this);

        gui.getPaymentPage().getBack().addActionListener(this);
        gui.getPaymentPage().getPay().addActionListener(this);

        gui.getSeatMap().getBack().addActionListener(this);

        gui.getSeatSelection().getBack().addActionListener(this);
        gui.getSeatSelection().getNext().addActionListener(this);
        gui.getSeatSelection().getSeat1().addActionListener(this);
        gui.getSeatSelection().getSeat2().addActionListener(this);
        gui.getSeatSelection().getSeat3().addActionListener(this);
        gui.getSeatSelection().getSeat4().addActionListener(this);
        gui.getSeatSelection().getSeat5().addActionListener(this);
        gui.getSeatSelection().getSeat6().addActionListener(this);
        gui.getSeatSelection().getSeat7().addActionListener(this);
        gui.getSeatSelection().getSeat8().addActionListener(this);
        gui.getSeatSelection().getSeat9().addActionListener(this);
        gui.getSeatSelection().getSeat10().addActionListener(this);

        gui.getSignUp().getEnter().addActionListener(this);
        gui.getSignUp().getBack().addActionListener(this);

        gui.getMoviePage().getBack().addActionListener(this);
        gui.getMoviePage().getNext().addActionListener(this);
        gui.getMoviePage().getSeat().addActionListener(this);
        gui.getMoviePage().getSubmit().addActionListener(this);
        
        gui.getMoviePage().getMovieBox().addActionListener(this);
        gui.getMoviePage().getLocationBox().addActionListener(this);
        gui.getMoviePage().getDateBox().addActionListener(this);
        gui.getMoviePage().getShowsBox().addActionListener(this);
        gui.getMoviePage().getTicketsBox().addActionListener(this);

        gui.getEndPage().getBackToMovies().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) { 
        //When an action event is triggered it checks all the buttons within the program to see if it matches the action event
        GUIloginHomePageButton(e);
        GUIloginPageButton(e);
        GUISignUpPageButton(e);
        GUITicketCancelButton(e);
        GUIMoviePageButton(e);
        GUISeatMapButton(e);
        GUISeatSelectionButton(e);
        GUIPaymentPageButton(e);
        GUIEndButton(e);
    }

    public void GUIloginHomePageButton(ActionEvent e) {
        //Moves from the homepage to any of the other login type pages 
        //Depending on what button you press you move to that login type page
        if(e.getSource() == gui.getGuiLoginHomePage().getloginButton()) {
            gui.maincl.show(gui.mainPanel, "login");
        }

        if(e.getSource() == gui.getGuiLoginHomePage().getRegButton()) {
            gui.maincl.show(gui.mainPanel, "signup");
            JOptionPane.showMessageDialog(gui.getSignUp(), "Remember your username must be in the format of an email or you will recieve no ticket confirmation.");
        }

        if(e.getSource() == gui.getGuiLoginHomePage().getGuestButton()) {
            gui.maincl.show(gui.mainPanel, "movie");
        }

        if(e.getSource() == gui.getGuiLoginHomePage().getCancelButton()) {
            gui.maincl.show(gui.mainPanel, "cancelTicket");
        }
    }

    public void GUIloginPageButton(ActionEvent e) {

        if(e.getSource() == gui.getLogin().getEnter()) { //When a login username and password is submitted registered user check is called
            String username = gui.getLogin().getUserText();
            String password = gui.getLogin().getPasswordText();
            
            if(registeredUser.grantAccess(username, password)) { //Calls registered user to check login server to validate login
                gui.maincl.show(gui.mainPanel, "movie"); //Goes to movie page if validated
            }

            else { //If the login is not validated it prompts for the try again
                JOptionPane.showMessageDialog(gui.getLogin(), "Login Unsucessful! Try Again.");
            }
        }

        if(e.getSource() == gui.getLogin().getBack()) {
            gui.getLogin().clear(); //Clears any saved login and goes to home page if you press back button
            gui.maincl.show(gui.mainPanel, "home");

        }
    }

    public void GUISignUpPageButton(ActionEvent e) {
        if(e.getSource() == gui.getSignUp().getBack()) { //Clears any signup details placed if the user decided to backtrack to homepage
            gui.getSignUp().clear(); 
            gui.maincl.show(gui.mainPanel, "home");
        }

        if(e.getSource() == gui.getSignUp().getEnter()) { //When user signs up it gets all the fields it places
            String username = gui.getSignUp().getUserText();
            String password = gui.getSignUp().getPasswordText();
            Integer no = Integer.valueOf(gui.getSignUp().getNumberField());
            String street = gui.getSignUp().getStreetNameField();
            String city = gui.getSignUp().getCityField();
            String country = gui.getSignUp().getCountryField();
            String postalcode = gui.getSignUp().getPostalcodeField();
            String name = gui.getSignUp().getNameText();
            String card = gui.getSignUp().getCardText();
            String expiry = gui.getSignUp().getExpiryText();
            Integer cvv = Integer.valueOf(gui.getSignUp().getCVVText());

            String set = registeredUser.setAll(username, password, expiry, card, cvv, name, street, no, city, country, postalcode);
            //Calls to registered user which validates and checks every single field 
            //The database will send a message through registered user and that will show user if there are any errors
            JOptionPane.showMessageDialog(gui.getSignUp(), set);

            if(!set.contains("ERROR")) { //If there are no errors then login server will approve login and then move onto a login page
                gui.maincl.show(gui.mainPanel, "login");
            }
        }
    }

    public void GUITicketCancelButton(ActionEvent e) { 
        if(e.getSource() == gui.getTicketCancel().getBack()) {
            gui.maincl.show(gui.mainPanel, "home");
        }

        if(e.getSource() == gui.getTicketCancel().getCancel()) { //When user selects ticket to be cancelled it gets the fields the user has inputted and then checks them
            String email = gui.getTicketCancel().getEmailText(); 
            Integer ticketNo = Integer.valueOf(gui.getTicketCancel().getTicketNoText());

            String message = seats.cancelSeat(ticketNo, email); //Recieves a message from seats that is connected to database
            //Will print a sucessessful or unsuccessful message and take the user to home 
            JOptionPane.showMessageDialog(gui.getTicketCancel().getPanel(), message);
            gui.maincl.show(gui.mainPanel, "home");
        }
    }
    
    public void GUIMoviePageButton(ActionEvent e) {
        if(e.getSource() == gui.getMoviePage().getBack()) {
            gui.getMoviePage().remove();
            flag = 0;
            gui.reloadGUIMovie(movieController.getMovies(), movieController.getLocations());
            addListener();
            gui.maincl.show(gui.mainPanel, "home");
        }
        
        if(e.getSource() == gui.getMoviePage().getNext()) {
            if(flag == 0) {
                String movieSelected = gui.getMoviePage().getMovie();
                String locationSelected = gui.getMoviePage().getLocationSel();
                movieController.setMovieLocation(movieSelected, locationSelected);
                gui.getMoviePage().showDate(movieController.getDateS());
                flag++;
            }

            else if(flag == 1) {
                LocalDate dateSelected = gui.getMoviePage().getDatesSel();
                movieController.setDate(dateSelected);
                gui.getMoviePage().showShowTimes(movieController.getShowTimes());
                flag++;
            }

            else if(flag == 2) {
                LocalTime timeSelected = gui.getMoviePage().getShowtimes();
                movieController.setShow(timeSelected);
                gui.getMoviePage().showTicketsAv(movieController.getTickets());
                flag++;

            }

            else if(flag == 3) {
                int ticketSelected = gui.getMoviePage().getTickets();
                System.out.println(ticketSelected);
                selectedTicketNum = ticketSelected;
                flag = 0;
            }
            
        }

        if(e.getSource() == gui.getMoviePage().getSeat()) {
            gui.getSeatMap().getSeat1().setEnabled(false);
            gui.getSeatMap().getSeat2().setEnabled(false);
            gui.getSeatMap().getSeat3().setEnabled(false);
            gui.getSeatMap().getSeat4().setEnabled(false);
            gui.getSeatMap().getSeat5().setEnabled(false);
            gui.getSeatMap().getSeat6().setEnabled(false);
            gui.getSeatMap().getSeat7().setEnabled(false);
            gui.getSeatMap().getSeat8().setEnabled(false);
            gui.getSeatMap().getSeat9().setEnabled(false);
            gui.getSeatMap().getSeat10().setEnabled(false);

            if(movieController.getTickets().contains(1)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat1());
            }
            if(movieController.getTickets().contains(2)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat2());
            }
            if(movieController.getTickets().contains(3)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat3());
            }
            if(movieController.getTickets().contains(4)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat4());
            }
            if(movieController.getTickets().contains(5)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat5());
            }
            if(movieController.getTickets().contains(6)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat6());
            }
            if(movieController.getTickets().contains(7)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat7());
            }
            if(movieController.getTickets().contains(8)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat8());
            }
            if(movieController.getTickets().contains(9)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat9());
            }
            if(movieController.getTickets().contains(10)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat10());
            }
            gui.maincl.show(gui.mainPanel, "seatMap");
        }

        if(e.getSource() == gui.getMoviePage().getSubmit()) {
            int ticketSelected = gui.getMoviePage().getTickets();
            selectedTicketNum = ticketSelected;
            flag = 0;
            if(movieController.getTickets().contains(1)) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat1());
                gui.getSeatSelection().getSeat1().setEnabled(false);
            }
            if(movieController.getTickets().contains(2)) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat2());
                gui.getSeatSelection().getSeat2().setEnabled(false);
            }
            if(movieController.getTickets().contains(3)) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat3());
                gui.getSeatSelection().getSeat3().setEnabled(false);
            }
            if(movieController.getTickets().contains(4)) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat4());
                gui.getSeatSelection().getSeat4().setEnabled(false);
            }
            if(movieController.getTickets().contains(5)) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat5());
                gui.getSeatSelection().getSeat5().setEnabled(false);
            }
            if(movieController.getTickets().contains(6)) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat6());
                gui.getSeatSelection().getSeat6().setEnabled(false);
            }
            if(movieController.getTickets().contains(7)) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat7());
                gui.getSeatSelection().getSeat7().setEnabled(false);
            }
            if(movieController.getTickets().contains(8)) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat8());
                gui.getSeatSelection().getSeat8().setEnabled(false);
            }
            if(movieController.getTickets().contains(9)) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat9());
                gui.getSeatSelection().getSeat9().setEnabled(false);
            }
            if(movieController.getTickets().contains(10)) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat10());
                gui.getSeatSelection().getSeat10().setEnabled(false);
            }
            gui.maincl.show(gui.mainPanel, "seatSelection");
        }
        
    }

    public void GUISeatMapButton(ActionEvent e) {
        if(e.getSource() == gui.getSeatMap().getBack()) {
            gui.maincl.show(gui.mainPanel, "movie");
        }
    }

    public void GUISeatSelectionButton(ActionEvent e) {
        if(e.getSource() == gui.getSeatSelection().getBack()) {
            gui.maincl.show(gui.mainPanel, "movie");
        }

        if(e.getSource() == gui.getSeatSelection().getSeat1()) {
            if(flag == 0) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat1());
                selectedButtons.add(gui.getSeatSelection().getSeat1());
                flag++;
            } else {
                gui.getSeatSelection().resetColour(gui.getSeatSelection().getSeat1());
                selectedButtons.remove(gui.getSeatSelection().getSeat1());
                flag = 0;
            }
        }

        if(e.getSource() == gui.getSeatSelection().getSeat2()) {
            if(flag == 0) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat2());
                selectedButtons.add(gui.getSeatSelection().getSeat2());
                flag++;
            } else {
                gui.getSeatSelection().resetColour(gui.getSeatSelection().getSeat2());
                selectedButtons.remove(gui.getSeatSelection().getSeat2());
                flag = 0;
            }
        }

        if(e.getSource() == gui.getSeatSelection().getSeat3()) {
            if(flag == 0) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat3());
                selectedButtons.add(gui.getSeatSelection().getSeat3());
                flag++;
            } else {
                gui.getSeatSelection().resetColour(gui.getSeatSelection().getSeat3());
                selectedButtons.remove(gui.getSeatSelection().getSeat3());
                flag = 0;
            }
        }

        if(e.getSource() == gui.getSeatSelection().getSeat4()) {
            if(flag == 0) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat4());
                selectedButtons.add(gui.getSeatSelection().getSeat4());
                flag++;
            } else {
                gui.getSeatSelection().resetColour(gui.getSeatSelection().getSeat4());
                selectedButtons.remove(gui.getSeatSelection().getSeat4());
                flag = 0;
            }
        }

        if(e.getSource() == gui.getSeatSelection().getSeat5()) {
            if(flag == 0) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat5());
                selectedButtons.add(gui.getSeatSelection().getSeat5());
                flag++;
            } else {
                gui.getSeatSelection().resetColour(gui.getSeatSelection().getSeat5());
                selectedButtons.remove(gui.getSeatSelection().getSeat5());
                flag = 0;
            }
        }

        if(e.getSource() == gui.getSeatSelection().getSeat6()) {
            if(flag == 0) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat6());
                selectedButtons.add(gui.getSeatSelection().getSeat6());
                flag++;
            } else {
                gui.getSeatSelection().resetColour(gui.getSeatSelection().getSeat6());
                selectedButtons.remove(gui.getSeatSelection().getSeat6());
                flag = 0;
            }
        }

        if(e.getSource() == gui.getSeatSelection().getSeat7()) {
            if(flag == 0) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat7());
                selectedButtons.add(gui.getSeatSelection().getSeat7());
                flag++;
            } else {
                gui.getSeatSelection().resetColour(gui.getSeatSelection().getSeat7());
                selectedButtons.remove(gui.getSeatSelection().getSeat7());
                flag = 0;
            }
        }

        if(e.getSource() == gui.getSeatSelection().getSeat8()) {
            if(flag == 0) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat8());
                selectedButtons.add(gui.getSeatSelection().getSeat8());
                flag++;
            } else {
                gui.getSeatSelection().resetColour(gui.getSeatSelection().getSeat8());
                selectedButtons.remove(gui.getSeatSelection().getSeat8());
                flag = 0;
            }
        }

        if(e.getSource() == gui.getSeatSelection().getSeat9()) {
            if(flag == 0) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat9());
                selectedButtons.add(gui.getSeatSelection().getSeat9());
                flag++;
            } else {
                gui.getSeatSelection().resetColour(gui.getSeatSelection().getSeat9());
                selectedButtons.remove(gui.getSeatSelection().getSeat9());
                flag = 0;
            }
        }

        if(e.getSource() == gui.getSeatSelection().getSeat10()) {
            if(flag == 0) {
                gui.getSeatSelection().changeColour(gui.getSeatSelection().getSeat10());
                selectedButtons.add(gui.getSeatSelection().getSeat10());
                flag++;
            } else {
                gui.getSeatSelection().resetColour(gui.getSeatSelection().getSeat10());
                selectedButtons.remove(gui.getSeatSelection().getSeat10());
                flag = 0;
            }
        }

        if(e.getSource() == gui.getSeatSelection().getNext()) {
            if(selectedButtons.size() == selectedTicketNum) {
                if(registeredUser != null) {
                    String email = gui.getPaymentPage().getEmailText();
                    String name = gui.getPaymentPage().getNameText();
                    String card = gui.getPaymentPage().getCardText();
                    gui.getPaymentPage().setTexts(email, name, card);
                }
                gui.maincl.show(gui.mainPanel, "payment");
            } else {
                gui.getSeatSelection().displayErrorMsg();
            }
        }
    }

    public void GUIPaymentPageButton(ActionEvent e) {
        if(e.getSource() == gui.getPaymentPage().getBack()) {
            gui.maincl.show(gui.mainPanel, "seatSelection");
        }

        if(e.getSource() == gui.getPaymentPage().getPay()) {
            String email = gui.getPaymentPage().getEmailText();
            String name = gui.getPaymentPage().getNameText();
            String card = gui.getPaymentPage().getCardText();
            String expiry = gui.getPaymentPage().getExpiryText();
            String cvv = gui.getPaymentPage().getCVVText();
            
            //

            gui.maincl.show(gui.mainPanel, "end");
        }
    }

    public void GUIEndButton(ActionEvent e) {
        if(e.getSource() == gui.getEndPage().getBackToMovies()) {
            gui.maincl.show(gui.mainPanel, "home");
        }
    }
    
    
    public static void main(String[] args){        
        MainController main = new MainController();
        
        // SwingUtilities.invokeLater(new Runnable() {
        //     @Override
        //     public void run() {
        //         MainController
        //     }
        // });

    }
}
