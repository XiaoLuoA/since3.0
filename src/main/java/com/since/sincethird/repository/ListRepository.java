package com.since.sincethird.repository;

import com.since.sincethird.entity.Book;
import com.since.sincethird.entity.WXList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王英豪111
 */
@Repository
public interface ListRepository extends JpaRepository<WXList,Long> {


    /**
     * 添加一条订单
     * @param wxList
     * @return
     */
    @Override
     WXList save(WXList wxList);



    /**
     * 通过openid查找用户订单
     * @param open_id
     * @return
     */
    List<WXList> findAllByOpenId(String open_id);


    /**
     * 通过订单id查找订单
     * @param id
     * @return
     */

    WXList findWXListById(Long id);




}
