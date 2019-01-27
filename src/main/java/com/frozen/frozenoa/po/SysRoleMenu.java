package com.frozen.frozenoa.po;


import lombok.Data;
import lombok.ToString;

/**
 * 角色和菜单关联 sys_role_menu
 * 
 * @author frozen
 */
@ToString
@Data
public class SysRoleMenu
{
    /** 角色ID */
    private Long roleId;
    
    /** 菜单ID */
    private Long menuId;

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public Long getMenuId()
    {
        return menuId;
    }

    public void setMenuId(Long menuId)
    {
        this.menuId = menuId;
    }

}
