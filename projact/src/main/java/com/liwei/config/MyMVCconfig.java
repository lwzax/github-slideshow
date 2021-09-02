package com.liwei.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCconfig implements WebMvcConfigurer {
    //ViewResolver 实现了视图解析器接口的类，就可以把它看成视图解析器。
    //自定义一个自的视图解析器MyViewResolver


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main.html").setViewName("index");
        registry.addViewController("/account.html").setViewName("account");
        registry.addViewController("/grape-page.html").setViewName("grape-page");
        registry.addViewController("authority_page/identify.html").setViewName("identify");
        registry.addViewController("/signin.html").setViewName("signin");
        registry.addViewController("/system.html").setViewName("system");
        registry.addViewController("/fruit-page.html").setViewName("fruit-page");
        registry.addViewController("/rice-page.html").setViewName("rice-page");
        registry.addViewController("/wheat-page.html").setViewName("wheat-page");
    }


}
