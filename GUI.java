import javax.swing.*;
import java.awt.*;
public class GUI extends JFrame {
    public static void main(String args[]){
        JFrame frame = new JFrame("Cine-Ma-Ma");
        LoginHomePage log = new LoginHomePage(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.add(log.getPanel(), BorderLayout.CENTER);       
        frame.setVisible(true);
    }
}
