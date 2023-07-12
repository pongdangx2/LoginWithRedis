package com.example.loginwithredis.user.service.impl;

import com.example.loginwithredis.common.ErrorCode;
import com.example.loginwithredis.common.LkhException;
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

    private final RedisTemplate<String, Object> redisTemplate;

    public UserServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 로그인
     * @param userVO
     * @return
     */
    @Override
    public ErrorCode signIn(UserVO userVO) {
        String password = "";
        ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
        try {
            Object passwordObj = stringObjectValueOperations.get(userVO.getId());

            // ID가 존재하지 않을 경우
            if(passwordObj == null){
                // 그냥 ErrorCode를 리턴하는게 가장 간단해보임.
                throw new NonExistentIdException();
//                throw new LkhException(ErrorCode.NONEXISTENT_ID);
//                return ErrorCode.NONEXISTENT_ID;
            }

            password = passwordObj.toString();

            // 패스워드가 일치하지 않는 경우
            if (!password.equals(SecurityUtil.encrypt(userVO.getPassword()))) {
                throw new PasswordDoNotMatchException();
//                throw new LkhException(ErrorCode.PASSWORD_DO_NOT_MATCH);
//                return ErrorCode.PASSWORD_DO_NOT_MATCH;
            }
        } catch (NoSuchAlgorithmException nae){
            nae.printStackTrace();
            throw new CommonErrorException("Unable to Encrypt Password");
//            throw new LkhException("Unable to Encrypt Password", ErrorCode.COMMON_ERROR);
        }
        return ErrorCode.SUCCESS;
    }

    /**
     * 회원가입
     * @param userVO
     * @return
     */
    @Override
    public ErrorCode join(UserVO userVO) {
        try {
            // ID가 이미 존재하는 경우
            if(redisTemplate.hasKey(userVO.getId())){
                throw new DupplicateIdException();
//                return ErrorCode.DUPLICATE_ID;
            } else {
                //패스워드 저장
                ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
                String encryptedPassword = SecurityUtil.encrypt(userVO.getPassword());
                stringObjectValueOperations.set(userVO.getId(), encryptedPassword);
            }
        } catch(NoSuchAlgorithmException | NullPointerException nae) {
            throw new CommonErrorException();
//            throw new LkhException(ErrorCode.COMMON_ERROR);
        }
        return ErrorCode.SUCCESS;
    }
}
