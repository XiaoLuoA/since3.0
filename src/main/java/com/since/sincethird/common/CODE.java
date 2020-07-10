package com.since.sincethird.common;

import lombok.Getter;

/**
 * @author luoxinyuan
 */

@Getter
public enum CODE {
    SUCCESS("0"),
    NOT_FIND_ERROR("404","404"),
    USER_NOT_FIND_ERROR("404_100","该用户不存在");
    String code;
    String errMsg;
    CODE(String code,String errMsg){
        this.code = code;
        this.errMsg = errMsg;
    };
    CODE(String code){
        this.code = code;
    };
}
