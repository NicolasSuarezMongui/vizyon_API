package com.campuslands.vizyon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI().addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                        .components(new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()))
                        .info(new Info().title("VIZYON API")
                                .description("Api REST created for an Vizyon - Campus 2024")
                                .contact(new Contact()
                                        .name("Nicolas Suarez")
                                        .email("brayansuarezmongui@gmail.com")
                                        .url("https://github.com/NicolasSuarezMongui"))
                                .version("1.0"));
        }

        private SecurityScheme createAPIKeyScheme() {
                return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
        }

}
