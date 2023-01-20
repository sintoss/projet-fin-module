package com.iot.schoolproject.controller;

import com.iot.schoolproject.dto.WeatherListDto;
import com.iot.schoolproject.service.api.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/weather")
@CrossOrigin("*")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping()
    public ResponseEntity<List<WeatherListDto>> find() {
        return new ResponseEntity<>(weatherService.getAllTemperature(), HttpStatus.OK);
    }

}
