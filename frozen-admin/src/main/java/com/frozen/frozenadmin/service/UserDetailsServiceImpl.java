package com.frozen.frozenadmin.service;

import com.frozen.frozenadmin.dao.User;
import com.frozen.frozenadmin.dao.Userdao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService  {
    Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private Userdao userdao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {
        User user = userdao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        System.out.println(user.getAuthorities());
        return user;
    }

}