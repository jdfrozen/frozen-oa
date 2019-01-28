package com.frozen.frozenoa.service;


import com.frozen.frozenoa.annotation.DataScope;
import com.frozen.frozenoa.constant.UserConstants;
import com.frozen.frozenoa.dao.SysRoleMapper;
import com.frozen.frozenoa.dao.SysUserMapper;
import com.frozen.frozenoa.dao.SysUserRoleMapper;
import com.frozen.frozenoa.po.SysRole;
import com.frozen.frozenoa.po.SysUser;
import com.frozen.frozenoa.po.SysUserRole;
import com.frozen.frozenoa.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysUserService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserService.class);

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    /**
     * 根据条件分页查询用户对象
     * 
     * @param user 用户信息
     * 
     * @return 用户信息集合信息
     */
    
    @DataScope(tableAlias = "u")
    public List<SysUser> selectUserList(SysUser user)
    {
        return userMapper.selectUserList(user);
    }

    /**
     * 通过用户名查询用户
     * 
     * @param userName 用户名
     * @return 用户对象信息
     */
    
    public SysUser selectUserByLoginName(String userName)
    {
        return userMapper.selectUserByLoginName(userName);
    }

    /**
     * 通过手机号码查询用户
     * 
     * @param phoneNumber 手机号码
     * @return 用户对象信息
     */
    
    public SysUser selectUserByPhoneNumber(String phoneNumber)
    {
        return userMapper.selectUserByPhoneNumber(phoneNumber);
    }

    /**
     * 通过邮箱查询用户
     * 
     * @param email 邮箱
     * @return 用户对象信息
     */
    
    public SysUser selectUserByEmail(String email)
    {
        return userMapper.selectUserByEmail(email);
    }

    /**
     * 通过用户ID查询用户
     * 
     * @param userId 用户ID
     * @return 用户对象信息
     */
    
    public SysUser selectUserById(Long userId)
    {
        return userMapper.selectUserById(userId);
    }

    /**
     * 通过用户ID删除用户
     * 
     * @param userId 用户ID
     * @return 结果
     */
    
    public int deleteUserById(Long userId)
    {
        // 删除用户与角色关联
        userRoleMapper.deleteUserRoleByUserId(userId);
        // 删除用户与岗位表
        //userPostMapper.deleteUserPostByUserId(userId);
        return userMapper.deleteUserById(userId);
    }

//    /**
//     * 批量删除用户信息
//     *
//     * @param ids 需要删除的数据ID
//     * @return 结果
//     */
//
//    public int deleteUserByIds(String ids) throws BusinessException
//    {
//        Long[] userIds = Convert.toLongArray(ids);
//        for (Long userId : userIds)
//        {
//            if (SysUser.isAdmin(userId))
//            {
//                throw new BusinessException("不允许删除超级管理员用户");
//            }
//        }
//        return userMapper.deleteUserByIds(userIds);
//    }

//    /**
//     * 新增保存用户信息
//     *
//     * @param user 用户信息
//     * @return 结果
//     */
//
//    public int insertUser(SysUser user)
//    {
//        // 新增用户信息
//        int rows = userMapper.insertUser(user);
//        // 新增用户岗位关联
//        insertUserPost(user);
//        // 新增用户与角色管理
//        insertUserRole(user);
//        return rows;
//    }
//
//    /**
//     * 修改保存用户信息
//     *
//     * @param user 用户信息
//     * @return 结果
//     */
//
//    public int updateUser(SysUser user)
//    {
//        Long userId = user.getUserId();
//        // 删除用户与角色关联
//        userRoleMapper.deleteUserRoleByUserId(userId);
//        // 新增用户与角色管理
//        insertUserRole(user);
//        // 删除用户与岗位关联
//        userPostMapper.deleteUserPostByUserId(userId);
//        // 新增用户与岗位管理
//        insertUserPost(user);
//        return userMapper.updateUser(user);
//    }

    /**
     * 修改用户个人详细信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    
    public int updateUserInfo(SysUser user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 修改用户密码
     * 
     * @param user 用户信息
     * @return 结果
     */
    
    public int resetUserPwd(SysUser user)
    {
        return updateUserInfo(user);
    }

    /**
     * 新增用户角色信息
     * 
     * @param user 用户对象
     */
    public void insertUserRole(SysUser user)
    {
        Long[] roles = user.getRoleIds();
        if (StringUtils.isNotNull(roles))
        {
            // 新增用户与角色管理
            List<SysUserRole> list = new ArrayList<SysUserRole>();
            for (Long roleId : roles)
            {
                SysUserRole ur = new SysUserRole();
                ur.setUserId(user.getUserId());
                ur.setRoleId(roleId);
                list.add(ur);
            }
            if (list.size() > 0)
            {
                userRoleMapper.batchUserRole(list);
            }
        }
    }


    /**
     * 校验用户名称是否唯一
     * 
     * @param loginName 用户名
     * @return
     */
    
    public String checkLoginNameUnique(String loginName)
    {
        int count = userMapper.checkLoginNameUnique(loginName);
        if (count > 0)
        {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    /**
     * 校验用户名称是否唯一
     *
     * @param user 用户信息
     * @return
     */
    
    public String checkPhoneUnique(SysUser user)
    {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkPhoneUnique(user.getPhonenumber());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return UserConstants.USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return
     */
    
    public String checkEmailUnique(SysUser user)
    {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkEmailUnique(user.getEmail());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return UserConstants.USER_EMAIL_NOT_UNIQUE;
        }
        return UserConstants.USER_EMAIL_UNIQUE;
    }

    /**
     * 查询用户所属角色组
     * 
     * @param userId 用户ID
     * @return 结果
     */
    
    public String selectUserRoleGroup(Long userId)
    {
        List<SysRole> list = roleMapper.selectRolesByUserId(userId);
        StringBuffer idsStr = new StringBuffer();
        for (SysRole role : list)
        {
            idsStr.append(role.getRoleName()).append(",");
        }
        if (StringUtils.isNotEmpty(idsStr.toString()))
        {
            return idsStr.substring(0, idsStr.length() - 1);
        }
        return idsStr.toString();
    }



//    /**
//     * 用户状态修改
//     *
//     * @param user 用户信息
//     * @return 结果
//     */
//
//    public int changeStatus(SysUser user)
//    {
//        if (SysUser.isAdmin(user.getUserId()))
//        {
//            throw new BusinessException("不允许修改超级管理员用户");
//        }
//        return userMapper.updateUser(user);
//    }
}
