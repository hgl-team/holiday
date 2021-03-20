package org.hglteam.service.holiday.infrastructure.web.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.function.Function;

public class AdaptadorEnumeradorBase<T extends Enum<T>> extends TypeAdapter<T> {
    private final Function<T, String> funcionSerializadora;
    private final Function<String, T> funcionDeserializadora;

    public AdaptadorEnumeradorBase(Function<T, String> funcionSerializadora, Function<String, T> funcionDeserializadora) {
        this.funcionSerializadora = funcionSerializadora;
        this.funcionDeserializadora = funcionDeserializadora;
    }

    @Override
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        jsonWriter.value(funcionSerializadora.apply(t));
    }

    @Override
    public T read(JsonReader jsonReader) throws IOException {
        return funcionDeserializadora.apply(jsonReader.nextString());
    }
}
