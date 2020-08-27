package com.lmj.forum.exception;

public class CustomException extends RuntimeException{

    public CustomException() {
        super("自定义异常");
    }

    public CustomException(String message) {
        super(message);
    }

}
