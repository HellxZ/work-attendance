package com.coder520.common.security;

import com.coder520.common.utils.MD5Utils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * 自定义证书匹配，密码匹配
 */
public class CustomerCredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        try {
            UsernamePasswordToken usertoken = (UsernamePasswordToken) authenticationToken;
            //获取密码转换String
            String password = String.valueOf(usertoken.getPassword());
            //加密所输入的密码
            Object tokenCredentials = MD5Utils.encryptPwd(password);
            //获取该用户密码
            Object accountCredentials =getCredentials(authenticationInfo);
            //判断二者是否相同
            return equals(tokenCredentials,accountCredentials);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
