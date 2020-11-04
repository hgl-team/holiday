package org.hgl.service.holiday.control.holiday;

import org.hgl.service.holiday.model.domain.Holiday;

import java.util.List;

public interface HolidayQuery {
    List<Holiday> getForCountry(String countryCode);
}
