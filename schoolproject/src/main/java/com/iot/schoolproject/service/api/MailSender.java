package com.iot.schoolproject.service.api;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface MailSender {

    void sendNotification(String temperature) throws MessagingException;

}
