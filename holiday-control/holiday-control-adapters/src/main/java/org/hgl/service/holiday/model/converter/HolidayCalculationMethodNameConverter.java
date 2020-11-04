package org.hgl.service.holiday.model.converter;

import org.hgl.service.holiday.model.domain.HolidayCalculationMethodName;

import java.util.function.Function;

public class HolidayCalculationMethodNameConverter extends EnumConverterBase<HolidayCalculationMethodName, String> {
    protected HolidayCalculationMethodNameConverter() {
        super(HolidayCalculationMethodName::getCode, HolidayCalculationMethodName::getByCode);
    }
}
