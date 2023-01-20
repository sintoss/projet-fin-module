package com.iot.schoolproject.service.api;

import com.iot.schoolproject.dto.WeatherListDto;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface WeatherService {

    void add(String temperature) throws Exception;
    List<WeatherListDto> getAllTemperature();

}
