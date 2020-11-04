package org.hgl.service.holiday.business.method;

import org.hgl.service.holiday.model.domain.HolidayCalculationMethodName;

import java.util.HashMap;
import java.util.Map;

public class HolidayCalculationMethodContext {
    private final Map<HolidayCalculationMethodName, HolidayCalculationMethod> calculationMethodMap;

    public HolidayCalculationMethodContext() {
        this.calculationMethodMap = new HashMap<>();
    }

    public HolidayCalculationMethodContext register(HolidayCalculationMethodName methodName, HolidayCalculationMethod calculationMethod) {
        this.calculationMethodMap.put(methodName, calculationMethod);
        return this;
    }

    public HolidayCalculationMethod get(HolidayCalculationMethodName methodName) {
        return calculationMethodMap.get(methodName);
    }
}
