package com.frozen.frozenoa.shiro.realm;


import com.frozen.frozenoa.po.SysUser;
import com.frozen.frozenoa.shiro.service.ShiroLoginService;
import com.frozen.frozenoa.shiro.service.ShiroPessionService;
import com.frozen.frozenoa.shiro.utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {
    @Autowired
    ShiroLoginService shiroLoginService;
    @Autowired
    ShiroPessionService shiroPessionService;

    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        String password = "";
        if (utoken.getPassword() != null) {
            password = new String(utoken.getPassword());
        }
        SysUser sysUser = shiroLoginService.login(username,password);
        if(sysUser==null){
            throw new UnknownAccountException("账号不存在或者密码错误");
        }
        //放入shiro.调用CredentialsMatcher类中检验密码
        return new SimpleAuthenticationInfo(sysUser, password, this.getClass().getName());
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SysUser user = ShiroUtils.getSysUser();
        // 角色列表
        Set<String> roles;
        // 功能列表
        Set<String> menus;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 管理员拥有所有权限
        if (shiroPessionService.isAdmin(user.getUserId())) {
            info.addRole("admin");
            info.addStringPermission("*:*:*");
        } else {
            roles = shiroPessionService.selectRoleKeys(user.getUserId());
            menus = shiroPessionService.selectPermsByUserId(user.getUserId());
            // 角色加入AuthorizationInfo认证对象
            info.setRoles(roles);
            // 权限加入AuthorizationInfo认证对象
            info.setStringPermissions(menus);
        }
        return info;
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}