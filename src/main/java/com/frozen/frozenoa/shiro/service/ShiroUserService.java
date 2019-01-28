package com.frozen.frozenoa.shiro.service;

import com.frozen.frozenoa.po.SysUser;
import com.frozen.frozenoa.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Frozen
 * @Date: 2019/1/28 20:08
 * @Description:
 */
@Service
public class ShiroUserService {
    @Autowired
    private SysUserService sysUserService;

    public SysUser selectUserByLoginName(String userName)
    {
        return sysUserService.selectUserByLoginName(userName);
    }
}
