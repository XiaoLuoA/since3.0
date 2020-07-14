package com.since.sincethird.repository;

import com.since.sincethird.entity.WXList;
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
public interface ListRepository extends JpaRepository<WXList,Long> {


    /**
     * 添加一条订单
     * @param wxList
     * @return
     */
    @Override
     WXList save(WXList wxList);


    /**
     * 通过订单状态查找全部订单
     * @param status
     * @return
     */
    List<WXList> findAllByStatus(int status);



    /**
     * 通过openid查找用户订单
     * @param open_id
     * @return
     */
    List<WXList> findAllByOpenId(String open_id);


    WXList findByNo(String no);
    /**
     * 通过订单id查找订单
     * @param id
     * @return
     */

    WXList findWXListById(Long id);

    @Transactional
    @Modifying
    @Query(value = "update wx_list set status=?2 where no=?1",nativeQuery = true)
    Integer updateStatus(String no, Integer status);
}
