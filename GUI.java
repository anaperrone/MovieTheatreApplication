import javax.swing.*;
import java.awt.*;
public class GUI extends JFrame {
    JFrame frame;
    JPanel mainPanel;
    LoginHomePage loginPage;
    Login login;
    SignUp signUp;
    //Guest g;
    CardLayout cl = new CardLayout();

    public GUI() {
        frame = new JFrame("Cine-Ma-Ma");
        mainPanel = new JPanel();
        mainPanel.setLayout(cl);

        loginPage = new LoginHomePage(cl, mainPanel);
        login = new Login(cl, mainPanel);
        signUp = new SignUp(cl, mainPanel);
        
        mainPanel.add(loginPage.getPanel(), "home");
        mainPanel.add(login.getPanel(), "login");
        mainPanel.add(signUp.getPanel(), "signup");

        cl.show(mainPanel, "home");

        //su = new Signup();
        //g = new Guest();

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,300);    
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
