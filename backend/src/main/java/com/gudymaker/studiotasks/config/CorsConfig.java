package com.gudymaker.studiotasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.Duration;
import java.util.List;

@Configuration
public class CorsConfig {

    private static final List<String> ALLOWED_ORIGIN = List.of(
            "http://localhost:4200"
    );

    private static final List<String> ALLOWED_METHOD = List.of(
            "GET", "POST", "PUT", "DELETE", "OPTIONS"
    );

    private static final List<String> ALLOWED_HEADERS = List.of(
        "Authorization", "Content-Type", "X-Requested-With", "Accept", "Origin"
    );

    private static final List<String> EXPOSED_HEADERS = List.of (
            "Location"
    );

    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(ALLOWED_ORIGIN);
            config.setAllowedMethods(ALLOWED_METHOD);
            config.setAllowedHeaders(ALLOWED_HEADERS);
            config.setExposedHeaders(EXPOSED_HEADERS);

            config.setAllowCredentials(true);
            config.setMaxAge(Duration.ofHours(1));

            UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", config);

            return new CorsFilter(source);
        }
}