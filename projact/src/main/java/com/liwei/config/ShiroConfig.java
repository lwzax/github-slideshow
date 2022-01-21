package com.liwei.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean Siro过滤的工厂对象 3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //拦截
        //添加Shiro的内置过滤器
        /*
        * anon: 无需认证就能访问
        * authc:    必须认证才能访问
        * user:     必须拥有 记住我 功能才能访问
        * perma:    拥有对某个资源的权限才能访问
        * role:     拥有某个角色权限才能访问
        * */

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/public/*","anon");
        filterMap.put("/authority_page/*","authc");

        bean.setFilterChainDefinitionMap(filterMap);

        //设置拦截之后登陆跳转
        bean.setLoginUrl("/signin");
        return bean;
    }

    //DafaultWebSecurityManager 安全对象 2
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建 realm 对象，需要自定义 1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }



}
