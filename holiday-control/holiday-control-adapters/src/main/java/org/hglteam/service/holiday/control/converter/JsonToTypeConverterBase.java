package org.hglteam.service.holiday.control.converter;

import com.google.gson.Gson;
import org.hglteam.convertion.api.TypeConverter;

public abstract class JsonToTypeConverterBase<T> implements TypeConverter<String, T> {
    private final Class<T> aClass;
    private final Gson gson;

    public JsonToTypeConverterBase(Class<T> aClass, Gson gson) {
        this.aClass = aClass;
        this.gson = gson;
    }

    @Override
    public T convert(String source) {
        return gson.fromJson(source, aClass);
    }
}
