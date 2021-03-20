package org.hglteam.service.holiday.infrastructure.config.cloud;

import org.hglteam.config.remote.RemoteConfiguration;
import org.hglteam.service.holiday.infrastructure.YAMLPropertySourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.retry.support.RetryTemplate;

import java.io.IOException;

@Configuration(proxyBeanMethods = false)
public class ConfiguracionRemota {

    @Bean
    public static PropertySource<?> bootstrapPropertySource(ConfigurableEnvironment env) {
        try {
            var resource = new ClassPathResource("bootstrap.yml");
            var r = new EncodedResource(resource);
            var ps = new YAMLPropertySourceFactory()
                    .createPropertySource("bootstrap", r);

            env.getPropertySources().addFirst(ps);
            return ps;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Bean("remoteConfigRetryTemplate")
    public static RetryTemplate remoteConfigRetryInterceptor(Environment e) {
        int initialInterval = e.getProperty("config.remote.retry-template.initial-interval", Integer.class, 1000);
        int maxInterval = e.getProperty("config.remote.retry-template.max-interval", Integer.class, 10000);
        double multiplier = e.getProperty("config.remote.retry-template.multiplier", Double.class, 1.6);
        int attempts = e.getProperty("config.remote.retry-template.max-attemps", Integer.class, 5);

        return RetryTemplate.builder()
                .exponentialBackoff(initialInterval, multiplier, maxInterval)
                .maxAttempts(attempts)
                .build();
    }

    @Configuration
    @Import({ RemoteConfiguration.class })
    public static class InstanceRemoteConfiguration {
    }
}
