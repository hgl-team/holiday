package org.hglteam.service.holiday.model.converter;

import org.hglteam.service.holiday.model.domain.HolidayCalculationMethodName;

public class HolidayCalculationMethodNameConverter extends EnumConverterBase<HolidayCalculationMethodName, String> {
    protected HolidayCalculationMethodNameConverter() {
        super(HolidayCalculationMethodName::getCode, HolidayCalculationMethodName::getByCode);
    }
}
