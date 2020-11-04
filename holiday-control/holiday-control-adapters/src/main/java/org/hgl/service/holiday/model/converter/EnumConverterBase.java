package org.hgl.service.holiday.model.converter;

import javax.persistence.AttributeConverter;
import java.util.Optional;
import java.util.function.Function;

public abstract class EnumConverterBase<TS extends Enum<TS>, TD> implements AttributeConverter<TS, TD> {

    private final Function<TS, TD> columnMapper;
    private final Function<TD, TS> typeMapper;

    protected EnumConverterBase(Function<TS, TD> columnMapper, Function<TD, TS> typeMapper) {
        this.columnMapper = columnMapper;
        this.typeMapper = typeMapper;
    }

    @Override
    public TD convertToDatabaseColumn(TS t) {
        return Optional.ofNullable(t)
                .map(columnMapper)
                .orElse(null);
    }

    @Override
    public TS convertToEntityAttribute(TD td) {
        return Optional.ofNullable(td)
                .map(typeMapper)
                .orElse(null);
    }
}
