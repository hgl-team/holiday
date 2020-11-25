package org.hgl.service.holiday.infrastructure.config;

import org.hgl.service.holiday.infrastructure.jpa.DataSourceInformation;
import org.hgl.service.holiday.infrastructure.jpa.FlywayConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;

@Configuration
public class Parametrization {
    private static final Logger log = LoggerFactory.getLogger(Parametrization.class);

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
            @Value("${application.datasource.password}") String password,
            @Value("${application.datasource.is-jndi}") Boolean isJndi,
            @Value("${application.datasource.jndi-name}") String jndiName) {
        return DataSourceInformation.builder()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .isJndi(Boolean.TRUE.equals(isJndi))
                .jndiName(jndiName)
                .build();
    }

    @Bean
    public FlywayConfiguration flywayConfiguration(
            @Value("${spring.flyway.default-schema}") String defaultSchema,
            @Value("${spring.flyway.schemas}") String schemas,
            @Value("${spring.flyway.locations}") String locations) {
        log.info("\nSchemas: {}\nLocations: {}\ndefault-schema: {}", schemas, locations, defaultSchema);

        return FlywayConfiguration.builder()
                .schemas(schemas.split(","))
                .locations(locations.split(","))
                .defaultSchema(defaultSchema)
                .build();
    }
}
