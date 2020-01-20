/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientwork;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {

    public  void mail(String Email, String Subject, String Body) {
        
        //Sets the email to vincents email as it was requested as a login page was
        // time consuming in the workfield to do everytime and he was only going to use one email anyways
        final String username = "VincentsInventoryManager@gmail.com";
        final String password = "Password.1";

        // Uses port 587 and makes sure that the email can send from an app.
        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
       // Checks to see if the email login is correct
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            
            //Sets the Sender, Recipient, Subject, and Body
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("VincentsInventoryManager@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(Email)
            );
            message.setSubject(Subject);
            message.setText(Body);

            //Actual sends the message
            Transport.send(message);
            // Outputs a message to verify its completion
            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
