package org.hglteam.service.holiday.infrastructure.platform.jpa;

import org.flywaydb.core.Flyway;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class JpaConfiguration {
    private static final Logger log = LoggerFactory.getLogger(JpaConfiguration.class);
    public static final String PERSISTENCE_UNIT_NAME = "holidayPU";

    @Bean(initMethod = "migrate")
    @Primary
    @DependsOn("applicationDatasource")
    public Flyway flyway(
            FlywayConfiguration configuration,
            @Qualifier("applicationDatasource") DataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations(configuration.getLocations())
                .schemas(configuration.getSchemas())
                .defaultSchema(configuration.getDefaultSchema())
                .load();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("applicationDatasource") DataSource dataSource) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        Properties properties = new Properties();

        // Prevent Hibernate to make changes to tables by disabling ddl generation.
        //vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(dataSource);
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factory.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
        factory.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        factory.setJpaProperties(properties);
        return factory;
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
