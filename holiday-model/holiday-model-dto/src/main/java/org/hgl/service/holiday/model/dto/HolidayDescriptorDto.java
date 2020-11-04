package org.hgl.service.holiday.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class HolidayDescriptorDto {
    private String description;
    private LocalDate date;
}
