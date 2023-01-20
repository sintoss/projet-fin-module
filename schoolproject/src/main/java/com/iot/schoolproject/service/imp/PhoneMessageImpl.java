package com.iot.schoolproject.service.imp;

import com.iot.schoolproject.service.api.PhoneMessage;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;

@Service
public class PhoneMessageImpl implements PhoneMessage {

    public static final String ACCOUNT_SID = "ACdc4e53f718a60569b0b5731390c62370";
    public static final String AUTH_TOKEN = "b341ae30eb1f82011b8a96109df780ff";

    @Override
    public void sendNotification(String temperature) {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+212762750416"),
                        "MGb45d259b40bf274d7b6da453ce63335b",
                        "Temperature is " + temperature)
                .create();

        System.out.println(message.getSid());

    }
}
