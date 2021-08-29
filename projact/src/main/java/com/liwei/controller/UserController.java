package com.liwei.controller;

import com.liwei.mapper.UserMapper;
import com.liwei.pojo.User;
import com.liwei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userlist")
    public List<User> shoeUserList(){
        List<User> userList = userService.SelectUser();
        for (User user : userList){
            System.out.println(user);
        }
        return userList;
    }
}
