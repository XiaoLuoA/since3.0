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
     * @param wxList 微信订单信息
     * @return 微信订单
     */
    @Override
     WXList save(WXList wxList);


    /**
     * 通过订单状态查找全部订单
     * @param status 订单状态
     * @return 微信订单集合
     */
    List<WXList> findAllByStatus(int status);



    /**
     * 通过openid查找用户订单
     * @param openId 微信用户唯一标识
     * @return  微信订单集合
     */
    List<WXList> findAllByOpenId(String openId);


    /**
     * 通过订单号查找订单
     * @param no 订单号
     * @return 微信订单
     */
    WXList findByNo(String no);





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
