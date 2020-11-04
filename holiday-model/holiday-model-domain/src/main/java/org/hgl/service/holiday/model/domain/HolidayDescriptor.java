package org.hgl.service.holiday.model.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class HolidayDescriptor {
    private String description;
    private LocalDate date;
}
