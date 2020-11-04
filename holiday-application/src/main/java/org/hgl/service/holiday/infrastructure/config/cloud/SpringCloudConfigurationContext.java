package org.hgl.service.holiday.infrastructure.config.cloud;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class SpringCloudConfigurationContext extends XmlWebApplicationContext {
    @Override
    protected ConfigurableEnvironment createEnvironment() {
        return new CloudConfigEnvironment();
    }
}
