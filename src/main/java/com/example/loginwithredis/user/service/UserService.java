package com.example.loginwithredis.user.service;

import com.example.loginwithredis.common.ErrorCode;
import com.example.loginwithredis.user.vo.UserVO;

public interface UserService {
    ErrorCode signIn(UserVO userVO);
    ErrorCode join(UserVO userVO);
}
