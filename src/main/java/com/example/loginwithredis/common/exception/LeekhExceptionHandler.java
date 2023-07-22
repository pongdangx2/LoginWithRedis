package com.example.loginwithredis.common.exception;

import com.example.loginwithredis.common.LkhException;
import com.example.loginwithredis.user.vo.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LeekhExceptionHandler {

    @ExceptionHandler(value= LkhException.class)
    public ResponseEntity LkhExceptionHandler(LkhException e){
        CommonResponse commonResponse = new CommonResponse(e.getErrorCode());
        return ResponseEntity.status(HttpStatus.OK).body(commonResponse);
    }

}
