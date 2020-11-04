package org.hgl.service.holiday.web.rest;

import org.hgl.convertion.api.Converter;
import org.hgl.service.holiday.business.holiday.HolidayQueryBusiness;
import org.hgl.service.holiday.model.domain.HolidayDescriptor;
import org.hgl.service.holiday.model.dto.HolidayDescriptorDto;
import org.hgl.service.holiday.model.dto.IsHolidayResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/holiday")
public class HolidayRS {
    private final HolidayQueryBusiness holidayQuery;
    private final Converter converter;

    @Autowired
    public HolidayRS(HolidayQueryBusiness holidayQuery, Converter converter) {
        this.holidayQuery = holidayQuery;
        this.converter = converter;
    }

    @GetMapping("/is-holiday")
    public IsHolidayResponseDto isHoliday(@RequestParam("countryCode") String countryCode, @RequestParam("date") String date) {
        var localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        var result = holidayQuery.isHoliday(countryCode, localDate);

        return IsHolidayResponseDto.builder()
                .date(localDate)
                .result(result)
                .build();
    }

    @GetMapping("/get")
    public List<HolidayDescriptorDto> getByCountryAndYear(
            @RequestParam("countryCode") String countryCode, @RequestParam("year") Integer year) {
        return holidayQuery.getForYear(countryCode, year).stream()
                .map(converter.convertTo(HolidayDescriptorDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/easter/get")
    public LocalDate getEasterDay(
            @RequestParam("year") Integer year) {
        return holidayQuery.getEasterDay(year);
    }

}
