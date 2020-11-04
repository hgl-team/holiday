package org.hgl.service.holiday.infrastructure.convertion;

import org.hgl.convertion.ConvertionContextMap;
import org.hgl.convertion.GenericConverter;
import org.hgl.convertion.api.Converter;
import org.hgl.convertion.api.ConverterContext;
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
