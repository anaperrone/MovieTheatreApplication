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

        gui.getSeats().getSeat1().addActionListener(this);
        gui.getSeats().getSeat2().addActionListener(this);
        gui.getSeats().getSeat3().addActionListener(this);
        gui.getSeats().getSeat4().addActionListener(this);
        gui.getSeats().getSeat5().addActionListener(this);
        gui.getSeats().getSeat6().addActionListener(this);
        gui.getSeats().getSeat7().addActionListener(this);
        gui.getSeats().getSeat8().addActionListener(this);
        gui.getSeats().getSeat9().addActionListener(this);
        gui.getSeats().getSeat10().addActionListener(this);

        gui.getSignUp().getEnter().addActionListener(this);
        gui.getSignUp().getBack().addActionListener(this);

        gui.getMoviePage().getBack().addActionListener(this);
        gui.getMoviePage().getNext().addActionListener(this);
        gui.getMoviePage().getSeat().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        GUIloginHomePageButton(e);
        GUIloginPageButton(e);
        GUISignUpPageButton(e);
        GUITicketCancelButton(e);
        GUIMoviePageButton(e);

        if(e.getSource() == gui.getPaymentPage().getPay()) {
            String name = gui.getPaymentPage().getNameText();
            String card = gui.getPaymentPage().getCardText();
            String expiry = gui.getPaymentPage().getExpiryText();
            String cvv = gui.getPaymentPage().getCVVText();
            
            //database tings
        }
    
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
            gui.maincl.show(gui.mainPanel, "login");
        }

        if(e.getSource() == gui.getSignUp().getEnter()) {
            String username = gui.getSignUp().getUserText();
            String password = gui.getSignUp().getPasswordText();


            gui.maincl.show(gui.mainPanel, "movie");
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
            gui.maincl.show(gui.mainPanel, "seats");
        }

        if(e.getSource() == gui.getPaymentPage().getBack()) {
            gui.maincl.show(gui.mainPanel, "ticket");
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
