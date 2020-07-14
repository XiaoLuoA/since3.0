package com.since.sincethird.ret;

public interface BookResult extends Result {
    Code Book_NOT_FIND =new Code("800_401","没有查到此本书");
    Code Book_NOT_ENOUGH =new Code("800_402","抱歉，库存不足");
}
