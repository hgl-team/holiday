package org.hgl.service.holiday.infrastructure.config.cloud;

import org.hgl.service.holiday.infrastructure.YAMLPropertySourceFactory;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.web.context.support.StandardServletEnvironment;

import java.io.IOException;

public class CloudConfigEnvironment extends StandardServletEnvironment {

    @Override
    protected void customizePropertySources(MutablePropertySources propertySources) {
        super.customizePropertySources(propertySources);
        this.locateConfigPropertySource(propertySources);
    }

    private void locateConfigPropertySource(MutablePropertySources propertySources) {
        try {
            readBootstrapConfiguration(propertySources);
        } catch (IOException e) {
            System.out.println("Error reading application configuration from server...");
            e.printStackTrace();
        }
    }

    private void readBootstrapConfiguration(MutablePropertySources propertySources) throws IOException {
        System.out.println("Reading bootstrap configuration...");
        var bootstrapPropertySource = new YAMLPropertySourceFactory()
                .createPropertySource(null, new EncodedResource(new ClassPathResource("bootstrap.yml")));
        propertySources.addLast(bootstrapPropertySource);
    }
}
