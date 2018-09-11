package com.yh.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * CredentialsMatcher,完成对于密码的校验.其中用户的信息来自shiro.AuthRealm类
 * Created by HR on 2018/5/4.
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
        String password = new String(usernamePasswordToken.getPassword());

        //获得数据库中的密码
        String dbPassword = (String) info.getCredentials();

        //进行密码的比对
        return this.equals(password, dbPassword);
    }
}
