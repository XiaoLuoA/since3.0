package com.since.sincethird.ret;

import com.since.sincethird.common.Code;

/**
 * @author 王英豪111
 */
public interface ListResult {
    Code OPENID_NOT_FOUND = new Code("900_401","查找为空");
    Code ORDERID_NOT_FOUND = new Code("900_402","发货失败");
    Code NO_NUM = new Code("900_403","库存不足");
}
