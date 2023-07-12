package com.example.loginwithredis.common;

import lombok.Getter;

@Getter
public class LkhException extends RuntimeException {

    private ErrorCode errorCode;

    public LkhException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public LkhException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public LkhException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public LkhException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public LkhException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCode errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }
}
