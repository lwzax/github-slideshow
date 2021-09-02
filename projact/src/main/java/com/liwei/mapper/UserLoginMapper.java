package com.liwei.mapper;

import com.liwei.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginMapper {
    public User selectUser(User user);
}
