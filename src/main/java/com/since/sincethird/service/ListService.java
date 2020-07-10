package com.since.sincethird.service;

import com.since.sincethird.entity.WXList;
import org.springframework.stereotype.Service;


/**
 * @author 王英豪111
 */
public interface ListService {

    /**
     * 添加一个订单
     * @param wxList
     */
    void add(WXList wxList);



    /**
     * 根据openid查找订单
     * @param open_id
     * @return
     */
    WXList findListByOpenId(String open_id);


    /**
     * 根据id修改订单信息
     * @param id
     */
    void modify(Long id);
}

