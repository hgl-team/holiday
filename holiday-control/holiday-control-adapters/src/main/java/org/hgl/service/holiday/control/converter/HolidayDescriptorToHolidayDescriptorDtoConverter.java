package org.hgl.service.holiday.control.converter;

import org.hgl.convertion.api.TypeConverter;
import org.hgl.service.holiday.model.domain.HolidayDescriptor;
import org.hgl.service.holiday.model.dto.HolidayDescriptorDto;

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
