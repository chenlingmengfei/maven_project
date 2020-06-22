package com.qf.cl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.cl.dao.BookMapper;
import com.qf.cl.entity.Book;
import com.qf.cl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/21
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> selectBookList() {
        return bookMapper.selectBookList();
    }

    public PageInfo<Book> selectPageInfo(Integer pagenum){
        if(null == pagenum || 0 == pagenum){
            PageHelper.startPage(1,2);
        }else{
            PageHelper.startPage(pagenum,2);
        }

        List<Book> books = selectBookList();

        PageInfo<Book> pageInfo = new PageInfo(books);

        return pageInfo;
    }

    @Override
    public List<Book> selectBookByName(String bookname) {
        return bookMapper.selectBookByName(bookname);
    }

    @Override
    public Integer addBook(Book book) {
        return bookMapper.insertBook(book);
    }

    @Override
    public Integer deleteBookById(Integer id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public Integer UpdateBookById(Book book) {
        return bookMapper.updateBook(book);
    }

}
