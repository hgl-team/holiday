package org.hgl.service.holiday.control.converter;

import com.google.gson.Gson;
import org.hgl.service.holiday.model.domain.COEmilianiArgument;
import org.hgl.service.holiday.model.domain.CORelativeToEasterArgument;

public class JsonToEmilianiArgumentConverter extends JsonToTypeConverterBase<COEmilianiArgument> {
    public JsonToEmilianiArgumentConverter(Gson gson) {
        super(COEmilianiArgument.class, gson);
    }
}
