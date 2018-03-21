package com.coder520.user.service.impl;

import com.coder520.user.dao.UserMapper;
import com.coder520.user.entity.User;
import com.coder520.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : Hellxz
 * @Description: 用户service实现类
 * @Date : 2018/3/7 9:42
 */
@Service("userService")
public class UserServiceImpl implements UserService{


    @Autowired
    private UserMapper userMapper; //注入mapper


    /**
     * @Author: Hellxz
     * @Description: 根据用户名获取用户对象
     * @Date: 2018/3/7 9:51
     */
    @Override
    public User findUserByUsername(String username) {
        User user = userMapper.selectByUserName(username);
        return user;
    }
    
    /**
     * @Author: Hellxz
     * @Description: 添加用户
     * @Date: 2018/3/7 10:05
     */
    @Override
    public int register(User user){
        int result = userMapper.insertSelective(user);
        return result;
    }

}
