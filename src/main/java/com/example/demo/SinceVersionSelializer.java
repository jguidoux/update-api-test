package com.example.demo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;


public class SinceVersionSelializer extends JsonSerializer<Integer> implements ContextualSerializer {



    private float sinceVersion = 0;
    private float restApiVersion = 1;

    public SinceVersionSelializer() {
    }

    public SinceVersionSelializer(float sinceVersion) {
        this.sinceVersion = sinceVersion;
    }

    @Override
    public void serialize(Integer value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException {
        if (sinceVersion >= restApiVersion) {
            serializers.defaultSerializeValue( value,gen);
        }

    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property)
            throws JsonMappingException {
        String unit = null;
        Since ann = null;
        if (property != null) {
            ann = property.getAnnotation(Since.class);
        }
        if (ann != null) {
            unit = ann.value();
        }
        float propertyVersion = getVersion(unit);
        return new SinceVersionSelializer(propertyVersion);
    }

    private float getVersion(String unit) {
        if (unit == null) {
            return  0;
        }
        try {
            return Float.valueOf(unit);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
