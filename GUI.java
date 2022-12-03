import javax.swing.*;
import java.awt.*;
public abstract class GUI {
    JFrame frame;
    JPanel mainPanel;
    GUILoginHomePage loginPage;
    GUILogin login;
    GUIPaymentPage payPage;
    GUISignUp signup;
    GUIMovie moviePage;
    GUISeats seats;
    CardLayout cl = new CardLayout();

    public GUI() {
        frame = new JFrame("Cine-Ma-Ma");
        mainPanel = new JPanel();
        mainPanel.setLayout(cl);

        loginPage = new GUILoginHomePage(cl, mainPanel);
        login = new GUILogin(cl, mainPanel);
        signup = new GUISignUp(cl, mainPanel);
        seats = new GUISeats(cl, mainPanel);
        payPage = new GUIPaymentPage(cl, mainPanel);
        moviePage = new GUIMovie(cl, mainPanel);
        
        mainPanel.add(loginPage.getPanel(), "home");
        mainPanel.add(login.getPanel(), "login");
        mainPanel.add(signup.getPanel(), "signup");

        mainPanel.add(moviePage.getPanel(), "movie");
        mainPanel.add(seats.getPanel(), "seats");

        mainPanel.add(payPage.getPanel(), "payment");

        cl.show(mainPanel, "home");

        //su = new Signup();
        //g = new Guest();

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);

    }
}
