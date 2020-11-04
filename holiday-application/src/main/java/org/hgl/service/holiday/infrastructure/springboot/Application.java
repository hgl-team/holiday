package org.hgl.service.holiday.infrastructure.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "org.hgl.service.holiday.web.rest",
        "org.hgl.service.holiday.infrastructure"
})
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }
}
