package com.example.springbootcommon.exception;

import com.example.springbootcommon.constant.CommonConstant;

public class BaseException extends RuntimeException {
    private Integer code;

    public BaseException(String message) {
        this(CommonConstant.ERROR_CODE, message);
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String message, Throwable cause) {
        this(CommonConstant.ERROR_CODE, message, cause);
    }

    public BaseException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
