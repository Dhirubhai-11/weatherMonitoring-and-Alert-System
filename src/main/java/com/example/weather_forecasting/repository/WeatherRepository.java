package com.example.weather_forecasting.repository;

import com.example.weather_forecasting.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    Optional<Weather> findByCity(String city);

    Optional<Weather> findTopByCityOrderByRecordedAtDesc(String city);

    @Query("SELECT DISTINCT w.city FROM Weather w")
    List<String> findDistinctCities();
}