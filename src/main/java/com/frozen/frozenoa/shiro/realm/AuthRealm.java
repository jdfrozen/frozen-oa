package com.frozen.frozenoa.shiro.realm;


import com.frozen.frozenoa.po.SysUser;
import com.frozen.frozenoa.service.SysUserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private SysUserServiceImpl sysUserService;
    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        SysUser sysUser =  sysUserService.selectUserByLoginName(username);
        //Password
       String password = sysUser.getPassword();
        //放入shiro.调用CredentialsMatcher类中检验密码
        return new SimpleAuthenticationInfo(username, password,this.getClass().getName());
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        //获取session中的用户
        String username=(String) principal.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissions=new ArrayList<>();
//        Set<Role> roles = user.getRoles();
//        if(roles.size()>0) {
//            for(Role role : roles) {
//                Set<Module> modules = role.getModules();
//                if(modules.size()>0) {
//                    for(Module module : modules) {
//                        permissions.add(module.getMname());
//                    }
//                }
//            }
//        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //将权限放入shiro中.
        info.addStringPermissions(permissions);
        return info;
    }

}