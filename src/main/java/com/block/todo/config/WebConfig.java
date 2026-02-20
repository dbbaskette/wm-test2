package com.block.todo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * Web configuration for the Spring Boot application.
 * - Enables CORS for the React frontend during local development.
 * - Sets the embedded server port to 8080 (or another suitable port if needed).
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS requests from common React development servers
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000", "http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    /**
     * Customize the embedded servlet container port.
     * This uses a bean so it can be overridden by environment settings if needed.
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return factory -> factory.setPort(8080);
    }
}
