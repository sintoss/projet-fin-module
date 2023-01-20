package com.iot.schoolproject.service.api;

import java.io.IOException;

public interface TelegramNotifier {
    void sendNotification(String temperature) throws IOException, InterruptedException;
}
