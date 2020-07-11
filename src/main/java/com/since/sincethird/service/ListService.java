package com.since.sincethird.service;

import com.since.sincethird.entity.Book;
import com.since.sincethird.entity.WXList;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 王英豪111
 */
public interface ListService {

    /**
     * 添加一个订单
     * @param wxList
     * @return
     */
    WXList save(WXList wxList);



    /**
     * 根据openid查找订单
     * @param open_id
     * @return
     */
    List<WXList> findListByOpenId(String open_id);





}

