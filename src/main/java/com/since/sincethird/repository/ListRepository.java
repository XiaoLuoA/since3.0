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
     * 通过openid查找用户订单
     * @param open_id
     * @return
     */
    List<WXList> findAllByOpenId(String open_id);


    /**
     * 
     * @param no
     * @return
     */
    WXList findByNo(String no);


    /**
     * 通过订单id查找订单
     * @param id 订单主键id
     * @return 查找出的订单对象
     */
    WXList findWXListById(Long id);


    /**
     * 更新订单状态
     * @param no 要更新订单的订单号
     * @param status 目标订单状态
     * @return 更新行数
     */
    @Transactional
    @Modifying
    @Query(value = "update wx_list set status=?2 where no=?1",nativeQuery = true)
    Integer updateStatus(String no, Integer status);
}
