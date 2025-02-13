package com.xj.imageback.exception;

import lombok.Getter;

/**
 * 自定义业务异常类，便于定制化输出错误信息
 */
@Getter
public class BusinessException extends RuntimeException{
    // 错误码
    private final int code;

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String messsage) {
        super(messsage);
        this.code = errorCode.getCode();
    }
}
