package com.example.loginwithredis.user.vo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    @NonNull
    private String id;

    @NonNull
    private String password;
}
