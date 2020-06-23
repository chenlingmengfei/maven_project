package com.qf.cl.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qf.cl.serialize.MyFastJsonSerialize;
import com.qf.cl.serialize.MySerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer id;

    //@JsonProperty("NAME") //自定义属性名
    @JSONField(name = "NAME")
    private String name;

    private String author;

    //@JsonIgnore             //忽略
    @JSONField(serialize = false)
    private String publish;

    //@JsonInclude(JsonInclude.Include.NON_NULL)  //jackson中null为进行忽略，fastjson是null为""
    @JSONField(serialzeFeatures = SerializerFeature.WriteNullStringAsEmpty)
    private String sort;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")    //格式化输出时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birth;

    //@JsonSerialize(using = MySerialize.class)       //自定义序列规则
    @JSONField(serializeUsing = MyFastJsonSerialize.class)
    private Double price;
}
