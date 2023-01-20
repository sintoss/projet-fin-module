package com.iot.schoolproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Weather")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String temperature;
    private LocalDateTime date;
}
