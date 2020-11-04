package org.hgl.service.holiday.control.holiday;

import org.hgl.service.holiday.model.domain.Holiday;

import javax.persistence.EntityManager;
import java.util.List;

public class HolidayQueryJpa implements HolidayQuery {
    public static final String HOLIDAY_GET_FOR_COUNTRY = "Holiday.getForCountry";
    public static final String PARAMETER_COUNTRY_CODE = "pCountryCode";
    private final EntityManager entityManager;

    public HolidayQueryJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Holiday> getForCountry(String countryCode) {
        return entityManager.createNamedQuery(HOLIDAY_GET_FOR_COUNTRY, Holiday.class)
                .setParameter(PARAMETER_COUNTRY_CODE, countryCode)
                .getResultList();
    }
}
