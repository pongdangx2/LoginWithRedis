package com.example.loginwithredis.common.exception;

import com.example.loginwithredis.common.ErrorCode;
import com.example.loginwithredis.common.LkhException;

public class CommonErrorException extends LkhException {

    public CommonErrorException() {
        super(ErrorCode.COMMON_ERROR);
    }


    public CommonErrorException(String message) {
        super(message, ErrorCode.COMMON_ERROR);
    }

    public CommonErrorException(String message, Throwable cause) {
        super(message, cause, ErrorCode.COMMON_ERROR);
    }

    public CommonErrorException(Throwable cause) {
        super(cause, ErrorCode.COMMON_ERROR);
    }

    public CommonErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, ErrorCode.COMMON_ERROR);
    }
}
