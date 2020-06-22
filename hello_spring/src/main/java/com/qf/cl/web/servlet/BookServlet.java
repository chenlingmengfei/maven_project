package com.qf.cl.web.servlet;

import com.github.pagehelper.PageInfo;
import com.qf.cl.entity.Book;
import com.qf.cl.entity.DataInfo;
import com.qf.cl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/21
 */
@Controller
public class BookServlet extends BaseServlet{

    @Autowired
    private BookService bookService;

    //查询所有书籍
    public void showBook(HttpServletResponse response,HttpServletRequest request){

        String pagenum = request.getParameter("pagenum");
        PageInfo<Book> bookPageInfo = bookService.selectPageInfo(Integer.parseInt(pagenum));

        //List<Book> books = bookService.selectBookList();
        sendJson(bookPageInfo,response);
    }

    //删除书籍
    public void deleteBook(Integer id, HttpServletResponse response){
        Integer integer = bookService.deleteBookById(id);
        DataInfo data = new DataInfo();
        if(integer == 1){
            data.setStatus(1);
            data.setInfo("delete success");
        }else {
            data.setStatus(0);
            data.setInfo("delete failure");
        }
        sendJson(data,response);
    }

    //添加书籍
    public void addBook(Book book,HttpServletResponse response){
        Integer integer = bookService.addBook(book);
        DataInfo data = new DataInfo();
        if(integer == 1){
            data.setStatus(1);
            data.setInfo("add success");
        }else {
            data.setStatus(0);
            data.setInfo("add failure");
        }
        sendJson(data,response);
    }


    //查找书籍
    public void findBook(String bookname, HttpServletResponse response, HttpServletRequest request){

        List<Book> books = bookService.selectBookByName(bookname);

        sendJson(books,response);
    }

    //修改书籍
    public void updateBook(Book book,HttpServletResponse response){
        Integer integer = bookService.UpdateBookById(book);
        DataInfo data = new DataInfo();
        if(integer == 1){
            data.setStatus(1);
            data.setInfo("update success");
        }else {
            data.setStatus(0);
            data.setInfo("update failure");
        }
        sendJson(data,response);
    }
}
