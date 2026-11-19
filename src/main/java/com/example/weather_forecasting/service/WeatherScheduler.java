package com.example.weather_forecasting.service;
import java.util.List;
import com.example.weather_forecasting.repository.WeatherRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
@Service
public class WeatherScheduler {

    private final WeatherService weatherService;
    private final WeatherRepository weatherRepository;

    public WeatherScheduler(
            WeatherService weatherService,
            WeatherRepository weatherRepository) {
        this.weatherService = weatherService;
        this.weatherRepository = weatherRepository;
    }

    @Scheduled(fixedRate = 900000)
    public void updateWeather() {

        List<String> cities = weatherRepository.findDistinctCities();

        for (String city : cities) {

            try {
                weatherService.getWeather(city);
                System.out.println("Weather updated: " + city);

            } catch (Exception e) {
                System.out.println("Failed to update: " + city);
            }
        }
    }
}