package com.example.loginwithredis.user.vo;

import com.example.loginwithredis.common.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseVO {
    String code;
    String message;

    public UserResponseVO(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
