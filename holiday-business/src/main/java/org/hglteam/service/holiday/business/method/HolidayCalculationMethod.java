package org.hglteam.service.holiday.business.method;

import java.time.LocalDate;

public interface HolidayCalculationMethod {
    LocalDate calculate(Integer year, String argument);
}
