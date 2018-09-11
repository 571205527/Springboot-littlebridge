package com.yh.shiro;

import com.yh.entity.*;
import com.yh.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Realm
 * 类AuthRealm完成根据用户名去数据库的查询,并且将用户信息放入shiro中,供第二个类调用.
 * Created by HR on 2018/5/4.
 */
public class AuthRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(AuthRealm.class);

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userStr = (String) principalCollection.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        User user = userService.findByUserName(userStr);
        List<String> permissions = new ArrayList<>();
        List<String> rolesStr = new ArrayList<>();
        List<Role> roles = user.getRoles();

        if (roles.size() > 0) {
            for (Role role : roles) {
                rolesStr.add(role.getRoleId());
                if (role.getPrivileges().size() > 0) {
                    for (Privilege privilege : role.getPrivileges()) {
                        permissions.add(privilege.getPrivName());
                        log.info("Privilege:------------->>>" + permissions);
                    }
                }
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);//将权限放入shiro中.
        simpleAuthorizationInfo.addRoles(rolesStr);

        return simpleAuthorizationInfo;
    }

    //认证.登录 密码是加盐(username或者自己设置的salt)
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken; //获取用户输入的token

        String username = usernamePasswordToken.getUsername();
        User user = userService.findByUserName(username);

        //放入shiro.调用CredentialsMatcher检验密码
        // ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username
        return new SimpleAuthenticationInfo(username, user.getPassword(), this.getClass().getName());
    }

}
