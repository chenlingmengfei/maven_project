package com.qf.cl.mapper;

import com.qf.cl.entity.Department;

/**
 * ClassName: EmployeesMapper
 * Description:
 *
 * @author CL
 * @version 1.0
 * @date: 2020/6/17
 */
public interface DepartmentMapper {

    Department selectDepartmentById(Integer id);

}
