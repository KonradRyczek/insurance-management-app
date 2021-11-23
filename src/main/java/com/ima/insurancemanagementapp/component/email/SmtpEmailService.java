package com.ima.insurancemanagementapp.component.email;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Component
public class SmtpEmailService {

    private String emailName = System.getenv("JAVA_EMAIL_NAME");
    private String emailPassword = System.getenv("JAVA_EMAIL_PASSWORD");
    private String host = "smtp.gmail.com";
    private String port = "465";

    private String default_mail_receiver = "iryczek35@gmail.com";


    public void sendMail(String emailText){
        this.sendMail(emailText, this.default_mail_receiver);
    }

    public void sendMail(String emailText, String MailReceiver) {

        Properties prop = System.getProperties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);

        Session ses = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailName, emailPassword);
            }
        });

        //ses.setDebug(true);
        try {
            Message message = new MimeMessage(ses);
            message.setFrom(new InternetAddress(emailName));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(MailReceiver)
            );

            message.setSubject(emailText);

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(
                    "<h1>" + emailText + "</h1><br>",
                    "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException err) {
            err.printStackTrace();
        }
    }
}
