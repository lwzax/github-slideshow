package com.liwei.controller;

import com.liwei.pojo.User;
import com.liwei.service.UserLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    public String UserLogin(String name,String password,Model model){
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        //执行登陆的方法，如果没有异常就说明ok了
        try {
            subject.login(token);
            return "public/index";
        } catch (UnknownAccountException e) { //用户名不存在
            model.addAttribute("msg","用户名错误！");
            return "public/signin";
        } catch (IncorrectCredentialsException e){//密码错误
            model.addAttribute("msg","密码错误请重新输入！");
            return "public/signin";
        }
////        System.out.println("==>user"+user);
//        User user1 = userLoginService.selectUser(user);
////        System.out.println("==>user1"+user1);
//        if (user1 != null){
//            session.setAttribute("Userlogin",user);
//            return "redirect:/main.html";
//        }else {
//            model.addAttribute("msg","用户名或密码错误！");
//            return "signin";
//        }
    }
}
