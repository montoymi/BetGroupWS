package com.amadeus.betgroup.service.commons;


import com.amadeus.betgroup.exception.ApplicationException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class EmailService {
    public static String sendEmail(String toAddress, String subject, String message) {
        String result = "";

        // sets SMTP server properties
        String hostmail = "mail.betgroupsports.com";
        String portmail = "8025";
        String usermail = "admin@betgroupsports.com";
        String passmail = "LaPollaDeMiAmigo2018";

        try{
            Properties properties = new Properties();
            properties.put("mail.smtp.host", hostmail);
            properties.put("mail.smtp.port", portmail);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            // creates a new session with an authenticator
            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(usermail, passmail);
                }
            };
            Session session = Session.getInstance(properties, auth);
// creates a new e-mail message
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(usermail));
            InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
            msg.setRecipients(Message.RecipientType.TO, toAddresses);
            msg.setSubject(subject);
            msg.setSentDate(new Date());

            // creates message part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(message, "text/html");

            // creates multi-part
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // sets the multi-part as e-mail's content
            msg.setContent(multipart);

            // sends the e-mail
            Transport.send(msg);
        } catch(Exception e){
            result = " Error con correo a" + toAddress + ". " + e.getMessage() + "<br/>";
            throw new ApplicationException(result);
        }

        return result;
    }
}
