package com.since.sincethird.ret;

/**
 * @author luoxinyuan
 */
public interface Result {
    Code SUCCESS = new Code("0");
    Code NOT_FIND_ERROR= new Code("404","该页面不存在！");
}
