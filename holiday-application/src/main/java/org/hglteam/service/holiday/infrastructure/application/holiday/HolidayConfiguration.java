package org.hglteam.service.holiday.infrastructure.application.holiday;

import org.hglteam.service.holiday.business.holiday.HolidayQueryBusiness;
import org.hglteam.service.holiday.business.method.HolidayCalculationMethodContext;
import org.hglteam.service.holiday.business.method.HolidayCalculatorBusiness;
import org.hglteam.service.holiday.control.easter.EasterCalculator;
import org.hglteam.service.holiday.control.holiday.HolidayQuery;
import org.hglteam.service.holiday.control.holiday.HolidayQueryJpa;
import org.hglteam.service.holiday.infrastructure.jpa.JpaConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class HolidayConfiguration {
    @PersistenceContext(unitName = JpaConfiguration.PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Bean
    public HolidayQuery holidayQuery() {
        return new HolidayQueryJpa(entityManager);
    }

    @Bean
    public HolidayCalculatorBusiness holidayCalculatorBusiness(HolidayCalculationMethodContext context) {
        return new HolidayCalculatorBusiness(context);
    }

    @Bean
    public HolidayQueryBusiness holidayQueryBusiness(
            HolidayCalculatorBusiness holidayCalculatorBusiness,
            HolidayQuery holidayQuery,
            EasterCalculator easterCalculator) {
        return new HolidayQueryBusiness(holidayCalculatorBusiness, holidayQuery, easterCalculator);
    }
}
