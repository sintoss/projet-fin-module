package com.iot.schoolproject.service.imp;

import com.iot.schoolproject.service.api.MailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

@Service
public class MailSenderImpl implements MailSender {

    @Override
    public void sendNotification(String temperature) throws MessagingException {

        Properties properies = new Properties();
        properies.put("mail.smtp.host", "smtp.gmail.com");
        properies.put("mail.smtp.port", "465");
        properies.put("mail.smtp.auth", "true");
        properies.put("mail.smtp.starttls.enable", "true");
        properies.put("mail.smtp.starttls.required", "true");
        properies.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properies.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(properies, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("younesamara00@gmail.com", "tlbbaajubmbfpkyc");
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("younesamara00@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse("mostafatahri123@gmail.com"));
        message.setSubject("Mail Subject");

        String msg = "temperateur to : "+temperature;

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);

    }
}
