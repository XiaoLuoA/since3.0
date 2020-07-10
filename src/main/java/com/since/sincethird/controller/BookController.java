package com.since.sincethird.controller;


import com.since.sincethird.common.BookResult;
import com.since.sincethird.common.Ret;
import com.since.sincethird.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/findAll")
    @ResponseBody
    public Ret findAllBook(){
        Ret ret = new Ret(BookResult.Book_SUCCESS, bookService.findAllBook());
        return ret;

    }

    @RequestMapping("/findBookById")
    @ResponseBody
    public Ret findBookById(long id){
        Ret ret = new Ret(BookResult.Book_SUCCESS, bookService.findById(id));
        return ret;

    }


}
