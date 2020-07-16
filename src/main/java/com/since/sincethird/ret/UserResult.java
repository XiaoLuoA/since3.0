package com.since.sincethird.ret;

/**
 * @author luoxinyuan
 */
public interface UserResult extends Result {
    Code USER_NOT_FIND = new Code("801_402","该用户不存在！");
    /**
     * @author jayzh
     */
    Code OPEN_ID_NOT_SAME=new Code("801_403","openid不匹配");
}
