package com.since.sincethird.repository;

import com.since.sincethird.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author 王英豪111
 */
@Repository
public interface BookRep extends JpaRepository<Book,Long> {

    @Modifying
    @Query(value = "update book set Bookcount = (Bookcount - ?1) where Booknumb = ?2 and Bookcount = ?3", nativeQuery = true)
    int updateStock(Integer buyQuantity,int id,Integer oldValue);

    @Modifying
    @Query(value = "update book set Bookcount = (Bookcount + ?1) where Booknumb = ?2", nativeQuery = true)
    int addStock(Integer buyQuantity,Integer id);


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

    /**
     * 修改book库存
     */
    @Transactional
    @Modifying
    @Query(value = "update book set Bookclick=Bookclick+1 where Booknumb=?1",nativeQuery = true)
    Integer setBookClickAdd (Long Booknumb);

}
