package com.example.loginwithredis.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

      SUCCESS("00", "성공")
    , COMMON_ERROR("01", "처리중 에러가 발생하였습니다.")
    , DUPLICATE_ID("10", "중복된 ID 입니다.")
    , NONEXISTENT_ID("11", "존재하지 않는 ID 입니다.")
    , PASSWORD_DO_NOT_MATCH("20", "패스워드가 일치하지 않습니다.");

    private String code;
    private String message;
}
