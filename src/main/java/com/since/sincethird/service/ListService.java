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
     * @param wxList 微信订单信息
     * @return 微信订单
     */
    WXList save(WXList wxList);


    /**
     * 构建订单
     * @param openid 微信个人唯一标识openid
     * @param attach 构建订单的相关信息
     * @param wxImage 微信头像地址
     * @return 微信订单
     */
    WXList preList(String openid, Attach attach,String wxImage);


    /**
     * 购买：减库存和新建订单
     * @param wxList 微信订单信息
     * @return 微信订单
     */
    WXList buy(WXList wxList);

    /**
     * 根据openid查找订单
     * @param openId 微信个人唯一标识openid
     * @return  微信订单集合
     */
    List<WXList> findListByOpenId(String openId);




    /**
     *通过订单号查找订单
     * @param no 订单号
     * @return 微信订单
     */
    WXList findByNo(String no);

    /**
     * 微信支付相关
     * @param openid 微信的个人唯一标识账号
     * @param remoteAddr 购买者ip
     * @param no 订单号
     * @param total 订单金额
     * @return  微信统一下单接口请求对象
     */
    WxPayUnifiedOrderRequest getWxPayUnifiedOrder(String openid,
                                                  String remoteAddr,String no,int total);


    /**
     * 修改订单的状态为3（已发货）
     * @param no  订单号
     * @return boolean
     */
    boolean modifyList(String no);





    /**
     * 通过订单状态查询所有订单
     */
    void findAllByWxListStatus();


    /**
     *查找所有订单
     * @return 微信订单的list集合
     */
    List<WXList> findAllWxList();




}

