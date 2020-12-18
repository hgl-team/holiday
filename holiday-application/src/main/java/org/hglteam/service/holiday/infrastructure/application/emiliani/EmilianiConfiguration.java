package org.hglteam.service.holiday.infrastructure.application.emiliani;

import org.hglteam.service.holiday.control.emiliani.DefaultEmilianiCalculator;
import org.hglteam.service.holiday.control.emiliani.EmilianiCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmilianiConfiguration {

    @Bean
    public EmilianiCalculator emilianiCalculator() {
        return new DefaultEmilianiCalculator();
    }
}
