package com.qf.cl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName: User
 * Description:
 *
 * @author CL
 * @version 1.0
 * @date: 2020/6/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    private Integer id;

    private String name;

    private String password;

    private String sex;

    private Date birthday;

    private Date registTime;

}
