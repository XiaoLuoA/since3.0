package com.since.sincethird.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.since.sincethird.common.Status;
import com.since.sincethird.entity.WXList;
import com.since.sincethird.service.BookService;
import com.since.sincethird.service.ListService;
import com.since.sincethird.service.WXPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luoxinyuan
 */
@Service
public class WXPayServiceImpl implements WXPayService {
    @Autowired
    ListService listService;

    @Autowired
    BookService bookService;

    @Override
    public boolean handleWXResp(WxPayOrderNotifyResult notifyResult) {
        System.out.println("come in handle"+JSON.toJSONString(notifyResult));
        String retCode = notifyResult.getReturnCode();
        if (Status.SUCCESS.equals(retCode)){
            String resCode = notifyResult.getResultCode();
            switch (resCode){
                case Status.SUCCESS:{
                    System.out.println("真~支付成功");
                    listService.modifyList(notifyResult.getOutTradeNo(),Status.WX_LIST_PAY);
                    System.out.println("success");
                    return true;
                }
                case Status.FAIL: {
                    System.out.println("錯誤代碼描述："+notifyResult.getErrCodeDes());
                    String orderId = notifyResult.getOutTradeNo();
                    boolean modifySuccuss = listService.modifyList(orderId,Status.WX_LIST_PAY_FAIL);
                    if(!modifySuccuss){
                        System.out.println("----------------訂單狀態修改失敗！！！");
                    }
                    WXList list = listService.findByNo(orderId);
                    boolean modBookSuc = bookService.addStock(list.getBookNum(),Integer.parseInt(list.getBookId()));
                    if (!modBookSuc){
                        System.out.println("----------------書籍狀態修改失敗！！！");
                    }
                    return true;
                }
                default:{
                    System.out.println(JSON.toJSONString(notifyResult));
                    System.out.println("未知錯誤");
                    return false;
                }
            }
        }else {
            System.out.println(JSON.toJSONString(notifyResult));
            System.out.println("通信錯誤");
            return false;
        }
    }
}
