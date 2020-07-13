package com.since.sincethird.service;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;

public interface WXPayService {
    boolean handleWXResp(WxPayOrderNotifyResult wxPayOrderNotifyResult);
}
