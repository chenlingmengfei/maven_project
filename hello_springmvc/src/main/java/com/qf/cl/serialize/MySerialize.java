package com.qf.cl.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/23
 */
public class MySerialize extends JsonSerializer<Double> {
    @Override
    public void serialize(Double aDouble, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String s = new BigDecimal(aDouble).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        jsonGenerator.writeString(s);
    }
}
