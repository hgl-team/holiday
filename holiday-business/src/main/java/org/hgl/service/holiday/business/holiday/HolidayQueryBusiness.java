package org.hgl.service.holiday.business.holiday;

import org.hgl.service.holiday.business.method.HolidayCalculatorBusiness;
import org.hgl.service.holiday.control.easter.EasterCalculator;
import org.hgl.service.holiday.control.holiday.HolidayQuery;
import org.hgl.service.holiday.model.domain.Holiday;
import org.hgl.service.holiday.model.domain.HolidayDescriptor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HolidayQueryBusiness {
    private final HolidayCalculatorBusiness holidayCalculatorBusiness;
    private final HolidayQuery holidayQuery;
    private final EasterCalculator easterCalculator;

    public HolidayQueryBusiness(HolidayCalculatorBusiness holidayCalculatorBusiness, HolidayQuery holidayQuery, EasterCalculator easterCalculator) {
        this.holidayCalculatorBusiness = holidayCalculatorBusiness;
        this.holidayQuery = holidayQuery;
        this.easterCalculator = easterCalculator;
    }

    public List<HolidayDescriptor> getForYear(String countryCode, Integer year) {
        List<Holiday> holidays = holidayQuery.getForCountry(countryCode);

        return holidays.stream()
                .map(this.calculateForYear(year))
                .filter(Objects::nonNull)
                .sorted(this::sortByDate)
                .collect(Collectors.toList());
    }

    private int sortByDate(HolidayDescriptor a, HolidayDescriptor b) {
        return a.getDate().compareTo(b.getDate());
    }

    private Function<Holiday, HolidayDescriptor> calculateForYear(Integer year) {
        return holiday -> HolidayDescriptor.builder()
                .description(holiday.getDescription())
                .date(holidayCalculatorBusiness.calculate(year, holiday.getMethod(), holiday.getArgument()))
                .build();
    }

    public LocalDate getEasterDay(Integer year) {
        return this.easterCalculator.forYear(year);
    }

    public boolean isHoliday(String countryCode, LocalDate localDate) {
        return getForYear(countryCode, localDate.getYear()).stream()
                .map(HolidayDescriptor::getDate)
                .anyMatch(localDate::equals);
    }
}
