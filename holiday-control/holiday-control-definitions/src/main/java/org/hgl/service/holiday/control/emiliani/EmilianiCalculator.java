package org.hgl.service.holiday.control.emiliani;

import java.time.LocalDate;

public interface EmilianiCalculator {
    LocalDate fromReferenceDate(LocalDate date);
}
