package com.example.loginwithredis.user.controller.service.impl;

import com.example.loginwithredis.common.exception.CommonErrorException;
import com.example.loginwithredis.common.exception.DupplicateIdException;
import com.example.loginwithredis.user.controller.service.UserService;
import com.example.loginwithredis.user.vo.UserVO;
import com.example.loginwithredis.util.SecurityUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;


@Service("redisUserService")
public class UserServiceImpl implements UserService {

    private final RedisTemplate<String, Object> redisTemplate;

    public UserServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void signIn(UserVO userVO) {
        System.out.println("==== signIn start ====");
        String password = "";
        ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
        try {
            password = stringObjectValueOperations.get(userVO.getId()).toString();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        System.out.println(password);
        System.out.println("==== signIn End ====");
    }

    @Override
    public void join(UserVO userVO) {
        System.out.println("==== join start ====");
        try {
            if(redisTemplate.hasKey(userVO.getId())){
                throw new DupplicateIdException();
            } else {
                ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
                String encryptedPassword = SecurityUtil.encrypt(userVO.getPassword());
                stringObjectValueOperations.set(userVO.getId(), encryptedPassword);
            }
        } catch(NoSuchAlgorithmException | NullPointerException nae) {
            throw new CommonErrorException();
        }
        System.out.println("==== join end ====");
    }

}
