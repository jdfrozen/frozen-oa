package com.zjjw.zjjwserver.config.security.authentication;

import com.zjjw.zjjwserver.po.Role;
import com.zjjw.zjjwserver.services.RoleService;
import com.zjjw.zjjwserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zjjw
 * @Date: 2019/4/20 16:41
 * @Description: userDetailsService 认证系统中的用户密码
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.zjjw.zjjwserver.po.User user = userService.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名或者密码不正确");
        }
        String password = user.getPassword();
        boolean enabled = user.getEnabled();
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = roleService.getRolesByUserId(user.getId());
        String[] strArray = roles.toArray(new String[roles.size()]);
        return User.withUsername(username).password(password).roles(strArray).disabled(enabled).accountExpired(true).accountLocked(true).credentialsExpired(true).build();
    }
}
