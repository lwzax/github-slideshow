package com.liwei.mapper;

import com.liwei.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> SelectUser();
}
