package com.qf.cl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer id;

    private String name;

    private String author;

    private String publish;

    private String sort;

}
