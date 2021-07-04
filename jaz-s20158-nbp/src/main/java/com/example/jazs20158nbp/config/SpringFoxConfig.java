package com.example.jazs20158nbp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringFoxConfig {

    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "NBP Gold course checker",
                "NBP Gold course checker for exam on Advanced Java Subject",
                "PJATK 1.0",
                null,
                new Contact("PJATK", "www.gdansk.pja.edu.pl/pl/", "dziekanat@pjwstk.edu.pl"),
                null,
                null,
                Collections.emptyList()
        );
    }

}
