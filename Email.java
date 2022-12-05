/*
* Email.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

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

    //method called from database with the email of client, content of the email to send and subject 
    public void sendEmail(String to, String content, String subject) {

        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", true);
            properties.put("mail.smtp.starttls.enable", true);
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", 587);

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override 
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, "ttchjtogddcpudep");
                }
            });

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.setSubject(subject);
            message.setContent(content, "text/plain");

            Address addressTo = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, addressTo);

            Transport.send(message);

        } catch(Exception e) {
        }
    }
}
