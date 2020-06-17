package com.qf.cl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * ClassName: Employees
 * Description:
 *
 * @author CL
 * @version 1.0
 * @date: 2020/6/17
 */
@Data
@NoArgsConstructor
public class Employees {

    private Integer id;

    private String name;

    private BigDecimal salary;

    private Department department;

}
