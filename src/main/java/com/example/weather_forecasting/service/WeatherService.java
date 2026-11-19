package com.example.weather_forecasting.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.weather_forecasting.entity.Weather;
import com.example.weather_forecasting.repository.WeatherRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDateTime;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final WeatherRepository weatherRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final AiService aiService;

    public WeatherService(WeatherRepository weatherRepository, AiService aiService) {
        this.weatherRepository = weatherRepository;
        this.aiService = aiService;
    }

    public Weather getWeather(String city) throws Exception {

        String url = "https://api.openweathermap.org/data/2.5/weather"
                + "?q=" + city
                + "&appid=YOUR_API_KEY"
                + "&units=metric";

        String response = restTemplate.getForObject(url, String.class);

        JsonNode json = objectMapper.readTree(response);

        // OpenWeather se actual city name
        String cityName = json.get("name").asText();

        Weather weather = weatherRepository
                .findByCity(cityName)
                .orElse(new Weather());

        weather.setCity(cityName);

        weather.setTemperature(
                json.get("main").get("temp").asDouble()
        );

        weather.setFeelsLike(
                json.get("main").get("feels_like").asDouble()
        );



        weather.setPressure(
                json.get("main").get("pressure").asInt()
        );

        weather.setHumidity(
                json.get("main").get("humidity").asInt()
        );

        weather.setWindSpeed(
                json.get("wind").get("speed").asDouble()
        );

        weather.setWindDegree(
                json.get("wind").get("deg").asInt()
        );

        weather.setWeatherCondition(
                json.get("weather").get(0).get("main").asText()
        );

        weather.setWeatherDescription(
                json.get("weather").get(0).get("description").asText()
        );

        weather.setRecordedAt(LocalDateTime.now());

        String precaution = aiService.getPrecaution(
                weather.getTemperature(),
                weather.getHumidity(),
                weather.getWindSpeed(),
                weather.getWeatherCondition(),
                weather.getWeatherDescription()
        );

        System.out.println("AI Precaution:");
        System.out.println(precaution);
        weather.setPrecaution(precaution);
        return weatherRepository.save(weather);
    }


    // PostgreSQL se latest weather data nikalega
    public Weather getLatestWeather(String city) {

        return weatherRepository
                .findTopByCityOrderByRecordedAtDesc(city)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Weather data not found for " + city
                        )
                );
    }
}