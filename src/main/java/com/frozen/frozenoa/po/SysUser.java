package com.frozen.frozenoa.po;


import com.frozen.frozenoa.base.BaseEntity;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 用户对象 sys_user
 * 
 * @author frozen
 */
@ToString
@Data
public class SysUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long userId;

    /** 部门ID */
    private Long deptId;

    /** 部门父ID */
    private Long parentId;

    /** 登录名称 */
    private String loginName;

    /** 用户名称 */
    private String userName;

    /** 用户邮箱 */
    private String email;

    /** 手机号码 */
    private String phonenumber;

    /** 用户性别 */
    private String sex;

    /** 用户头像 */
    private String avatar;

    /** 密码 */
    private String password;

    /** 盐加密 */
    private String salt;

    /** 帐号状态（0正常 1停用） */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 最后登陆IP */
    private String loginIp;

    /** 最后登陆时间 */
    private Date loginDate;

    private List<SysRole> roles;

    /** 角色组 */
    private Long[] roleIds;

    /** 岗位组 */
    private Long[] postIds;

    public boolean isAdmin()
    {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

}
