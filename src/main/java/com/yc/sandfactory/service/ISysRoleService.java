package com.yc.sandfactory.service;

import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.entity.SysRole;

import java.util.List;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/6/9 上午10:35
 */
public interface ISysRoleService {

    SysRole get(long id);

    void add(SysRole role, List<Long> funcs);

    void update(SysRole role, List<Long> funcs);

    void del(long id);

    void update(SysRole role);

    Pagination<SysRole> list(Integer pageNum, Integer pageSize);

    List<Long> getRoleFunc(long id);
}
