package com.example.loginwithredis.user.service;

import com.example.loginwithredis.user.vo.UserVO;

public interface UserService {
    void signIn(UserVO userVO);
    void join(UserVO userVO);
}
