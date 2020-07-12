package com.since.sincethird.service;

import com.since.sincethird.entity.Book;

import java.util.List;

/**
 * @author 王英豪111
 */
public interface BookService {

    /**
     * 查找全部book
     * @return
     */
    List<Book> findAllBook();

    /**
     * 通过id查找
     * @param id
     * @return
     */
    Book  findById(Long id);


    /**
     * 修改book库存
     * @param book
     * @return
     */
    Book save(Book book);


    /** drj
     * 查找Book,点击+1
     * @param bookNumb
     * @return int
     */
    Integer updateSetBookClick(Long bookNumb);

    /** drj
     * 查找Book,点击+1
     * @param bookNumb
     * @return Book
     */
    Book addClick (Long bookNumb);

}
