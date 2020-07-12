package com.since.sincethird.repository;

import com.since.sincethird.entity.Book;
import com.since.sincethird.entity.WXUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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
     * 修改book库存
     */
    @Transactional
    @Modifying
    @Query(value = "update book set Bookclick=Bookclick+1 where Booknumb=?1",nativeQuery = true)
    Integer updateSetBookClick (Long Booknumb);

}
