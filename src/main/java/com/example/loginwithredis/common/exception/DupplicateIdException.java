package com.example.loginwithredis.common.exception;

import com.example.loginwithredis.common.ErrorCode;
import com.example.loginwithredis.common.LkhException;

public class DupplicateIdException extends LkhException {

    public DupplicateIdException() {
        super(ErrorCode.DUPLICATE_ID);
    }

}
