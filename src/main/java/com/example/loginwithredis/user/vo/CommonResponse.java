package com.example.loginwithredis.user.vo;

import com.example.loginwithredis.common.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;

// 2023.07.15 이경훈: 제네릭을 이용한 형태로 변경
// 2023.07.15 이경훈: UserResponseVO를 제거하고 모든 응답을 CommonResponse로.
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse <T>{

    private final T data;
    private final String code;
    private final String message;

    public CommonResponse(String code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public CommonResponse(ErrorCode errorCode){
        this.data = null;
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public CommonResponse(T data, String code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
