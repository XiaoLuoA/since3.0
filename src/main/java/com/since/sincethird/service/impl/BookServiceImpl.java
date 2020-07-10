package com.since.sincethird.service.impl;

import com.since.sincethird.entity.Book;
import com.since.sincethird.repository.BookRep;
import com.since.sincethird.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRep BookRep;
    @Override
    public List<Book> findAllBook() {
        return BookRep.findAll();
    }


    @Override
    public Book findById(long id) {
        return BookRep.findById(id).get();
    }
}
