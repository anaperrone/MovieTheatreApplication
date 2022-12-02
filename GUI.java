import javax.swing.*;
import java.awt.*;
public class GUI extends JFrame {
    JFrame frame;
    JPanel mainPanel;
    LoginHomePage loginPage;
    Login login;
    //SignUp su;
    //Guest g;
    CardLayout cl = new CardLayout();

    public GUI() {
        frame = new JFrame("Cine-Ma-Ma");
        mainPanel = new JPanel();
        mainPanel.setLayout(cl);

        loginPage = new LoginHomePage(cl, mainPanel);
        login = new Login(cl, mainPanel);
        
        mainPanel.add(loginPage.getPanel(), "1");
        mainPanel.add(login.getPanel(), "2");

        cl.show(mainPanel, "1");

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
