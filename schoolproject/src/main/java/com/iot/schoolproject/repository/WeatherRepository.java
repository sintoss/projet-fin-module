package com.iot.schoolproject.repository;

import com.iot.schoolproject.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface WeatherRepository extends JpaRepository<Weather,Long> {

}
