package com.since.sincethird.common;

import lombok.Getter;

/**
 * @author luoxinyuan
 */

@Getter
public class Code {
    String code;
    String errMsg;
    public Code(String code,String errMsg){
        this.code = code;
        this.errMsg = errMsg;
    };
    public Code(String code){
        this.code = code;
    };
}
