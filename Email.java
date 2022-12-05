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
//import java.activation;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
    private String to;
    private String from;

    public Email() {
        from = "ensf480cinemama@gmail.com";
    }

    public void sendEmail(String to) {

        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", true);
            properties.put("mail.smtp.starttls.enable", true);
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", 587);

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override 
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, "ensf480fall2022");
                }
            });

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.setSubject("Cine-Ma-Ma Receipt");
            message.setContent("<h1>Email", "text/html");

            Address addressTo = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, addressTo);

            Transport.send(message);

        } catch(Exception e) {

        }
    }

    public static void main(String[] args) {
        Email email = new Email();
        email.sendEmail("anaclara.perrone@gmail.com");
    }

}
