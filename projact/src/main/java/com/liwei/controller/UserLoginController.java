package com.liwei.controller;

import com.liwei.pojo.User;
import com.liwei.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/login")
    public String UserLogin(User user, Model model, HttpSession session){
//        System.out.println("==>user"+user);
        User user1 = userLoginService.selectUser(user);
//        System.out.println("==>user1"+user1);
        if (user1 != null){
            session.setAttribute("Userlogin",user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","用户名或密码错误！");
            return "signin";
        }
    }
}
