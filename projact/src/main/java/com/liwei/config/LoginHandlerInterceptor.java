package com.liwei.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userlogin = request.getSession().getAttribute("Userlogin");
        if (userlogin == null){
            request.setAttribute("msg","没有权限，请先登陆");
            request.getRequestDispatcher("/signin.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}
