package com.since.sincethird.service.impl;

import com.since.sincethird.entity.Book;
import com.since.sincethird.repository.BookRep;
import com.since.sincethird.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王英豪111
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRep bookRep;
    @Override
    public List<Book> findAllBook() {
        return bookRep.findAll();
    }


    @Override
    public Book findById(Long id) {
        return bookRep.findById(id).get();
    }

    @Override
    public Book save(Book book) {
        return bookRep.save(book);
    }

    @Override
    public Book addClick(Long bookNumb) {
        Book  book =findById(bookNumb);
        book.setBookclick((book.getBookclick()+1));
        save(book);
        return  book;
    }

    @Override
    public List<Book> findAllByBookName(String bookName) {

        List<Book> bookList =  bookRep.findAllByBooknameLike(bookName);
        return bookList;
    }


}
