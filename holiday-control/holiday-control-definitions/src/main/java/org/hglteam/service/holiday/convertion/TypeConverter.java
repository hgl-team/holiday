package org.hglteam.service.holiday.convertion;

public interface TypeConverter<TS, TD> {
    TD convert(TS source);
}
