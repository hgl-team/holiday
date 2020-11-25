package org.hgl.service.holiday.infrastructure.jpa;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hgl.service.holiday.infrastructure.config.Parametrization;
import org.hgl.service.holiday.infrastructure.springboot.Application;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
public class FlywayConfiguration {
    public static final String SPRING_FLYWAY_SCHEMAS = "^spring\\.flyway\\.schemas.*";
    public static final String SPRING_FLYWAY_LOCATIONS = "^spring\\.flyway\\.locations.*";
    public static final String SPRING_FLYWAY_DEFAULT_SCHEMA = "spring.flyway.default-schema";
    public static final String SPRING_FLYWAY = "^spring\\.flyway.*";

    private String[] locations;
    private String[] schemas;
    private String defaultSchema;
}
