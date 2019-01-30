package com.frozen.frozenoa.shiro.service;

import com.frozen.frozenoa.po.SysUser;
import com.frozen.frozenoa.service.SysUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Frozen
 * @Date: 2019/1/30 16:05
 * @Description: 登录处理
 */
@Service
public class ShiroLoginService {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return 用户信息
     */
    public SysUser login(String userName, String password) {
        SysUser user = sysUserService.selectUserByLoginName(userName);
        //用户不存在
        if (user == null) {
            return null;
        }
        //验证登录信息
        if (matches(user, password)) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * 验证登录信息
     *
     * @param user
     * @param newPassword
     * @return
     */
    private boolean matches(SysUser user, String newPassword) {
        return user.getPassword().equals(encryptPassword(user.getLoginName(), newPassword, user.getSalt()));
    }

    /**
     * 密码比较+加盐
     *
     * @param username
     * @param password
     * @param salt
     * @return
     */
    private String encryptPassword(String username, String password, String salt) {
        return new Md5Hash(username + password + salt).toHex().toString();
    }
}
