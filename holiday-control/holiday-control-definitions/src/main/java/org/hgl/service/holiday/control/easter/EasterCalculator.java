package org.hgl.service.holiday.control.easter;

import java.time.LocalDate;

public interface EasterCalculator {
    LocalDate forYear(Integer year);
}
