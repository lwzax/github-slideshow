package com.liwei;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class ProjactApplicationTests {

    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() {
        System.out.println(dataSource.getClass());

        //获得数据库连接
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
