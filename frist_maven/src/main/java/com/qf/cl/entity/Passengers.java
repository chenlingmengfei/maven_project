package com.qf.cl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName: Passengers
 * Description:
 *
 * @author CL
 * @version 1.0
 * @date: 2020/6/17
 */
@Data
@NoArgsConstructor
public class Passengers {

    private Integer id;

    private String name;

    private String sex;

    private Date birthday;

    private Passports passports;


}
