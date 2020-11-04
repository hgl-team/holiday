package org.hgl.service.holiday.business.method;

import org.hgl.service.holiday.model.domain.HolidayCalculationMethodName;

import java.time.LocalDate;
import java.util.Optional;

public class HolidayCalculatorBusiness {
    private final HolidayCalculationMethodContext context;

    public HolidayCalculatorBusiness(HolidayCalculationMethodContext context) {
        this.context = context;
    }

    public LocalDate calculate(Integer year, HolidayCalculationMethodName methodName, String argument) {
        return Optional.of(methodName)
                .map(context::get)
                .map(method -> method.calculate(year, argument))
                .orElseThrow();
    }
}
