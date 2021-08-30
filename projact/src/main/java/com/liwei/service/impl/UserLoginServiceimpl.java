package com.liwei.service.impl;

import com.liwei.mapper.UserLoginMapper;
import com.liwei.pojo.User;
import com.liwei.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceimpl implements UserLoginService {
    @Autowired
    UserLoginMapper userLoginMapper;

    @Override
    public User selectUser(User user) {
        return userLoginMapper.selectUser(user);
    }
}
