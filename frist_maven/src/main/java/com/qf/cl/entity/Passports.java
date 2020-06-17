package com.qf.cl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName: Passports
 * Description:
 *
 * @author CL
 * @version 1.0
 * @date: 2020/6/17
 */
@Data
@NoArgsConstructor
public class Passports {

    private Integer id;

    private String nationality;

    private Date expire;

    private Passengers passengers;


}
