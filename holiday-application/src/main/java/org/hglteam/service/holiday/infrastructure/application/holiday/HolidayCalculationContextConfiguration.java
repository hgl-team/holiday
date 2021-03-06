package org.hglteam.service.holiday.infrastructure.application.holiday;

import org.hglteam.convertion.api.Converter;
import org.hglteam.service.holiday.business.method.HolidayCalculationMethod;
import org.hglteam.service.holiday.business.method.HolidayCalculationMethodContext;
import org.hglteam.service.holiday.business.method.implementation.COEmilianiMethod;
import org.hglteam.service.holiday.business.method.implementation.CORelativeToEasterMethod;
import org.hglteam.service.holiday.business.method.implementation.FixedDateMethod;
import org.hglteam.service.holiday.control.easter.EasterCalculator;
import org.hglteam.service.holiday.control.emiliani.EmilianiCalculator;
import org.hglteam.service.holiday.model.domain.HolidayCalculationMethodName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HolidayCalculationContextConfiguration {
    private final HolidayCalculationMethodContext calculationMethodContext = new HolidayCalculationMethodContext();
    private final Converter converter;

    public HolidayCalculationContextConfiguration(Converter converter) {
        this.converter = converter;
    }

    @Bean
    public HolidayCalculationMethodContext holidayCalculationMethodContext() {
        return this.calculationMethodContext;
    }

    @Bean
    public FixedDateMethod colFixedDateMethod() {
        return register(HolidayCalculationMethodName.CO_FIXED_DATE, new FixedDateMethod(converter));
    }

    @Bean
    public CORelativeToEasterMethod colRelativeToEaster(EasterCalculator easterCalculator, EmilianiCalculator emilianiCalculator) {
        return register(HolidayCalculationMethodName.CO_RELATIVE_TO_EASTER, new CORelativeToEasterMethod(
                converter, easterCalculator, emilianiCalculator));
    }

    @Bean
    public COEmilianiMethod coEmilianiMethod(EmilianiCalculator emilianiCalculator) {
        return register(HolidayCalculationMethodName.CO_EMILIANI, new COEmilianiMethod(
                converter, emilianiCalculator));
    }

    private <T extends HolidayCalculationMethod> T register(HolidayCalculationMethodName methodName, T method) {
        calculationMethodContext.register(methodName, method);
        return method;
    }

}
