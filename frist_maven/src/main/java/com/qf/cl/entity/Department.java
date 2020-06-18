package com.qf.cl.entity;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Department {

    private Integer id;

    private String name;

    private String location;

    List<Employees> employeesList;

}
