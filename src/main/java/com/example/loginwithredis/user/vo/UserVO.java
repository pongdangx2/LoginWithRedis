package com.example.loginwithredis.user.vo;


// 2023.07.15
public record UserVO(String id, String password) {

    public static UserVO createUserVO(String id, String password) {
        return new UserVO(id, password);
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
