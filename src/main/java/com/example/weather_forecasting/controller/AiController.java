package com.example.weather_forecasting.controller;

import com.example.weather_forecasting.service.AiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/api/ai/test")
    public String testAi() {

        return aiService.getPrecaution(
                29.0,
                85,
                6.0,
                "Rain",
                "light rain"
        );
    }
}