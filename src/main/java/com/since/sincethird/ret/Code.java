package com.since.sincethird.ret;

import lombok.Getter;

/**
 * @author luoxinyuan
 * 返回值的Code参数
 */
@Getter
public class Code {
    String code;
    String errMsg;
    public Code(String code,String errMsg){
        this.code = code;
        this.errMsg = errMsg;
    }
    public Code(String code){
        this.code = code;
    }
}
