package org.hglteam.service.holiday.infrastructure.springboot;

import org.hglteam.service.holiday.infrastructure.config.cloud.ConfigurationInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "org.hglteam.service.holiday.web.rest",
        "org.hglteam.service.holiday.infrastructure"
})
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        var app = new SpringApplication(Application.class);

        app.addInitializers(new ConfigurationInitializer());
        app.run(args);
    }
}
