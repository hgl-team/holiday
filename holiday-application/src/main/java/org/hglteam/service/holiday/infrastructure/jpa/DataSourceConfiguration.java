package org.hglteam.service.holiday.infrastructure.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {
    private static final Logger log = LoggerFactory.getLogger(DataSourceConfiguration.class);

    @Bean("applicationDatasource")
    public DataSource dataSource (DataSourceInformation dataSourceInformation) throws NamingException {
        log.info("Datasource initialized: {}", dataSourceInformation);

        if(dataSourceInformation.isJndi()) {
            return (DataSource) InitialContext.doLookup(
                    dataSourceInformation.getJndiName());
        } else {
            return createDataSource(dataSourceInformation);
        }
    }

    public DataSource createDataSource(DataSourceInformation dataSourceInformation) {
        DriverManagerDataSource datasource = new DriverManagerDataSource();

        datasource.setDriverClassName(dataSourceInformation.getDriverClassName());
        datasource.setUrl(dataSourceInformation.getUrl());
        datasource.setUsername(dataSourceInformation.getUsername());
        datasource.setPassword(dataSourceInformation.getPassword());

        return datasource;
    }
}
