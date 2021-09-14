package com.liwei.service.impl;

import com.liwei.mapper.UserLoginMapper;
import com.liwei.pojo.User;
import com.liwei.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLogingServiceImpl implements UserLoginService {

    @Autowired
    UserLoginMapper userLoginMapper;

    @Override
    public User LoginSelectUser(String name) {
        return userLoginMapper.LoginSelectUser(name);
    }
}
