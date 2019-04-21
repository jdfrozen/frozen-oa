package com.frozen.frozenadmin.server;

import com.frozen.frozenadmin.dao.RoleMapper;
import com.frozen.frozenadmin.dao.UserRoleMapper;
import com.frozen.frozenadmin.po.Menu;
import com.frozen.frozenadmin.po.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: frozen
 * @Date: 2019/4/21 08:27
 * @Description:
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    /**
     * 根据用户ID查询用户角色列表
     * @param id
     * @return
     */
    public List<Role> getRolesByUserId(Long id){
        return null;
    }
    /**
     * 根据菜单获取角色
     * @param menu
     * @return
     */
    public List<Role> getRolesByMenu(Menu menu){
        return null;
    }
}
