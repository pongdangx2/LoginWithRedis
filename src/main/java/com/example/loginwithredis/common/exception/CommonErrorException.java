package com.example.loginwithredis.common.exception;

import com.example.loginwithredis.common.ErrorCode;
import com.example.loginwithredis.common.LkhException;

public class CommonErrorException extends LkhException {

    public CommonErrorException() {
        super(ErrorCode.COMMON_ERROR);
    }

}
