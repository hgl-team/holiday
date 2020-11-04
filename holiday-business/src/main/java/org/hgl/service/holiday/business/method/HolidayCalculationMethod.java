package org.hgl.service.holiday.business.method;

import java.time.LocalDate;

public interface HolidayCalculationMethod {
    LocalDate calculate(Integer year, String argument);
}
