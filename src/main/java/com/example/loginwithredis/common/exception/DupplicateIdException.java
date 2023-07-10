package com.example.loginwithredis.common.exception;

import com.example.loginwithredis.common.ErrorCode;
import com.example.loginwithredis.common.LkhException;

public class DupplicateIdException extends LkhException {

    public DupplicateIdException() {
        super(ErrorCode.DUPLICATE_ID);
    }

    public DupplicateIdException(String message) {
        super(message, ErrorCode.DUPLICATE_ID);
    }

    public DupplicateIdException(String message, Throwable cause) {
        super(message, cause, ErrorCode.DUPLICATE_ID);
    }

    public DupplicateIdException(Throwable cause) {
        super(cause, ErrorCode.DUPLICATE_ID);
    }

    public DupplicateIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, ErrorCode.DUPLICATE_ID);
    }
}
