package com.qf.cl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: Department
 * Description:
 *
 * @author CL
 * @version 1.0
 * @date: 2020/6/17
 */
@Data
@NoArgsConstructor
public class Department {

    private Integer id;

    private String name;

    private String location;

    List<Employees> employeesList;

}
