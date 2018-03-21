package com.coder520.login.controller;

import com.coder520.common.utils.MD5Utils;
import com.coder520.user.entity.User;
import com.coder520.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author : Hellxz
 * @Description: 登录controller
 * @Date : 2018/3/7 9:48
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String login(){ //跳转登录页面
        return "login";
    }

    @RequestMapping("/check")
    @ResponseBody
    public String checkLogin(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException { //检查登录是否合法
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //数据库中查询是否有该用户，如果有返回该用户的对象
        User user = userService.findUserByUsername(username);
        if(user==null){ //为空直接返回错误
            return "invalidLogin";
        }
        //校验密码是否正确，通过将该user对象保存session，并返回一个通过signal
        boolean checkResult = MD5Utils.checkPwd(password, user.getPassword());
        //不通过返回一个校验失败signal
        if(checkResult){
            request.getSession().setAttribute("userinfo",user);
            return "loginSuccess";
        }
        return "invalidLogin";
    }

    @RequestMapping("/error")
    @ResponseBody
    public String error(){
        User user = new User();
        user.setId(1L);
        user.setPassword("524125");
        user.setRealName("laowang");
        user.setUsername("good");
        userService.register(user);
        return "error";
    }
}
