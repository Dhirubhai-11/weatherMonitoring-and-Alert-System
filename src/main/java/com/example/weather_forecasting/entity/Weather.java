package com.example.weather_forecasting.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "weather")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private Double temperature;

    private Double feelsLike;

    private Integer pressure;

    private Integer humidity;

    private Double windSpeed;

    private Integer windDegree;

    private String weatherCondition;

    private String weatherDescription;
    private String precaution;

    private LocalDateTime recordedAt;

}
