package com.coder520.user.service.impl;

import com.coder520.user.dao.UserMapper;
import com.coder520.user.entity.User;
import com.coder520.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{


    @Autowired
    private UserMapper userMapper;


    //创建用户
    @Override
    public int createUser(User user) {
        int result = userMapper.insert(user);
        return result;
    }
}
