package com.since.sincethird.service;

import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.since.sincethird.dto.Attach;
import com.since.sincethird.entity.WXList;

import java.util.List;


/**
 * @author 王英豪111
 */
public interface ListService {

    /**
     * 添加或修改一个订单
     * @param wxList
     * @return
     */
    WXList save(WXList wxList);


    WXList preList(String openid, Attach attach,String wxImage);

    /**
     * 支付订单
     * @param wxList,WXcode
     * @return
     */
    WXList pay(WXList wxList, String WXcode);

    WXList buy(WXList wxList);

    /**
     * 根据openid查找订单
     * @param open_id
     * @return
     */
    List<WXList> findListByOpenId(String open_id);



    /**
     * 通过订单id查找订单
     * @param id
     * @return
     */

    WXList findWXListById(Long id);


    WxPayUnifiedOrderRequest getWxPayUnifiedOrder(String openid,
                                                  String remoteAddr,String no,int total);

    /**
     * 修改订单状态
     * @param wxList
     * @return
     */
    WXList modifyList(WXList wxList);



    /**
     * 删除订单状态（状态改为-1）
     * @param wxList
     * @return
     */
    WXList deleteList(WXList wxList);







}

