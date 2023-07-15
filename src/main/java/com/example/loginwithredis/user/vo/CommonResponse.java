package com.example.loginwithredis.user.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

// 2023,.07.15 이경훈: 제네릭을 이용한 형태로 변경
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse {

    private final String code;
    private final String message;

    public CommonResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
