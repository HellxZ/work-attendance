package com.coder520.common.security;

import com.coder520.user.entity.Permission;
import com.coder520.user.entity.Role;
import com.coder520.user.entity.User;
import com.coder520.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义域
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取拦截到的用户名
        String username = (String)principalCollection.getPrimaryPrincipal();
        //查询该用户
        User user = userService.findUserByUsername(username);
        //授权对象
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //添加角色、权限
        for(Role role:user.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(Permission permission:role.getPermissionList()){
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 认证、登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken =(UsernamePasswordToken)authenticationToken;
        String username = usernamePasswordToken.getUsername();
        User user = userService.findUserByUsername(username);
        if(user==null){
            return null;
        }else {
            //认证对象
            AuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
            //在主体session个中设置用户对象
            SecurityUtils.getSubject().getSession().setAttribute("userinfo",user);
            return info;
        }
    }
}
