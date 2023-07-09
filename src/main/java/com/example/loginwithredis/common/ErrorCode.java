package com.example.loginwithredis.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    SUCCESS("00", "SUCCESS"),
    COMMON_ERROR("01", "처리중 에러가 발생하였습니다."),
    DUPLICATE_ID("10", "중복된 ID 입니다."),
    TOO_SHORT_PASSWORD("20", "패스워드는 10자리이상이어야 합니다.");

    private String message;
    private String code;

}
