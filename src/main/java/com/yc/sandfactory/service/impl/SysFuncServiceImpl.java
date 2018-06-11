package com.yc.sandfactory.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yc.sandfactory.entity.SysFunc;
import com.yc.sandfactory.service.ISysFuncService;
import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/6/9 上午10:31
 */
@Service
public class SysFuncServiceImpl implements ISysFuncService {

    @Autowired
    private NutDao nutDao;

    @Override
    public List<SysFunc> queryAll() {
        List<SysFunc> query = this.nutDao.query(SysFunc.class, Cnd.orderBy().asc("parentId").asc("sort"));
        Map<Long, SysFunc> funcMap = Maps.newHashMap();
        List<SysFunc> result = Lists.newArrayList();
        for(SysFunc func : query) {
            SysFunc parent = funcMap.get(func.getParentId());
            if(parent == null) {
                funcMap.put(func.getId(), func);
                result.add(func);
            } else {
                List<SysFunc> children = parent.getChild();
                if(children == null) {
                    children = Lists.newArrayList();
                    parent.setChild(children);
                }
                children.add(func);
            }
        }
        return result;
    }

    @Override
    public List<SysFunc> queryFuncs(Long userId) {

        //准备第一级菜单
        List<SysFunc> roots = this.nutDao.query(SysFunc.class, Cnd.where("parentId", "=", 0));

        Map<Long, SysFunc> rootMap = Maps.newHashMap();
        for(SysFunc root : roots) {
            rootMap.put(root.getId(), root);
        }

        Sql sql = Sqls.create("select f.n_id, f.c_name, f.c_icon, f.n_parent_id, f.n_sort, f.c_link " +
                "                from t_sys_user_role ur " +
                "                join t_sys_role_func rf on ur.n_role_id = rf.n_role_id " +
                "                join t_sys_func f on rf.n_func_id = f.n_id " +
                "                where ur.n_user_id = " + userId +
                "                order by n_parent_id asc, n_sort asc");

        sql.setCallback((conn, rs, sql1) -> {
            List<SysFunc> list = Lists.newArrayList();
            while (rs.next()) {
                SysFunc object = nutDao.getEntity(SysFunc.class).getObject(rs, null, "f.");
                list.add(object);
            }
            return list;
        });

        this.nutDao.execute(sql);

        //查询用户的菜单
        List<SysFunc> funcs = sql.getList(SysFunc.class);

//        List<SysFunc> funcs = funcDao.queryFuncsByUserId(userId);

        Map<Long, SysFunc> funcMap = Maps.newHashMap();
        List<SysFunc> result = new ArrayList<SysFunc>();
        for(SysFunc func : funcs) {
            if(func.getParentId() == 0) {
                funcMap.put(func.getId(), func);
                result.add(func);
            } else {
                SysFunc parent = funcMap.get(func.getParentId());
                if(parent == null) {
                    parent = rootMap.get(func.getParentId());
                    funcMap.put(func.getParentId(), parent);
                    result.add(parent);
                }
                List<SysFunc> children = parent.getChild();
                if(children == null) {
                    children = Lists.newArrayList();
                    parent.setChild(children);
                }
                children.add(func);
            }
        }
        return result;
    }
}
