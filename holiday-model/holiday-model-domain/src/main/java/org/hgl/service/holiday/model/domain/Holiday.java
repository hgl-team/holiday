package org.hgl.service.holiday.model.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Holiday {
    private Integer id;
    private String description;
    private String countryCode;
    private HolidayCalculationMethodName method;
    private String argument;
    private Boolean active;
}
