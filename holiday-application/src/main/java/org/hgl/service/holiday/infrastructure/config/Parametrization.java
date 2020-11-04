package org.hgl.service.holiday.infrastructure.config;

import org.hgl.service.holiday.infrastructure.jpa.DataSourceInformation;
import org.hgl.service.holiday.infrastructure.jpa.FlywayConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.stream.Stream;

@Configuration
public class Parametrization {

    @Bean("systemZoneId")
    public ZoneId systemZoneId(
            @Value("${application.localization.time.zone-id}") String zoneId) {
        return ZoneId.of(zoneId);
    }

    @Bean
    public DataSourceInformation dataSourceInformation(
            @Value("${application.datasource.driver}") String driverClassName,
            @Value("${application.datasource.url}") String url,
            @Value("${application.datasource.username}") String username,
            @Value("${application.datasource.password}") String password) {
        return DataSourceInformation.builder()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .build();
    }

    @Bean
    public FlywayConfiguration flywayConfiguration(ApplicationContext context) {
        return new FlywayConfiguration(context.getEnvironment());
    }

    public static Stream<String> getPropertyNames(Environment env) {
        return ((AbstractEnvironment)env).getPropertySources().stream()
                .filter(EnumerablePropertySource.class::isInstance)
                .map(EnumerablePropertySource.class::cast)
                .map(EnumerablePropertySource::getPropertyNames)
                .flatMap(Arrays::stream)
                .distinct();
    }
}
