package com.qf.cl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: Student
 * Description:
 *
 * @author CL
 * @version 1.0
 * @date: 2020/6/17
 */
@Data
@NoArgsConstructor
public class Student {

    private Integer id;

    private String name;

    private String sex;

    private List<Subject> subjectList;
}
