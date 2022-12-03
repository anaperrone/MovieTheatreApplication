import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainController implements ActionListener {
    //private MoviesController movieController;
    //private Payment payment;
    //private OrdinaryUser ordinaryUser;
    private DataBase database; 
    //private ActionListenerClass alc;
    private GUI gui;

    public MainController() {
        gui = new GUI();
        database = new DataBase();
        

      gui.getGuiLoginHomePage().getloginButton().addActionListener(this);
      gui.getLogin().getEnter().addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == gui.getGuiLoginHomePage().getloginButton()) {
            gui.maincl.show(gui.mainPanel, "login");
        }

        if(e.getSource() == gui.getLogin().getEnter()) {
            String username = gui.getLogin().getUserText();
            String password = gui.getLogin().getPasswordText();
            
            if(database.grantAccess(username, password)) {
                System.out.println("HI");
                gui.maincl.show(gui.mainPanel, "movie");
            }
        
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
