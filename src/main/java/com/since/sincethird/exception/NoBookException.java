package com.since.sincethird.exception;


public class NoBookException extends RuntimeException {
    String msg;

    public NoBookException(){
        this.msg = "该书数量不足";
    }
    public NoBookException(String msg){
        this.msg = msg;
    }
}
