package org.hglteam.service.holiday.control.holiday;

import org.hglteam.service.holiday.model.domain.Holiday;

import java.util.List;

public interface HolidayQuery {
    List<Holiday> getForCountry(String countryCode);
}
