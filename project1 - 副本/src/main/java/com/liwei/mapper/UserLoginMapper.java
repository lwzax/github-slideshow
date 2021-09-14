package com.liwei.mapper;

import com.liwei.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserLoginMapper {
    public User LoginSelectUser(String name);
}
