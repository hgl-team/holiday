package org.hglteam.service.holiday.business.method.implementation;

import org.hglteam.convertion.api.Converter;
import org.hglteam.service.holiday.business.method.HolidayCalculationMethod;
import org.hglteam.service.holiday.control.easter.EasterCalculator;
import org.hglteam.service.holiday.control.emiliani.EmilianiCalculator;
import org.hglteam.service.holiday.model.domain.CORelativeToEasterArgument;

import java.time.LocalDate;

public class CORelativeToEasterMethod implements HolidayCalculationMethod {
    private final Converter converter;
    private final EasterCalculator easterCalculator;
    private final EmilianiCalculator emilianiCalculator;

    public CORelativeToEasterMethod(Converter converter, EasterCalculator easterCalculator, EmilianiCalculator emilianiCalculator) {
        this.converter = converter;
        this.easterCalculator = easterCalculator;
        this.emilianiCalculator = emilianiCalculator;
    }

    @Override
    public LocalDate calculate(Integer year, String argument) {
        var relativeToEasterArg = converter.convert(argument, CORelativeToEasterArgument.class);
        var easterDay = easterCalculator.forYear(year);
        var referenceDay = easterDay.plusDays(relativeToEasterArg.getDaysAfterEaster());

        return Boolean.TRUE.equals(relativeToEasterArg.getApplyEmiliany()) ?
                emilianiCalculator.fromReferenceDate(referenceDay) : referenceDay;
    }
}
