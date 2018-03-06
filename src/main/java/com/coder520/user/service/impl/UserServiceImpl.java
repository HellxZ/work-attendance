package com.coder520.user.service.impl;

import com.coder520.user.dao.UserMapper;
import com.coder520.user.entity.User;
import com.coder520.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService{


    @Autowired
    private UserMapper userMapper;


    //创建用户
    @Override
    @Transactional
    public int createUser(User user,User user1) {
        int result = userMapper.insertSelective(user);
        int result1 = userMapper.insertSelective(user1);
        return result;
    }
}
