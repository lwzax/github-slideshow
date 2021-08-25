package com.liwe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class MyMVCconfig implements WebMvcConfigurer {
    //ViewResolver 实现了视图解析器接口的类，就可以把它看成视图解析器。
    //自定义一个自己的视图解析器 MyViewResolver


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor()).addPathPatterns("/**").excludePathPatterns("/login.html","/","login","/css/**","/img/**","/jquery-ui-datepicker/**","/webfonts/**");
    }
}
