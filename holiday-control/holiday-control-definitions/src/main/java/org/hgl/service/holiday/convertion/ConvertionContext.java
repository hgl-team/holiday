package org.hgl.service.holiday.convertion;

public interface ConvertionContext {
    public <TS, TD> TypeConverter<TS, TD> resolve(Class<TS> sourceClass, Class<TD> destinationClass);
    ConvertionContext register(TypeConverter<?,?> converter);
}
