package com.iot.schoolproject.service.imp;

import com.iot.schoolproject.service.api.TelegramNotifier;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class TelegramNotifierImpl implements TelegramNotifier {

    private static final String CHAT_ID = "1196401409";
    private static final String TOKEN = "5855319447:AAFD0hefU-mc_PafRB27mSiZlluF53GryKU";

    @Override
    public void sendNotification(String temperature) throws IOException, InterruptedException{
        String message = "Temperature : \uD83C\uDF21️ "+temperature;

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .version(HttpClient.Version.HTTP_2)
                .build();

        UriBuilder builder = UriBuilder
                .fromUri("https://api.telegram.org")
                .path("/{token}/sendMessage")
                .queryParam("chat_id", CHAT_ID)
                .queryParam("text", message);

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(builder.build("bot" + TOKEN))
                .timeout(Duration.ofSeconds(5))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
