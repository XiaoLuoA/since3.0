package com.since.sincethird.ret;

import com.since.sincethird.common.Code;
import com.since.sincethird.ret.Result;

/**
 * @author luoxinyuan
 */
public interface UserResult extends Result {
    Code USER_NOT_FIND = new Code("800_402","该用户不存在！");
}
