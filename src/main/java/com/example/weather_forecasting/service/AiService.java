package com.example.weather_forecasting.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class AiService {

    @Value("${openrouter.api.key}")
    private String apiKey;

    @Value("${openrouter.api.url}")
    private String apiUrl;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String getPrecaution(
            Double temperature,
            Integer humidity,
            Double windSpeed,
            String weatherCondition,
            String weatherDescription) {

        String prompt = """
                You are a weather precaution assistant.

                Based on the weather data below, give exactly 2 or 3
                short and useful precautions.

                Temperature: %s °C
                Humidity: %s %%
                Wind Speed: %s m/s
                Weather Condition: %s
                Weather Description: %s

                Rules:
                - Give only 2 or 3 precautions.
                - Each precaution must be one short line.
                - Maximum 15 words per precaution.
                - Use a suitable emoji.
                - Do not explain the weather.
                - Do not give medical advice.
                - Return only the precautions.
                """.formatted(
                temperature,
                humidity,
                windSpeed,
                weatherCondition,
                weatherDescription
        );

        try {
            RestClient client = RestClient.builder()
                    .baseUrl(apiUrl)
                    .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .build();

            Map<String, Object> request = Map.of(
                    "model", "openrouter/free",
                    "messages", new Object[]{
                            Map.of(
                                    "role", "user",
                                    "content", prompt
                            )
                    }
            );

            String response = client.post()
                    .body(request)
                    .retrieve()
                    .body(String.class);

            JsonNode json = objectMapper.readTree(response);

            return json.path("choices")
                    .get(0)
                    .path("message")
                    .path("content")
                    .asText();

        } catch (Exception e) {
            e.printStackTrace();
            return "⚠️ AI precaution unavailable.";
        }
    }
}