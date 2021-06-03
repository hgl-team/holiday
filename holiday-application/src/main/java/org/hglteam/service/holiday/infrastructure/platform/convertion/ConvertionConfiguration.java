package org.hglteam.service.holiday.infrastructure.platform.convertion;

import org.hglteam.convertion.ConvertionContextMap;
import org.hglteam.convertion.GenericConverter;
import org.hglteam.convertion.api.Converter;
import org.hglteam.convertion.api.ConverterContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConvertionConfiguration {

    @Bean
    public ConverterContext convertionContext() {
        return new ConvertionContextMap();
    }

    @Bean
    public Converter converter(ConverterContext convertionContext) {
        return new GenericConverter(convertionContext);
    }
}
