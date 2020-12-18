package org.hglteam.service.holiday.model.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum HolidayCalculationMethodName {
    CO_FIXED_DATE("CO-FIXED_DATE"),
    CO_RELATIVE_TO_EASTER("CO-RELATIVE_TO_EASTER"),
    CO_EMILIANI("CO-EMILIANI")
    ;
    private final String code;

    private static final Map<String, HolidayCalculationMethodName> byCodeMap = Arrays.stream(HolidayCalculationMethodName.values())
                .collect(Collectors.toMap(HolidayCalculationMethodName::getCode, Function.identity()));

    public static HolidayCalculationMethodName getByCode(String value) {
        return byCodeMap.get(value);
    }
}
