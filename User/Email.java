/*
* Email.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

package User;
import Movies.*;
import GUI.*;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.*;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
    private String from;

    public Email() {
        from = "ensf480cinemama@gmail.com"; //assigning our sending email 
        //account we created specifically for the project
    }

    /*
    * Public method called from registered user and database with email of recipient, subject and content of email
    * message to send
    */
    public void sendEmail(String to, String content, String subject) {

        try {
            Properties properties = new Properties();
            //necessary smtp configurations
            properties.put("mail.smtp.auth", true);
            properties.put("mail.smtp.starttls.enable", true);
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", 587);

            //creating authenticator with designated device password
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override 
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, "ttchjtogddcpudep");
                }
            });

            //creating message with session configs
            Message message = new MimeMessage(session);
            //creating sender internet address
            message.setFrom(new InternetAddress(from));
            //adding the subject line to the message given from Registered User
            message.setSubject(subject);
            //adding message content
            message.setContent(content, "text/plain");
            //creating recipient internet address
            Address addressTo = new InternetAddress(to);
            //setting address as recipient
            message.setRecipient(Message.RecipientType.TO, addressTo);
            //sending email
            Transport.send(message);

        } catch(Exception e) {
        }
    }
}
