package com.since.sincethird.controller;
import com.since.sincethird.ret.BookResult;
import com.since.sincethird.ret.Ret;
import com.since.sincethird.entity.Book;
import com.since.sincethird.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author luoxinyuan
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/findAll")
    @ResponseBody
    public Ret findAllBook(){
        List<Book> bookList=bookService.findAllBook();
        return Ret.success(bookList);
    }

    @RequestMapping("/findBookById")
    @ResponseBody
    public Ret findBookById(Long id) {
        Book book;
        try{
            book = bookService.findById(id);
        }
        catch(NoSuchElementException e){
            return  Ret.error(BookResult.BOOK_NOT_FIND);
        }
        return Ret.success(book);
    }

        @RequestMapping("/addClick")
        @ResponseBody
        public Ret addClick(Long bookNumb) {
            Book book;
            try{
                book = bookService.addClick(bookNumb);
            }
           catch(NoSuchElementException e){
               return Ret.error(BookResult.BOOK_NOT_FIND);
           }
            return Ret.success(book);

    }

        @RequestMapping("/findAllByBookName")
        @ResponseBody
        public Ret findAllByBookName(String bookName){
        List<Book> bookList = bookService.findAllByBookName(bookName);
            Ret ret;
            if(bookName == null || "".equals(bookName)){
                ret = Ret.error(BookResult.BOOK_NOT_FIND);
                return ret;
            }
            return Ret.success(bookList);
        }

    }



