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

    /**
     * 增加商品库存数量
     * @param bookCount 增加数量
     * @param id 增加书籍的主键
     * @return 更新行数
     */
    @Modifying
    @Query(value = "update book set Bookcount = (Bookcount + ?1) where Booknumb = ?2", nativeQuery = true)
    int addStock(Integer bookCount,Integer id);


    /**
     * 新增或更新书籍信息
     * @param book 书籍对象
     * @return 新增或更新后书籍对象
     */
    @Override
    Book save(Book book);


    /**
     * bookName模糊查询
     * @param bookname 书名
     * @return 满足书名条件的集合
     */
    @Query(value = "select * from book where Bookname like %?1% and Bookstatus = 1",nativeQuery = true)
    List<Book> findAllByBooknameLike(String bookname);

    /**
     * 更新book的点击量+1
     * @param booknumb 要更新书籍的主键
     * @return 更新行数
     */
    @Transactional
    @Modifying
    @Query(value = "update book set Bookclick=Bookclick+1 where Booknumb=?1",nativeQuery = true)
    Integer setBookClickAdd(Long booknumb);

}
