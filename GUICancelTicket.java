import javax.swing.*;
import java.awt.*;


public class GUICancelTicket {
    private JPanel panel;
    private JLabel ticketNo;
    private JLabel email;
    private JTextField ticketNoField;
    private JTextField emailField;
    private JButton back;
    private JButton cancel;

    public GUICancelTicket() {
        panel = new JPanel();
        
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(50, 168, 137));
        GridBagConstraints gbc = new GridBagConstraints();


        email = new JLabel("Email: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,0,10,0);

        panel.add(email, gbc);

        emailField = new JTextField(30);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,0,10,0);
        //usernameField.setBounds(100,20,165,25);
        panel.add(emailField, gbc);

        ticketNo = new JLabel("Ticket Number: ");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(10,0,10,0);
        //password.setBounds(10,50,80,25);
        panel.add(ticketNo, gbc);

        ticketNoField = new JTextField(30);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.insets = new Insets(10,0,10,0);
        //passwordField.setBounds(100,50,165,25);
        panel.add(ticketNoField, gbc);

        back = new JButton("<--");
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.insets = new Insets(10,5,10,5);
        //back.setBounds(50,80,80,25);
        //back.addActionListener(this);
        panel.add(back, gbc);

        cancel = new JButton("Cancel Ticket");
        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.insets = new Insets(10,5,10,5);
        //enter.setBounds(160,80,80,25);
        //enter.addActionListener(this);
        panel.add(cancel, gbc);

    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getCancel() {
        return this.cancel;
    }

    public JButton getBack() {
        return this.back;
    }

    public String getEmailText() {
        return this.emailField.getText();
    }

    public String getTicketNoText() {
        return this.ticketNoField.getText();
    }

}




    