package org.hglteam.service.holiday.control.converter;

import com.google.gson.Gson;
import org.hglteam.service.holiday.model.domain.FixedDateArgument;

public class JsonToFixedDateArgumentConverter extends JsonToTypeConverterBase<FixedDateArgument> {
    public JsonToFixedDateArgumentConverter(Gson gson) {
        super(FixedDateArgument.class, gson);
    }
}
