package com.qf.cl.serialize;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/23
 */
public class MyFastJsonSerialize implements ObjectSerializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object value, Object o1, Type type, int i) throws IOException {
        Double num = (Double) value;
        String string = value+"元";
        jsonSerializer.write(string);
    }
}
