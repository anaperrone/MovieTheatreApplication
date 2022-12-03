/*
* Email.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

import java.util.Properties;
import javax.mail.Session;
import javax.mail.internet.*;
// import javax.activation.*;

public class Email {
    private String email;
    private String to;
    private String from = "ensf480L01group2@gmail.com";

    public Email(String e) {
        this.email = e;
    }

    public void sendEmail(String to) {
        // Recipient's email ID needs to be mentioned.
        this.to = to;

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        // try {
        //     // Create a default MimeMessage object.
        //     MimeMessage message = new MimeMessage(session);

        //     // Set From: header field of the header.
        //     message.setFrom(new InternetAddress(from));

        //     // Set To: header field of the header.
        //     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

        //     // Set Subject: header field
        //     message.setSubject("This is the Subject Line!");

        //     // Create the message part 
        //     BodyPart messageBodyPart = new MimeBodyPart();

        //     // Fill the message
        //     messageBodyPart.setText("This is message body");
            
        //     // Create a multipar message
        //     Multipart multipart = new MimeMultipart();

        //     // Set text message part
        //     multipart.addBodyPart(messageBodyPart);

        //     // Part two is attachment
        //     messageBodyPart = new MimeBodyPart();
        //     String filename = "file.txt"; 
        //     DataSource source = new FileDataSource(filename);
        //     messageBodyPart.setDataHandler(new DataHandler(source));
        //     messageBodyPart.setFileName(filename);
        //     multipart.addBodyPart(messageBodyPart);

        //     // Send the complete message parts
        //     message.setContent(multipart );

        //     // Send message
        //     Transport.send(message);
        //     System.out.println("Sent message successfully....");
        // } catch (MessagingException mex) {
        //     mex.printStackTrace();
        // }
    }
}
