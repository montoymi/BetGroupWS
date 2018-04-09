package com.amadeus.betgroup.commons;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class Email {

    public static String sendEmail(String toAddress, String subject, String message) {
        // sets SMTP server properties

        String result = "";
        try{
            Properties properties = new Properties();
            properties.put("mail.lapollademiamigo.com", ReadParameters.getString("hostmail"));
            properties.put("8025", ReadParameters.getString("portmail"));
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("notificaciones@lapollademiamigo.com", ReadParameters.getString("usermail"));
            properties.put("polla5791", ReadParameters.getString("passmail"));

            // creates a new session with an authenticator
            Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(ReadParameters.getString("usermail"), ReadParameters.getString("passmail"));
                }
            };
            Session session = Session.getInstance(properties, auth);
// creates a new e-mail message
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(ReadParameters.getString("usermail")));
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
        } finally{
            return result;
        }

    }
}
