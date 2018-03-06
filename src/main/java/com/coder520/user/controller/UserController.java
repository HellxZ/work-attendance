package com.coder520.user.controller;

import com.coder520.user.entity.User;
import com.coder520.user.service.UserService;
import com.sun.tools.internal.ws.processor.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String test(Model model){
        User user = new User();
        user.setMobile("1329853397");
        user.setRealName("laozhang");
        user.setUsername("hellxz");
        int i = userService.createUser(user);
        model.setProperty("result",i);
        return "user";
    }
}
