package com.yc.sandfactory.service.impl;

import com.google.common.collect.Lists;
import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.entity.RoleFunc;
import com.yc.sandfactory.entity.SysRole;
import com.yc.sandfactory.service.ISysRoleService;
import org.nutz.dao.Cnd;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/6/9 上午10:36
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private NutDao nutDao;

    @Override
    public SysRole get(long id) {
        return this.nutDao.fetch(SysRole.class, id);
    }

    @Override
    public void add(SysRole role, List<Long> funcs) {

        SysRole insert = this.nutDao.insert(role);

        long roleId = insert.getId();
        List<RoleFunc> list = Lists.newArrayList();
        for(Long funcId : funcs) {
            RoleFunc rf = new RoleFunc(roleId, funcId);
            list.add(rf);
        }

        this.nutDao.insert(list);
    }

    @Override
    public void update(SysRole role, List<Long> funcs) {
        Trans.exec((Atom) () -> {
            nutDao.update(role);
            List<RoleFunc> rfs = nutDao.query(RoleFunc.class, Cnd.where("roleId", "=", role.getId()));
            nutDao.delete(rfs);

            List<RoleFunc> list = Lists.newArrayList();
            for(Long funcId : funcs) {
                RoleFunc rf = new RoleFunc(role.getId(), funcId);
                list.add(rf);
            }
            nutDao.insert(list);
        });
    }

    @Override
    public void del(long id) {
        Trans.exec((Atom) () -> {
            List<RoleFunc> rfs = nutDao.query(RoleFunc.class, Cnd.where("roleId", "=", id));
            nutDao.delete(rfs);
            nutDao.delete(SysRole.class, id);
        });
    }

    @Override
    public void update(SysRole role) {
        this.nutDao.update(role);
    }

    @Override
    public Pagination<SysRole> list(Integer pageNum, Integer pageSize) {
        List<SysRole> lists;
        if (null != pageNum && null != pageSize) {
            Pager pager = nutDao.createPager(pageNum, pageSize);
            lists = this.nutDao.query(SysRole.class, null, pager);
        } else {
            lists = this.nutDao.query(SysRole.class, null);
        }
        int count = this.nutDao.count(SysRole.class, null);

        Pagination<SysRole> pagination = new Pagination<>();
        pagination.setList(lists);
        pagination.setTotal(count);
        return pagination;
    }

    @Override
    public List<Long> getRoleFunc(long id) {

        List<RoleFunc> roleFuncs = this.nutDao.query(RoleFunc.class, Cnd.where("roleId", "=", id));
        if (!CollectionUtils.isEmpty(roleFuncs)) {
            List<Long> result = Lists.newArrayList();
            for (RoleFunc rf : roleFuncs) {
                result.add(rf.getFuncId());
            }

            return result;
        }

        return null;
    }
}
