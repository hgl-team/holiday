package org.hglteam.service.holiday.infrastructure.application.convertion;

import com.google.gson.Gson;
import org.hglteam.convertion.api.Converter;
import org.hglteam.convertion.api.ConverterContext;
import org.hglteam.convertion.api.TypeConverter;
import org.hglteam.service.holiday.control.converter.HolidayDescriptorToHolidayDescriptorDtoConverter;
import org.hglteam.service.holiday.control.converter.JsonToEmilianiArgumentConverter;
import org.hglteam.service.holiday.control.converter.JsonToFixedDateArgumentConverter;
import org.hglteam.service.holiday.control.converter.JsonToRelativeToEasterArgumentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConvertionConfiguration {
    private final ConverterContext convertionContext;
    private final Converter converter;

    @Autowired
    public ApplicationConvertionConfiguration(ConverterContext convertionContext, Converter converter) {
        this.convertionContext = convertionContext;
        this.converter = converter;
    }

    @Bean
    public JsonToFixedDateArgumentConverter jsonToFixedDateArgumentConverter(Gson gson) {
        return register(new JsonToFixedDateArgumentConverter(gson));
    }

    @Bean
    public JsonToRelativeToEasterArgumentConverter jsonToRelativeToEasterArgumentConverter(Gson gson) {
        return register(new JsonToRelativeToEasterArgumentConverter(gson));
    }

    @Bean
    public JsonToEmilianiArgumentConverter jsonToEmilianiArgumentConverter(Gson gson) {
        return register(new JsonToEmilianiArgumentConverter(gson));
    }

    @Bean
    public HolidayDescriptorToHolidayDescriptorDtoConverter holidayDescriptorToHolidayDescriptorDtoConverter() {
        return register(new HolidayDescriptorToHolidayDescriptorDtoConverter());
    }

    private <T extends TypeConverter> T register(T instance) {
        convertionContext.register(instance);
        return instance;
    }
}
