package com.since.sincethird.repository;

import com.since.sincethird.entity.WXList;
import org.springframework.stereotype.Repository;

/**
 * @author 王英豪111
 */
@Repository
public interface ListRepository {


    /**
     * 添加一条订单
     * @param wxList
     */
    void addList(WXList wxList);


    /**
     * 通过id查找一个用户订单
     * @param open_id
     * @return
     */
    WXList findListByOpenId(String  open_id);


    /**
     * 修改一个订单状态
     * @param id
     */
    void modify(Long id);
}
