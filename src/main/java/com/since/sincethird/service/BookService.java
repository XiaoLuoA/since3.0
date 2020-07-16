package com.since.sincethird.service;

import com.since.sincethird.entity.Book;
import com.since.sincethird.repository.BookRep;

import java.util.List;

/**
 * @author 王英豪111
 */
public interface BookService {


    boolean updateStock(Integer book_id, Integer listNum);
    boolean updateStock(Integer buyQuantity, Integer id, Integer oldValue);

    /**
     *
     * @param buyQuantity 書的數量
     * @param id 書籍的id
     * @return
     */
    boolean addStock(Integer buyQuantity,Integer id);
    /**
     * @author drj
     * 查找全部book
     * @return List<Book>
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

    /**
     * @author drj
     * 查找Book,Set点击+1的前置方法
     * @param bookNumb
     * @return Boolean
     */
    Boolean setBookClickAdd(Long bookNumb);

    /**
     * @author drj
     * 查找Book,点击+1
     * @param bookNumb
     * @return Book
     */
    Book addClick(Long bookNumb);



    /**
     * bookName模糊查询
     * @param bookName
     * @return
     */
    List<Book> findAllByBookName(String bookName);

}
