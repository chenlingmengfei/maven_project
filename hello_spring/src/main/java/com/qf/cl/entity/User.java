package com.qf.cl.entity;

import lombok.Data;

import java.util.*;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/19
 */
@Data
public class User {
    private Integer id;
    private String password;
    private String sex;
    private Integer age;
    private Date bornDate;
    private String[] hobbys;
    private Set<String> phones;
    private List<String> names;
    private Map<String,String> countries;
    private Properties files;
}
