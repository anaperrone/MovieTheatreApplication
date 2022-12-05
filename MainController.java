import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.time.*;

public class MainController implements ActionListener {
    private MoviesController movieController;
    //private Payment payment;
    private RegisteredUser registeredUser;
    private DataBase database; 
    private GUI gui;
    Seats seats;
    private int flag = 0;
    private ArrayList<JButton> selectedButtons = new ArrayList<JButton>();
    private int selectedTicketNum = 0;

    public MainController() {
        database = new DataBase();
        seats = new Seats(database);
        registeredUser = new RegisteredUser(database);
        movieController = new MoviesController(database);

        gui = new GUI(movieController.getMovies(), movieController.getLocations());
       
        addListener();
    }


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

    }

    public void actionPerformed(ActionEvent e) {
        GUIloginHomePageButton(e);
        GUIloginPageButton(e);
        GUISignUpPageButton(e);
        GUITicketCancelButton(e);
        GUIMoviePageButton(e);
        GUISeatMapButton(e);
        GUISeatSelectionButton(e);
        GUIPaymentPageButton(e);
    
        //Add buttons for seats
        //Add seat array

    }

    public void GUIloginHomePageButton(ActionEvent e) {
        if(e.getSource() == gui.getGuiLoginHomePage().getloginButton()) {
            gui.maincl.show(gui.mainPanel, "login");
        }

        if(e.getSource() == gui.getGuiLoginHomePage().getRegButton()) {
            gui.maincl.show(gui.mainPanel, "signup");
        }

        if(e.getSource() == gui.getGuiLoginHomePage().getGuestButton()) {
            gui.maincl.show(gui.mainPanel, "movie");
        }

        if(e.getSource() == gui.getGuiLoginHomePage().getCancelButton()) {
            gui.maincl.show(gui.mainPanel, "cancelTicket");
        }
    }

    public void GUIloginPageButton(ActionEvent e) {
        if(e.getSource() == gui.getLogin().getEnter()) {
            String username = gui.getLogin().getUserText();
            String password = gui.getLogin().getPasswordText();
            
            if(registeredUser.grantAccess(username, password)) {
                gui.maincl.show(gui.mainPanel, "movie");
            }

            else {
                JOptionPane.showMessageDialog(gui.getLogin(), "Login Unsucessful! Try Again.");
            }
        }

        if(e.getSource() == gui.getLogin().getBack()) {
            gui.getLogin().clear();
            gui.maincl.show(gui.mainPanel, "home");

        }
    }

    public void GUISignUpPageButton(ActionEvent e) {
        if(e.getSource() == gui.getSignUp().getBack()) {
            gui.getSignUp().clear();
            gui.maincl.show(gui.mainPanel, "home");
        }

        if(e.getSource() == gui.getSignUp().getEnter()) {
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
            JOptionPane.showMessageDialog(gui.getSignUp(), set);

            gui.maincl.show(gui.mainPanel, "login");
        }
    }

    public void GUITicketCancelButton(ActionEvent e) {
        if(e.getSource() == gui.getTicketCancel().getBack()) {
            gui.maincl.show(gui.mainPanel, "home");
        }

        if(e.getSource() == gui.getTicketCancel().getCancel()) {
            String email = gui.getTicketCancel().getEmailText();
            Integer ticketNo = Integer.valueOf(gui.getTicketCancel().getTicketNoText());

            String message = seats.cancelSeat(ticketNo, email); 
            JOptionPane.showMessageDialog(gui.getTicketCancel().getPanel(), message);
            gui.maincl.show(gui.mainPanel, "home");
        }
    }
    
    public void GUIMoviePageButton(ActionEvent e) {
        if(e.getSource() == gui.getMoviePage().getBack()) {
            gui.getMoviePage().remove();
            gui.maincl.show(gui.mainPanel, "home");
        }
        
        // if(e.getSource() == gui.getMoviePage().getMovieBox()) {
        //     String movieSelected = gui.getMoviePage().getMovie();
        //     movieController.setMovie(movieSelected);
        // }

        // if(e.getSource() == gui.getMoviePage().getLocationBox()) {
        //     String locationSelected = gui.getMoviePage().getLocationSel();
        //     movieController.setLocation(locationSelected);
        // }

        // if(e.getSource() == gui.getMoviePage().getShowsBox()) {
        //     LocalDate dateSelected = gui.getMoviePage().getDatesSel();
        //     movieController.setDate(dateSelected);
        // }

        // if(e.getSource() == gui.getMoviePage().getTicketsBox()) {

        // }


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
            if(movieController.getTickets().contains(1)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat1());
                gui.getSeatSelection().getSeat1().setEnabled(false);
            }
            if(movieController.getTickets().contains(2)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat2());
                gui.getSeatSelection().getSeat2().setEnabled(false);
            }
            if(movieController.getTickets().contains(3)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat3());
                gui.getSeatSelection().getSeat3().setEnabled(false);
            }
            if(movieController.getTickets().contains(4)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat4());
                gui.getSeatSelection().getSeat4().setEnabled(false);
            }
            if(movieController.getTickets().contains(5)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat5());
                gui.getSeatSelection().getSeat5().setEnabled(false);
            }
            if(movieController.getTickets().contains(6)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat6());
                gui.getSeatSelection().getSeat6().setEnabled(false);
            }
            if(movieController.getTickets().contains(7)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat7());
                gui.getSeatSelection().getSeat7().setEnabled(false);
            }
            if(movieController.getTickets().contains(8)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat8());
                gui.getSeatSelection().getSeat8().setEnabled(false);
            }
            if(movieController.getTickets().contains(9)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat9());
                gui.getSeatSelection().getSeat9().setEnabled(false);
            }
            if(movieController.getTickets().contains(10)) {
                gui.getSeatSelection().changeColour(gui.getSeatMap().getSeat10());
                gui.getSeatSelection().getSeat10().setEnabled(false);
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
            
            //database tings
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
