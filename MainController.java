import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainController implements ActionListener {
    //private MoviesController movieController;
    //private Payment payment;
    //private OrdinaryUser ordinaryUser;
    //private DataBase database; 
    private GUI gui;
    private int flag = 0;

    public MainController() {
        gui = new GUI();
        //database = new DataBase();
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
            
            // if(database.grantAccess(username, password)) {
            //     System.out.println("HI");
            //     gui.maincl.show(gui.mainPanel, "movie");
            // }
        }

        if(e.getSource() == gui.getLogin().getBack()) {
            gui.maincl.show(gui.mainPanel, "home");

        }
    }

    public void GUISignUpPageButton(ActionEvent e) {
        if(e.getSource() == gui.getSignUp().getBack()) {
            gui.maincl.show(gui.mainPanel, "home");
        }

        if(e.getSource() == gui.getSignUp().getEnter()) {
            String username = gui.getSignUp().getUserText();
            String password = gui.getSignUp().getPasswordText();


            gui.maincl.show(gui.mainPanel, "login");
        }
    }

    public void GUITicketCancelButton(ActionEvent e) {
        if(e.getSource() == gui.getTicketCancel().getBack()) {
            gui.maincl.show(gui.mainPanel, "home");
        }

        if(e.getSource() == gui.getTicketCancel().getCancel()) {
            String email = gui.getTicketCancel().getEmailText();
            int ticketNo = Integer.parseInt(gui.getTicketCancel().getTicketNoText());
        }
    }
    
    public void GUIMoviePageButton(ActionEvent e) {
        if(e.getSource() == gui.getMoviePage().getBack()) {
            gui.getMoviePage().remove();
            gui.maincl.show(gui.mainPanel, "home");
        }

        if(e.getSource() == gui.getMoviePage().getNext()) {
            if(flag == 0) {
                gui.getMoviePage().showDate();
                flag++;
            }

            else {
                gui.getMoviePage().showShowTimes();
                flag = 0;
            }

        }

        if(e.getSource() == gui.getMoviePage().getSeat()) {
            gui.maincl.show(gui.mainPanel, "seatMap");
        }

        if(e.getSource() == gui.getMoviePage().getSubmit()) {
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

        if(e.getSource() == gui.getSeatSelection().getNext()) {
            gui.maincl.show(gui.mainPanel, "payment");
        }
    }

    public void GUIPaymentPageButton(ActionEvent e) {
        if(e.getSource() == gui.getPaymentPage().getBack()) {
            gui.maincl.show(gui.mainPanel, "movie");
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
