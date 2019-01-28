package com.frozen.frozenoa.shiro.service;

import com.frozen.frozenoa.service.SysMenuService;
import com.frozen.frozenoa.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: Frozen
 * @Date: 2019/1/28 20:08
 * @Description:
 */
@Service
public class ShiroMenuService {
    @Autowired
    SysMenuService sysMenuService;
    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */

    public Set<String> selectPermsByUserId(Long userId)
    {
        return sysMenuService.selectPermsByUserId(userId);
    }
}
