package com.yc.sandfactory.service;

import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.entity.SysFunc;
import com.yc.sandfactory.entity.SysUser;

import java.util.List;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/6/5 下午11:27
 */
public interface ISysUserService {

    /**
     * 根据用户名和密码获取用户
     * @param username
     * @param password
     * @return
     */
    SysUser get(String username, String password);

    /**
     * 根据ID获得用户
     * @param id
     * @return
     */
    SysUser get(Long id);

    /**
     * 修改密码
     * @param id
     * @param password
     */
    void changePwd(Long id, String password);

    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean add(SysUser user);

    /**
     * 修改用户
     * @param user
     */
    void edit(SysUser user);

    /**
     * 分页查询用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    Pagination queryUsers(int pageNum, int pageSize);

    /**
     * 重置密码
     * @param userId
     * @param password
     */
    void resetPwd(Long userId, String password);

    /**
     * 删除用户
     * @param userId
     */
    void delete(Long userId);

    /**
     * 禁用
     * @param userId
     */
    void disable(Long userId);

    /**
     * 启用
     * @param userId
     */
    void enable(Long userId);

    /**
     * 查询用户角色
     * @param userId
     * @return
     */
    List<Long> queryUserRoles(Long userId);

}
