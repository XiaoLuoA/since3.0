package com.since.sincethird.controller;


import com.since.sincethird.common.BookResult;
import com.since.sincethird.common.Result;
import com.since.sincethird.common.Ret;
import com.since.sincethird.entity.Book;
import com.since.sincethird.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/findAll")
    @ResponseBody
    public Ret findAllBook(){
        List<Book> bookList=bookService.findAllBook();
        Ret ret = new Ret(Result.SUCCESS, bookList);
        return ret;

    }

    @RequestMapping("/findBookById")
    @ResponseBody
    public Ret findBookById(Long id){
        Book book=bookService.findById(id);

        if(book!=null){
            Ret ret = new Ret(Result.SUCCESS, book);
            return ret;
        }else{
            Ret ret = new Ret(BookResult.NOT_FIND_ERROR, book);
            return ret;
        }



    }


}