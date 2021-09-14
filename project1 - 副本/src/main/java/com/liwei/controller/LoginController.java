package com.liwei.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/tologin")
    public String UserLogin(String name,String password,Model model){
        //获取当前用户
//        System.out.println(name+password);
        Subject subject = SecurityUtils.getSubject();

        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        //执行登陆方法
        try {
            subject.login(token);
            if (subject.isAuthenticated()){
                return "redirect:/index";
            }else {
                token.clear();
                return "redirect:/signin";
            }
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名错误！");
            return "Public_page/signin";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误请重新输入！");
            return "Public_page/signin";
        }

    }

    @RequestMapping("/logout")
    public String doLogOut(Model model){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("msg", "安全退出!");
        return "/Public_page/signin";
    }


    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized(){
        return "未经授权无法访问此页面";
    }
}
