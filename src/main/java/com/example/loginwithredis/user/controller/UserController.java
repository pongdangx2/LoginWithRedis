package com.example.loginwithredis.user.controller;

import com.example.loginwithredis.common.ErrorCode;
import com.example.loginwithredis.common.LkhException;
import com.example.loginwithredis.user.service.UserService;
import com.example.loginwithredis.user.vo.UserResponseVO;
import com.example.loginwithredis.user.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService redisUserService) {
        this.userService = redisUserService;
    }

    // ===================================== for web start =====================================
    @RequestMapping("/login.do")
    public ModelAndView loginPage(@RequestParam(required = false) String resultMessage) {
        ModelAndView mv = new ModelAndView();
        if(resultMessage != null)
            mv.addObject("resultMessage", resultMessage);
        mv.setViewName("Login.html");
        return mv;
    }

    @RequestMapping("/signIn.do")
    public ModelAndView signIn(@RequestParam(value = "id") String id, @RequestParam("password") String password) {
        ModelAndView mv = new ModelAndView();

        UserVO userVO = new UserVO(id, password);
        String resultMessage = "";
        try {
            userService.signIn(userVO);
            resultMessage = "로그인 성공";
        }catch(LkhException lkhException){
            resultMessage = lkhException.getErrorCode().getMessage();
        }
        mv.addObject("resultMessage", resultMessage);
        mv.setViewName("redirect:/user/login.do");
        return mv;
    }

    @RequestMapping("/join.do")
    public ModelAndView join(Model model, @RequestParam("id") String id, @RequestParam("password") String password) {
        ModelAndView mv = new ModelAndView();

        UserVO userVO = new UserVO(id, password);

        String resultMessage = "";
        try {
            userService.join(userVO);
            resultMessage = "회원가입 성공";
        }catch(LkhException lkhException){
            resultMessage = lkhException.getErrorCode().getMessage();
        }

        mv.addObject("resultMessage", resultMessage);
        mv.setViewName("redirect:/user/login.do");
        return mv;
    }
    // ===================================== for web end =====================================

    // ===================================== for api start =====================================
    @PostMapping("/signIn")
    @ResponseBody
    public UserResponseVO signInApi(@RequestBody UserVO userVO){
        userService.signIn(userVO);
        return new UserResponseVO(ErrorCode.SUCCESS);
    }

    @PostMapping("/join")
    @ResponseBody
    public UserResponseVO joinApi(@RequestBody UserVO userVO){
        userService.join(userVO);
        return new UserResponseVO(ErrorCode.SUCCESS);
    }
    // ===================================== for api end =====================================
}
