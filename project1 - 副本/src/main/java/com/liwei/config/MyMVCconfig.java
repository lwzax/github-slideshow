package com.liwei.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCconfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("Public_page/index");
        registry.addViewController("/main.html").setViewName("Public_page/index");
        registry.addViewController("/contact.html").setViewName("Private_page/contact");
        registry.addViewController("/about.html").setViewName("Private_page/about");
        registry.addViewController("/codes.html").setViewName("Private_page/codes");
        registry.addViewController("/gallery.html").setViewName("Private_page/gallery");
        registry.addViewController("/signin.html").setViewName("Public_page/signin");
    }
}
