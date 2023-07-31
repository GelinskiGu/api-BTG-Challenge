package com.gelinski.apiBtgChallenge.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info().title("REST API with Java 20 and Spring Boot")
                .version("v1")
                .description("API REST for BTG Internship Challenge"));
    }
}
