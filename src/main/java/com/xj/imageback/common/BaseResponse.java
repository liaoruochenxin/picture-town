package com.xj.imageback.common;

import com.xj.imageback.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * 响应包装类
 */
@Data
public class BaseResponse<T> implements Serializable {
    // 响应码
    private int code;
    // 返回数据
    private T data;
    // 返回信息
    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(T data, int code) {
        this(code, data, "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage());
    }
}
