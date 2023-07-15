package com.example.loginwithredis.user.service.impl;

import com.example.loginwithredis.common.exception.CommonErrorException;
import com.example.loginwithredis.common.exception.DupplicateIdException;
import com.example.loginwithredis.common.exception.NonExistentIdException;
import com.example.loginwithredis.common.exception.PasswordDoNotMatchException;
import com.example.loginwithredis.user.service.UserService;
import com.example.loginwithredis.user.vo.UserVO;
import com.example.loginwithredis.util.SecurityUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;


@Service("redisUserService")
public class UserServiceImpl implements UserService {

    private final RedisTemplate<String, UserVO> redisTemplate;

    public UserServiceImpl(RedisTemplate<String, UserVO> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 로그인
     * @param userVO
     * @return
     */
    @Override
    public void signIn(UserVO userVO) {
        String password = "";
        ValueOperations<String, UserVO> stringObjectValueOperations = redisTemplate.opsForValue();
        try {
            UserVO passwordObj = stringObjectValueOperations.get(userVO.getId());

            // ID가 존재하지 않을 경우
            if(passwordObj == null){
                throw new NonExistentIdException();
            }

            password = passwordObj.getPassword();

            // 패스워드가 일치하지 않는 경우
            if (!password.equals(SecurityUtil.encrypt(userVO.getPassword()))) {
                throw new PasswordDoNotMatchException();
            }
        } catch (NoSuchAlgorithmException NoSuchAlgorithmException){
            NoSuchAlgorithmException.printStackTrace();
            throw new CommonErrorException("Unable to Encrypt Password");
        }
    }

    /**
     * 회원가입
     * @param userVO
     * @return
     */
    @Override
    public void join(UserVO userVO) {
        try {
            // ID가 이미 존재하는 경우
            if(redisTemplate.hasKey(userVO.getId())){
                throw new DupplicateIdException();
            } else {
                //패스워드 저장
                ValueOperations<String, UserVO> stringObjectValueOperations = redisTemplate.opsForValue();
                String encryptedPassword = SecurityUtil.encrypt(userVO.getPassword());
                userVO.setPassword(encryptedPassword);
                stringObjectValueOperations.set(userVO.getId(), userVO);
            }
        } catch(NoSuchAlgorithmException | NullPointerException exception) {
            throw new CommonErrorException();
        }
    }

}
