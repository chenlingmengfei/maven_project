package com.qf.cl.mapper;

import com.qf.cl.entity.Book;

import java.util.List;

/**
 * ClassName: BookMapper
 * Description:
 *
 * @author CL
 * @version 1.0
 * @date: 2020/6/18
 */
public interface BookMapper {

    List<Book> selectBookByCondition(Book book);


    Integer updateBookByCondition(Book book);

    List<Book> queryAll(Integer[] array);
}
