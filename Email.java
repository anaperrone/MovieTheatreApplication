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
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
// import javax.activation.*;

public class Email {
    private String email;
    private String to;
    private String from = "ensf480L01group2@gmail.com";

    public Email(String e) {
        this.email = e;
    }

    public void sendEmail(String to) throws Exception{

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.transport.protocl", "smtp");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override 
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "Password");
            }
        });

        Message message = new MimeMessage(session);
        message.setSubject("Cine-Ma-Ma Receipt");
        message.setContent("<h1>Email", "text/html");

        Address addressTo = new InternetAddress(to);
        message.setRecipient(Message.RecipientType.TO, addressTo);

        Transport.send(message);

    }

}
