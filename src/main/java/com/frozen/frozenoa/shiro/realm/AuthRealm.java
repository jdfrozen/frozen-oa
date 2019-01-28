package com.frozen.frozenoa.shiro.realm;


import com.frozen.frozenoa.po.SysUser;
import com.frozen.frozenoa.shiro.service.ShiroMenuService;
import com.frozen.frozenoa.shiro.service.ShiroRoleService;
import com.frozen.frozenoa.shiro.service.ShiroUserService;
import com.frozen.frozenoa.shiro.service.ShiroPasswordService;
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
    ShiroUserService shiroUserService;
    @Autowired
    ShiroPasswordService shiroPasswordService;
    @Autowired
    ShiroMenuService shiroMenuService;
    @Autowired
    ShiroRoleService shiroRoleService;

    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        String newPassword = "";
        if (utoken.getPassword() != null) {
            newPassword = new String(utoken.getPassword());
        }
        SysUser sysUser = shiroUserService.selectUserByLoginName(username);

        shiroPasswordService.matches(sysUser, newPassword);
        //放入shiro.调用CredentialsMatcher类中检验密码
        return new SimpleAuthenticationInfo(username, newPassword, this.getClass().getName());
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
        if (shiroRoleService.isAdmin(user.getUserId())) {
            info.addRole("admin");
            info.addStringPermission("*:*:*");
        } else {
            roles = shiroRoleService.selectRoleKeys(user.getUserId());
            menus = shiroMenuService.selectPermsByUserId(user.getUserId());
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