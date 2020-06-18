package com.qf.cl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: Book
 * Description:
 *
 * @author CL
 * @version 1.0
 * @date: 2020/6/18
 */
@Data
@NoArgsConstructor
public class Book {

    private Integer id;

    private String name;

    private String author;

    private String publish;

    private String sort;

}
