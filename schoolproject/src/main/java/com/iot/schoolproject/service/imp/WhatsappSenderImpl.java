package com.iot.schoolproject.service.imp;

import com.iot.schoolproject.service.api.WhatsappSender;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class WhatsappSenderImpl implements WhatsappSender {

    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "ACdc4e53f718a60569b0b5731390c62370";
    public static final String AUTH_TOKEN = "b341ae30eb1f82011b8a96109df780ff";

    @Override
    public void sendWhatsappNotification(String temperature) throws Exception{
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+212762750416"),
                        new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                        "temperature : \uD83C\uDF21️ "+ temperature)
                .create();

        System.out.println(message.getSid());
    }
}

