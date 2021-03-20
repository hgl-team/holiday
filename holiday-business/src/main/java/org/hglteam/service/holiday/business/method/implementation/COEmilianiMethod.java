package org.hglteam.service.holiday.business.method.implementation;

import org.hglteam.convertion.api.Converter;
import org.hglteam.service.holiday.business.method.HolidayCalculationMethod;
import org.hglteam.service.holiday.control.emiliani.EmilianiCalculator;
import org.hglteam.service.holiday.model.domain.COEmilianiArgument;

import java.time.LocalDate;

public class COEmilianiMethod implements HolidayCalculationMethod {
    private final Converter converter;
    private final EmilianiCalculator emilianiCalculator;

    public COEmilianiMethod(Converter converter, EmilianiCalculator emilianiCalculator) {
        this.converter = converter;
        this.emilianiCalculator = emilianiCalculator;
    }

    @Override
    public LocalDate calculate(Integer year, String argument) {
        var emilianiArg = converter.convert(argument, COEmilianiArgument.class);

        return emilianiCalculator.fromReferenceDate(emilianiArg
                .getReferenceDate()
                .withYear(year));
    }
}
