package com.since.sincethird.common;

/**
 * @author luoxinyuan
 */
public interface UserResult extends Result {
    Code USER_NOT_FIND = new Code("404","该用户不存在！");
    //Code USER_HAD_RIGIST = new Code("100","成功！");
    Code USER_SUCCESS = new Code("0","成功！");
}
