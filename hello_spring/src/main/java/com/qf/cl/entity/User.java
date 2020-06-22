package com.qf.cl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private Integer id;

    private String name;

    private String password;

    private String sex;

    private Date birthday;

    private Date registTime;
}
