package org.hglteam.service.holiday.infrastructure.web.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

@Configuration
public class ConfiguracionJson {
    @Bean
    @Primary
    public Gson gson(@Qualifier("systemZoneId") ZoneId zoneId,
                     @Value("${application.json.format.local-date}") String localDateFormat,
                     @Value("${application.json.format.local-time}") String localTimeFormat,
                     @Value("${application.json.format.local-datetime}") String localDateTimeFormat) {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .registerTypeAdapter(LocalDate.class, new DateTypeAdapters.LocalDateTypeAdapter(zoneId, localDateFormat))
                .registerTypeAdapter(LocalTime.class, new DateTypeAdapters.LocalTimeTypeAdapter(localTimeFormat))
                .registerTypeAdapter(LocalDateTime.class, new DateTypeAdapters.LocalDateTimeTypeAdapter(zoneId, localDateTimeFormat))
                .create();
    }
}
