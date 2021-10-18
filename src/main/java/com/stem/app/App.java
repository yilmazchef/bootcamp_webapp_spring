package com.stem.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Bootcamp API", version = "1.0", description = "Bootcamp API aims to organize bootcamp events for the students (children). Their parents can register children to bootcamps."))
public class App {

    public static void main(String[] args) {
        final var applicationContext = SpringApplication.run(App.class, args);
        log.info("Application active: " + applicationContext.isActive());
    }
}
