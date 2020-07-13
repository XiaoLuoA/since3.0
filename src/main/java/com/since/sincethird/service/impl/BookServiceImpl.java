package com.since.sincethird.service.impl;

import com.since.sincethird.common.Status;
import com.since.sincethird.entity.Book;
import com.since.sincethird.exception.NoBookException;
import com.since.sincethird.repository.BookRep;
import com.since.sincethird.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean updateStock(Integer book_id, Integer listNum) {
        Book book = findById(book_id.longValue());
        int stock_num = book.getBookcount() - listNum;
        if (stock_num < 0){
            throw new NoBookException();
        } else if(stock_num == 0){
            book.setBookstatus(Status.BOOK_EMPTY);
        }
        //修改book库存
        book.setBookcount(stock_num);
        save(book);
        return true;
    }

    @Override
    public boolean updateStock(Integer buyQuantity, Integer id, Integer oldValue) {
        return false;
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


}
