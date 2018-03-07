package com.coder520.user.service;

import com.coder520.user.entity.User;

public interface UserService {

    User findUserByUsername(String username);
    int register(User user);
}
