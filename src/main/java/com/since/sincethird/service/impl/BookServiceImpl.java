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
    public Boolean updateSetBookClick(Long bookNumb) {
        int flag=bookRep.updateSetBookClick(bookNumb);
        return  flag>0;


    }

    @Override
    public Book addClick(Long bookNumb){
        updateSetBookClick(bookNumb);
        return bookRep.findById(bookNumb).get();
    }

    @Override
    public List<Book> findAllByBookName(String bookName) {
        return null;
    }


}
