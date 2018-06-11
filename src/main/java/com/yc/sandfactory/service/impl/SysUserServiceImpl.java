package com.yc.sandfactory.service.impl;

import com.google.common.collect.Lists;
import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.entity.RoleFunc;
import com.yc.sandfactory.entity.SysUser;
import com.yc.sandfactory.entity.UserRole;
import com.yc.sandfactory.service.ISysUserService;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.impl.NutDao;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/6/5 下午11:27
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private NutDao nutDao;

    @Override
    public SysUser get(String username, String password) {
        SysUser sysUser = this.nutDao.fetch(SysUser.class, Cnd.where("username", "=", username).and("password", "=", password));
        if(sysUser != null) {
            //查询当前用户有权限的菜单
//            List<String> permissions = funcDao.queryPermissionByUserId(sysUser.getId());
//            sysUser.setPermissions(permissions);
        }
        return sysUser;
    }

    @Override
    public SysUser get(Long id) {
        return this.nutDao.fetch(SysUser.class, Cnd.where("id", "=", id));
    }

    @Override
    public void changePwd(Long id, String password) {
        SysUser sysUser = this.nutDao.fetch(SysUser.class, Cnd.where("id", "=", id));
        sysUser.setPassword(password);
        this.nutDao.update(sysUser);
    }

    @Override
    public boolean add(SysUser user) {
        SysUser sysUser = this.nutDao.fetch(SysUser.class, Cnd.where("username", "=", user.getUsername()));
        if(null != sysUser) {
            return false;
        }
        Trans.exec((Atom) () -> {
            this.nutDao.insert(user);
            List<UserRole> list = new ArrayList<UserRole>();
            for(Long roleId : user.getRoles()) {
                UserRole ur = new UserRole(user.getId(), roleId);
                list.add(ur);
            }
            this.nutDao.insert(list);
        });
        return true;
    }

    @Override
    public void edit(SysUser user) {
        Trans.exec((Atom)() -> {
            this.nutDao.update(SysUser.class, Chain.make("name", user.getName()), Cnd.where("id", "=", user.getId()));

            List<UserRole> userRoles = this.nutDao.query(UserRole.class, Cnd.where("userId", "=", user.getId()));
            this.nutDao.delete(userRoles);

            List<UserRole> urs = Lists.newArrayList();
            for (Long roleId : user.getRoles()) {
                urs.add(new UserRole(user.getId(), roleId));
            }
            this.nutDao.insert(urs);
        });

    }

    @Override
    public Pagination queryUsers(int pageNum, int pageSize) {

        List<SysUser> lists = this.nutDao.query(SysUser.class, null, this.nutDao.createPager(pageNum, pageSize));
        int count = this.nutDao.count(SysUser.class, null);

        Pagination<SysUser> pagination = new Pagination<>();
        pagination.setList(lists);
        pagination.setTotal(count);
        return pagination;
    }

    @Override
    public void resetPwd(Long userId, String password) {
        SysUser sysUser = this.nutDao.fetch(SysUser.class, Cnd.where("id", "=", userId));
    }

    @Override
    public void delete(Long userId) {
        SysUser sysUser = this.nutDao.fetch(SysUser.class, Cnd.where("id", "=", userId));
    }

    @Override
    public void disable(Long userId) {
        SysUser sysUser = this.nutDao.fetch(SysUser.class, Cnd.where("id", "=", userId));
        sysUser.setStatus(SysUser.Status.DIABLE.getValue());
        this.nutDao.update(sysUser);
    }

    @Override
    public void enable(Long userId) {
        SysUser sysUser = this.nutDao.fetch(SysUser.class, Cnd.where("id", "=", userId));
        sysUser.setStatus(SysUser.Status.ENABLE.getValue());
        this.nutDao.update(sysUser);
    }

    @Override
    public List<Long> queryUserRoles(Long userId) {
        List<UserRole> userRoles = this.nutDao.query(UserRole.class, Cnd.where("userId", "=", userId));
        if (!CollectionUtils.isEmpty(userRoles)) {
            List<Long> result = Lists.newArrayList();
            for (UserRole ur : userRoles) {
                result.add(ur.getRoleId());
            }

            return result;
        }

        return null;
    }
}
