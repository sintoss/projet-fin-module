package com.iot.schoolproject.service.api;

public interface WhatsappSender {
    void sendWhatsappNotification(String temperature) throws Exception;
}
