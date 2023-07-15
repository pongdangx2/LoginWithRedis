package com.example.loginwithredis.user.vo;


import com.example.loginwithredis.common.ErrorCode;

// 2023,.07.15 이경훈: 제네릭을 이용한 형태로 변경
public class UserResponseVO <T> extends CommonResponse {

    private final T data;

    public UserResponseVO(String code, String message, T data) {
        super(code, message);
        this.data = data;
    }

    public UserResponseVO(ErrorCode errorCode, T data){
        super(errorCode.getCode(), errorCode.getMessage());
        this.data = data;
    }

    public UserResponseVO(ErrorCode errorCode){
        super(errorCode.getCode(), errorCode.getMessage());
        this.data = null;
    }
}
