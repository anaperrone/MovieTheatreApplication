import javax.swing.*;
import java.awt.*;

public class GUI {
    protected JFrame frame;
    public JPanel mainPanel;
    protected GUILoginHomePage loginPage;
    protected GUILogin login;
    protected GUIPaymentPage payPage;
    protected GUISignUp signup;
    protected GUIMovie moviePage;
    protected GUISeatMap seatMap;
    protected GUISeatSelection seatSelection;
    protected GUITicket ticket;
    protected GUICancelTicket ticketCancel;
    public CardLayout maincl = new CardLayout();

    public GUI() {
        frame = new JFrame("Cine-Ma-Ma");
        mainPanel = new JPanel();
        mainPanel.setLayout(maincl);

        loginPage = new GUILoginHomePage();
        login = new GUILogin();
        signup = new GUISignUp();
        ticketCancel = new GUICancelTicket();
        seatSelection = new GUISeatSelection();
        seatMap = new GUISeatMap();
        ticket = new GUITicket();
        payPage = new GUIPaymentPage();
        moviePage = new GUIMovie();


        mainPanel.add(loginPage.getPanel(), "home");
        mainPanel.add(login.getPanel(), "login");
        mainPanel.add(signup.getPanel(), "signup");
        mainPanel.add(ticketCancel.getPanel(), "cancelTicket");

        mainPanel.add(moviePage.getPanel(), "movie");
        mainPanel.add(seatMap.getPanel(), "seatMap");
        mainPanel.add(seatSelection.getPanel(), "seatSelection");

        mainPanel.add(ticket.getPanel(), "ticket");

        mainPanel.add(payPage.getPanel(), "payment");

        maincl.show(mainPanel, "home");


        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(700,600);
        frame.setVisible(true);

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
}
