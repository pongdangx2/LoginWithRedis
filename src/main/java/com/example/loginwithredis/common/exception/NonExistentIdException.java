package com.example.loginwithredis.common.exception;

import com.example.loginwithredis.common.ErrorCode;
import com.example.loginwithredis.common.LkhException;

public class NonExistentIdException extends LkhException {

    public NonExistentIdException() {
        super(ErrorCode.NONEXISTENT_ID);
    }

    public NonExistentIdException(String message) {
        super(message, ErrorCode.NONEXISTENT_ID);
    }

    public NonExistentIdException(String message, Throwable cause) {
        super(message, cause, ErrorCode.NONEXISTENT_ID);
    }

    public NonExistentIdException(Throwable cause) {
        super(cause, ErrorCode.NONEXISTENT_ID);
    }

    public NonExistentIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, ErrorCode.NONEXISTENT_ID);
    }
}
