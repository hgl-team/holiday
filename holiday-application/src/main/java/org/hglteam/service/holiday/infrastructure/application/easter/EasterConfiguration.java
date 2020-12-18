package org.hglteam.service.holiday.infrastructure.application.easter;

import org.hglteam.service.holiday.control.easter.EasterCalculator;
import org.hglteam.service.holiday.control.easter.GaussAlgorithmEasterCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EasterConfiguration {

    @Bean
    public EasterCalculator easterCalculator() {
        return new GaussAlgorithmEasterCalculator();
    }
}
