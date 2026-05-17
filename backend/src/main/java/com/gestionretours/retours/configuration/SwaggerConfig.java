package com.gestionretours.retours.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

/**
 * Configuration Swagger/OpenAPI.
 * Documentation automatique de toutes les APIs REST.
 * Accessible sur : http://localhost:8080/swagger-ui/index.html
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Gestion des Retours")
                        .version("1.0.0")
                        .description("API REST pour le système de gestion des retours produits")
                        .contact(new Contact()
                                .name("Équipe Développement")
                                .email("dev@gestionretours.tn")));
    }
}