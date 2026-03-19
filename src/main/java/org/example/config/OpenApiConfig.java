package org.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI advertisementsOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("SolarLab Advertisements API")
                        .description("REST API for managing board advertisements")
                        .version("v1")
                        .contact(new Contact().name("SolarLab Project"))
                        .license(new License().name("Internal project usage")));
    }
}
