package com.since.sincethird.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author luoxinyuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ret<T> {
    public Ret(Code error,T data){
        this.code = error.getCode();
        this.data = data;
        this.errMsg = error.getErrMsg();
    }
    public String code;
    public T data;
    public String errMsg;
}
