package com.since.sincethird.common;

/**
 * @author luoxinyuan
 */
public interface UserResult extends Result {
    Code USER_NOT_FIND = new Code("404","该用户不存在！");
}
