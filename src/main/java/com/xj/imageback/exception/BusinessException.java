package com.xj.imageback.exception;

import lombok.Getter;

/**
 * 自定义业务异常类，便于定制化输出错误信息
 */
@Getter
public class BussinessException extends RuntimeException{
    // 错误码
    private final int code;

    public BussinessException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BussinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BussinessException(ErrorCode errorCode, String messsage) {
        super(messsage);
        this.code = errorCode.getCode();
    }
}
