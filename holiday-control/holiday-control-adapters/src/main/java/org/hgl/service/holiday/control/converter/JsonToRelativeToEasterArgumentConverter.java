package org.hgl.service.holiday.control.converter;

import com.google.gson.Gson;
import org.hgl.service.holiday.model.domain.CORelativeToEasterArgument;
import org.hgl.service.holiday.model.domain.FixedDateArgument;

public class JsonToRelativeToEasterArgumentConverter extends JsonToTypeConverterBase<CORelativeToEasterArgument> {
    public JsonToRelativeToEasterArgumentConverter(Gson gson) {
        super(CORelativeToEasterArgument.class, gson);
    }
}
