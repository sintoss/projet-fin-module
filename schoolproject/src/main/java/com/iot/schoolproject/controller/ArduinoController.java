package com.iot.schoolproject.controller;

import com.iot.schoolproject.service.api.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/arduino")
@CrossOrigin("*")
public class ArduinoController {

    private WeatherService weatherService;

    @PostMapping
    public void add (@RequestBody String temperature) throws Exception {
        weatherService.add(temperature);
    }


}
