package com.since.sincethird.service;

import com.since.sincethird.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBook();
    Book  findById(long id);

}
