package com.since.sincethird.repository;

import com.since.sincethird.entity.Book;
import com.since.sincethird.entity.WXUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王英豪111
 */
@Repository
public interface BookRep extends JpaRepository<Book,Long> {

    /**
     * 修改book库存
     * @param book
     * @return
     */
    @Override
    Book save(Book book);


    /**
     * bookName模糊查询
     * @param Bookname
     * @return
     */
    @Query(value = "select * from book where Bookname like %?1% and Bookstatus = 1",nativeQuery = true)
    List<Book> findAllByBooknameLike(String Bookname);


}
