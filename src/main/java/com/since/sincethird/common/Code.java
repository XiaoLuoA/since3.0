package com.since.sincethird.common;

import lombok.Getter;

/**
 * @author luoxinyuan
 */

@Getter
public class Code {
    String code;
    String errMsg;
    Code(String code,String errMsg){
        this.code = code;
        this.errMsg = errMsg;
    };
    Code(String code){
        this.code = code;
    };
}
