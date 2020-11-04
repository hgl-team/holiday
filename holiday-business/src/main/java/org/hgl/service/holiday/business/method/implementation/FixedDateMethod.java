package org.hgl.service.holiday.business.method.implementation;

import org.hgl.convertion.api.Converter;
import org.hgl.service.holiday.business.method.HolidayCalculationMethod;
import org.hgl.service.holiday.model.domain.FixedDateArgument;

import java.time.LocalDate;

public class FixedDateMethod implements HolidayCalculationMethod {
    private final Converter converter;

    public FixedDateMethod(Converter converter) {
        this.converter = converter;
    }

    @Override
    public LocalDate calculate(Integer year, String argument) {
        var fixedDateArg = converter.convert(argument, FixedDateArgument.class);
        return fixedDateArg.getDate().withYear(year);
    }
}
