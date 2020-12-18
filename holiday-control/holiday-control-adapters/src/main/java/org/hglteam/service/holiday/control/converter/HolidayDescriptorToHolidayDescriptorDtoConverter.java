package org.hglteam.service.holiday.control.converter;

import org.hglteam.convertion.api.TypeConverter;
import org.hglteam.service.holiday.model.domain.HolidayDescriptor;
import org.hglteam.service.holiday.model.dto.HolidayDescriptorDto;

public class HolidayDescriptorToHolidayDescriptorDtoConverter
    implements TypeConverter<HolidayDescriptor, HolidayDescriptorDto> {
    @Override
    public HolidayDescriptorDto convert(HolidayDescriptor holidayDescriptor) {
        return HolidayDescriptorDto.builder()
                .description(holidayDescriptor.getDescription())
                .date(holidayDescriptor.getDate())
                .build();
    }
}
