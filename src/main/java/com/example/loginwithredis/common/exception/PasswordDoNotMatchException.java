package com.example.loginwithredis.common.exception;

import com.example.loginwithredis.common.ErrorCode;
import com.example.loginwithredis.common.LkhException;

public class PasswordDoNotMatchException extends LkhException {

    public PasswordDoNotMatchException() {
        super(ErrorCode.PASSWORD_DO_NOT_MATCH);
    }

    public PasswordDoNotMatchException(String message) {
        super(message, ErrorCode.PASSWORD_DO_NOT_MATCH);
    }

    public PasswordDoNotMatchException(String message, Throwable cause) {
        super(message, cause, ErrorCode.PASSWORD_DO_NOT_MATCH);
    }

    public PasswordDoNotMatchException(Throwable cause) {
        super(cause, ErrorCode.PASSWORD_DO_NOT_MATCH);
    }

    public PasswordDoNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, ErrorCode.PASSWORD_DO_NOT_MATCH);
    }
}
