package com.coder520.user.dao;

import com.coder520.user.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名获取用户对象
     * @param username
     * @return User对象
     */
    User selectByUserName(String username);
}