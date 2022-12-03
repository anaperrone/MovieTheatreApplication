import javax.swing.*;
import java.awt.*;
public class GUI extends JFrame {
    JFrame frame;
    JPanel mainPanel;
    GUILoginHomePage loginPage;
    GUILogin login;
    GUIPaymentPage payPage;
    GUISignUp signup;
<<<<<<< Updated upstream
    GUIMovie moviePage;
=======
>>>>>>> Stashed changes
    //Guest g;
    CardLayout cl = new CardLayout();

    public GUI() {
        frame = new JFrame("Cine-Ma-Ma");
        mainPanel = new JPanel();
        mainPanel.setLayout(cl);

        loginPage = new GUILoginHomePage(cl, mainPanel);
        login = new GUILogin(cl, mainPanel);
        signup = new GUISignUp(cl, mainPanel);
        payPage = new GUIPaymentPage(cl, mainPanel);
<<<<<<< Updated upstream
        moviePage = new GUIMovie(cl, mainPanel);
=======
>>>>>>> Stashed changes
        
        mainPanel.add(loginPage.getPanel(), "home");
        mainPanel.add(login.getPanel(), "login");
        mainPanel.add(signup.getPanel(), "signup");

<<<<<<< Updated upstream
        mainPanel.add(moviePage.getPanel(), "movie");

=======
>>>>>>> Stashed changes
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

    public static void main(String args[]){        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
            }
        });
    }
}
