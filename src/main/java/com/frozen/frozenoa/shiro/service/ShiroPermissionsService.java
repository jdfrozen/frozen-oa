package com.frozen.frozenoa.shiro.service;

import com.frozen.frozenoa.service.SysMenuService;
import com.frozen.frozenoa.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Auther: Frozen
 * @Date: 2019/1/30 16:06
 * @Description: 权限处理
 */
@Service
public class ShiroPermissionsService {
    @Autowired
    SysMenuService sysMenuService;

    @Autowired
    SysRoleService sysRoleService;

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 权限角色
     */

    public Set<String> selectPermsByUserId(Long userId)
    {
        return sysMenuService.selectPermsByUserId(userId);
    }

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
