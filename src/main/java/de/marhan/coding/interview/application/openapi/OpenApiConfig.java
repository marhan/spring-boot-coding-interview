package de.marhan.coding.interview.application.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

    private final OpenApiProperties properties;

    @Bean
    public GroupedOpenApi apiDocumentation() {
        return GroupedOpenApi.builder()
                .group("de.marhan.sample")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(buildInfo());
    }

    private Info buildInfo() {
        return new Info().title(properties.getName())
                .description(properties.getDescription())
                .version(properties.getVersion())
                .contact(buildContact())
                .license(buildLicense());
    }

    private License buildLicense() {
        return new License().name("MIT License").url("https://opensource.org/licenses/MIT");
    }

    private Contact buildContact() {
        return buildContact("Markus Hanses", "http://www.markushanses.de", "hanses.markus@gmail.com");
    }

    private Contact buildContact(String name, String url, String email) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setUrl(url);
        contact.setEmail(email);
        return contact;
    }
}
