package com.frozen.frozenoa.shiro.service;

import com.frozen.frozenoa.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Auther: Frozen
 * @Date: 2019/1/28 20:08
 * @Description:
 */
@Service
public class ShiroRoleService {
    @Autowired
    SysRoleService sysRoleService;

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */

    public Set<String> selectRoleKeys(Long userId)
    {
        return sysRoleService.selectRoleKeys(userId);
    }

    /**
     * 是否是管理员判断
     * @param userId
     * @return
     */
    public boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

}
