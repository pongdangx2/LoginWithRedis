package com.example.loginwithredis.user.controller;

import com.example.loginwithredis.user.controller.service.UserService;
import com.example.loginwithredis.user.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService redisUserService) {
        this.userService = redisUserService;
    }

    @RequestMapping("/login.do")
    public ModelAndView loginPage(@RequestParam(required = false) String resultMessage) {
        ModelAndView mv = new ModelAndView();
        if(resultMessage != null)
            mv.addObject("resultMessage", resultMessage);
        mv.setViewName("Login.html");
        return mv;
    }

    @RequestMapping("/signin.do")
    public ModelAndView signin(Model model, @RequestParam(value = "id") String id, @RequestParam("password") String password) {
        ModelAndView mv = new ModelAndView();

        UserVO userVO = new UserVO(id, password);
        userService.signIn(userVO);
        mv.addObject("resultMessage", "로그인 성공");
        mv.setViewName("redirect:/user/login.do");
        return mv;
    }

    @RequestMapping("/join.do")
    public ModelAndView join(Model model, @RequestParam("id") String id, @RequestParam("password") String password) {
        ModelAndView mv = new ModelAndView();

        UserVO userVO = new UserVO(id, password);
        userService.join(userVO);

        mv.addObject("resultMessage", "회원가입 성공");
        mv.setViewName("redirect:/user/login.do");
        return mv;
    }
}
