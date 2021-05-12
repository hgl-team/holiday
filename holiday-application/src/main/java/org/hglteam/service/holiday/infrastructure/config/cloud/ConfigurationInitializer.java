package org.hglteam.service.holiday.infrastructure.config.cloud;

import org.hglteam.service.holiday.infrastructure.YAMLPropertySourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ConfigurationInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final Logger log = LoggerFactory.getLogger(ConfigurationInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ClassPathResource resource = new ClassPathResource("bootstrap.yml");
        EncodedResource r = new EncodedResource(resource);

        try {
            var sources = applicationContext.getEnvironment().getPropertySources();
            sources.addLast(new YAMLPropertySourceFactory().createPropertySource("bootstrap", r));

            log.debug("Property sources:{}{}", System.lineSeparator(), sources.stream()
                    .map(this::propertySourceToString)
                    .collect(Collectors.joining(System.lineSeparator())));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private String propertySourceToString(PropertySource<?> propertySource) {
        var about = String.format("- %s [%s]", propertySource.getName(), propertySource.getClass().getSimpleName());

        if(propertySource instanceof EnumerablePropertySource) {
            var enumerableSource = (EnumerablePropertySource<?>) propertySource;
            about = about + System.lineSeparator() + Arrays.stream(enumerableSource.getPropertyNames())
                    .map(key -> String.format("\t %s: %s", key, enumerableSource.getProperty(key)))
                    .collect(Collectors.joining(System.lineSeparator()));
        }

        return about;
    }
}
