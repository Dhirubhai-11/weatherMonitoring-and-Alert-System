package com.example.weather_forecasting.controller;

import com.example.weather_forecasting.entity.Weather;
import com.example.weather_forecasting.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/weather")
    public class WeatherController {

        private final WeatherService weatherService;

        public WeatherController(WeatherService weatherService) {
            this.weatherService = weatherService;
        }

        @GetMapping("/{city}")
        public Weather getWeather(@PathVariable String city) throws Exception {
            return weatherService.getWeather(city);
        }

    }

