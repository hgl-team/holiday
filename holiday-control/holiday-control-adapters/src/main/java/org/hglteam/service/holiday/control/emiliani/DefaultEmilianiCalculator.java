package org.hglteam.service.holiday.control.emiliani;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DefaultEmilianiCalculator implements EmilianiCalculator {
    @Override
    public LocalDate fromReferenceDate(LocalDate date) {
        var referenceDayOfWeek = date.getDayOfWeek();

        if(DayOfWeek.MONDAY.equals(referenceDayOfWeek)) {
            return date;
        } else {
            return date.plusDays(8 - referenceDayOfWeek.getValue());
        }
    }
}
