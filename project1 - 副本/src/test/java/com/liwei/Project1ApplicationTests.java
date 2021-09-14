package com.liwei;

import com.liwei.service.UserLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Project1ApplicationTests {
    @Autowired
    UserLoginService userLoginService;
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    DataSource dataSource;
    @Test
    void contextLoads() {
        System.out.println(userLoginService.LoginSelectUser("小明"));
//        System.out.println(dataSource.getClass());
//
//        //获得数据库连接
//        try {
//            Connection connection = dataSource.getConnection();
//            System.out.println(connection);
//            connection.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
    }
}
