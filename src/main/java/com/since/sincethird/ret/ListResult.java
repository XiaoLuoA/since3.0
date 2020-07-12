package com.since.sincethird.ret;

import com.since.sincethird.common.Code;

/**
 * @author 王英豪111
 */
public interface ListResult {
    Code LIST_OPENID_NOT_FOUND = new Code("900_401","查找为空");
    Code LIST_ID_NOT_FOUND = new Code("900_402","发货失败");
    Code LIST_BOOK_NUM_NO = new Code("900_403","库存不足");
    Code LIST_PAY_FAIL = new Code("900_405","支付失败");
}
