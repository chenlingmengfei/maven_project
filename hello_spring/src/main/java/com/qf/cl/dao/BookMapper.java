package com.qf.cl.dao;

import com.qf.cl.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/21
 */
public interface BookMapper {

    //查询所有书籍
    List<Book> selectBookList();

    //书名模糊查询
    List<Book> selectBookByName(@Param("name") String name);

    //添加书籍
    Integer insertBook(Book book);

    //删除书籍
    Integer deleteBookById(Integer id);

    //修改书籍
    Integer updateBook(Book book);

}
