package com.stevendev.apirest.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080/");
        devServer.setDescription("URL del servidor Local");

        Server prodServer = new Server();
        prodServer.setUrl("https://project-apirest.com/");
        prodServer.setDescription("URL del servidor en Producción");

        Contact contact = new Contact();
        contact.setEmail("info@project-apirest.com");
        contact.setName("Jarvis");
        contact.setUrl("https://www.project-apirest.com");

        Info info = new Info()
                .title("Project API Rest")
                .version("1.0")
                .contact(contact)
                .description("Documento que expone las APIs construida en la aplicación")
                .termsOfService("https://www.project-apirest.com/terms");

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer, prodServer));
    }

    @Bean
    public ModelResolver modelResolver(ObjectMapper objectMapper) {

        return new ModelResolver(objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE));
    }
}
