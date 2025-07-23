package ru.sberhack2025.companyevents.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Конфигурация CORS для обеспечения доступа фронтенда к API
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                    "https://companyeventsminiapp.github.io", // GitHub Pages
                    "https://jakuba.olgarhythm.ru/company-events/", // Фронтенд
                    "https://web.telegram.org", // Telegram Web App
                    "http://localhost:3000" // Для локальной разработки
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
} 