package com.iot.schoolproject.service.imp;

import com.iot.schoolproject.dto.WeatherListDto;
import com.iot.schoolproject.entities.Weather;
import com.iot.schoolproject.repository.WeatherRepository;
import com.iot.schoolproject.service.api.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;
    private final TelegramNotifier telegramNotifier;
    private final WhatsappSender whatsappSender;
    private final MailSender mailSender;
    private final PhoneMessage phoneMessage;

    @Override
    public void add(String temperature) throws Exception {
        Weather weather = new Weather();
        weather.setTemperature(temperature);
        weather.setDate(LocalDateTime.now());
        telegramNotifier.sendNotification(temperature);
        whatsappSender.sendWhatsappNotification(temperature);
        mailSender.sendNotification(temperature);
        //phoneMessage.sendNotification(temperature);
        weatherRepository.save(weather);
    }

    @Override
    public List<WeatherListDto> getAllTemperature() {
        List<WeatherListDto> weatherListDto = new ArrayList<>();
        for (Weather w : weatherRepository.findAll()) {
            weatherListDto.add(new WeatherListDto(w.getId(), w.getTemperature(), w.getDate()));
        }

        return weatherListDto;
    }
}
