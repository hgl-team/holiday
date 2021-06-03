package org.hglteam.service.holiday.infrastructure.platform.jpa;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
