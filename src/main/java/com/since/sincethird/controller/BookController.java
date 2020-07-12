package com.since.sincethird.controller;


import com.since.sincethird.ret.BookResult;
import com.since.sincethird.ret.Result;
import com.since.sincethird.ret.Ret;
import com.since.sincethird.entity.Book;
import com.since.sincethird.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.NoSuchElementException;

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
    public Ret findBookById(Long id) {
        Book book = bookService.findById(id);

        if (book != null) {
            Ret ret = new Ret(Result.SUCCESS, book);
            return ret;
        } else {
            Ret ret = new Ret(BookResult.Book_NOT_FIND, book);
            return ret;
        }
    }

        @RequestMapping("/addClick")
        @ResponseBody
        public Ret addClick(Long bookNumb) {
            Book book=null;
            try{
                book = bookService.addClick(bookNumb);
            }
           catch(NoSuchElementException e){
               Ret ret = new Ret(BookResult.Book_NOT_FIND, book);
               return ret;
           }
            Ret ret = new Ret(Result.SUCCESS, book);
            return ret;


        }
}
