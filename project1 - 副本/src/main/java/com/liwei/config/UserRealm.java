package com.liwei.config;


import com.liwei.pojo.User;
import com.liwei.service.UserLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

//自定义的UserRealm用户数据连接域，需要继承AuthorizingRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserLoginService userLoginService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //给用户授予权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前登陆的用户
        Subject subject = SecurityUtils.getSubject();

        //拿到User对象
        User currentUser = (User) subject.getPrincipal();

        //设置权限
        info.addStringPermission(currentUser.getPerms());

        return info;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //将上面的token转换成UserRealm中的token
        UsernamePasswordToken UserToken = (UsernamePasswordToken) token;

        //连接数据库
        User user = userLoginService.LoginSelectUser(UserToken.getUsername());

        if (user == null){ //没有这个人
            return null;
        }

        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser","user");
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
