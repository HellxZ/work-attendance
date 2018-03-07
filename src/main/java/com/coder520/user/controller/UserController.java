package com.coder520.user.controller;

import com.coder520.common.utils.SecurityUtils;
import com.coder520.user.entity.User;
import com.coder520.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author : Hellxz
 * @Description: 用户controller
 * @Date : 2018/3/7 12:46
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Author: Hellxz
     * @Description: 注册
     * @Date: 2018/3/7 16:53
     */
    @RequestMapping("/register")
    @ResponseBody
    public String insert(@RequestBody User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        user.setPassword(SecurityUtils.encryptPwd(user.getPassword()));
        int i = userService.register(user);
        return "registerSucceed";
    }

    @RequestMapping("/home")
    public String home(){ //进入首页
        return "home";
    }

    /**
     * @Author: Hellxz
     * @Description: 获取用户信息
     * @Date: 2018/3/7 16:53
     */
    @RequestMapping("/userinfo")
    @ResponseBody
    public User getUserInfo(HttpSession session){
        User user = (User) session.getAttribute("userinfo");
        return user;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); //摧毁当前session
        return "login"; //跳转回登录页
    }

}
