package com.liwei.service.impl;

import com.liwei.mapper.UserMapper;
import com.liwei.pojo.User;
import com.liwei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> SelectUser() {
        return userMapper.SelectUser();
    }
}
