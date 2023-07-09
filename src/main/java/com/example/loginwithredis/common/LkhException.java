package com.example.loginwithredis.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LkhException extends RuntimeException {

    private ErrorCode errorCode;

}
