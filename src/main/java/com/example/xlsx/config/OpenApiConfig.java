package com.example.xlsx.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Application to find Nth maximum number Api",
                version = "1.0.0",
                contact = @Contact(
                        name = "Petrov Georgy",
                        email = "gosha_petrov20@rambler.ru",
                        url = "https://t.me/psk_pgs"
                )
        )
)
public class OpenApiConfig {
}
