package com.liwei.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean 创建Shiro过滤的工厂对象
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        //将defaultWebSecurityManager传给ShiroFilterFactoryBean，创建ShiroFilterFactoryBean的对象，调用defaultWebSecurityManager
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //拦截
        //添加Shiro的内置过滤器
        /*
         * anon: 无需认证就能访问
         * authc:    必须认证才能访问
         * user:     必须拥有 记住我 功能才能访问
         * perms:    拥有对某个资源的权限才能访问
         * role:     拥有某个角色权限才能访问
         * */
        Map<String, String> filterMap = new LinkedHashMap<>();

        //授权，正常情况下，没有授权会跳转到未授权页面
        filterMap.put("/Private_page/contact","perms[user:add]");
        filterMap.put("/Private_page/about","perms[user:add]");
        filterMap.put("/Private_page/codes","perms[user:add]");
        filterMap.put("/Private_page/gallery","perms[user:add]");



        filterMap.put("/Public_page/*","anon");
        filterMap.put("/Private_page/*","authc");

        //登出
        filterMap.put("/logout","logout");

        bean.setFilterChainDefinitionMap(filterMap);

        //设置拦截之后登陆跳转
        bean.setLoginUrl("/signin");

        //首页
        bean.setSuccessUrl("/index");

        //未授权页面
        bean.setUnauthorizedUrl("/noauth");


        return bean;
    }


    //DefaultWebSecurityManager 创建默认Wed安全管理器
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        //将userRealm传给DefaultWebSecurityManager，创建DefaultWebSecurityManager的对象，调用userRealm
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    //创建realm对象，需要自定义 第一步
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }


    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }


    /**
     * Shiro生命周期处理器     (固定写法)
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    //整合ShiroDialect：用来整合Shiro 和 thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }


}
