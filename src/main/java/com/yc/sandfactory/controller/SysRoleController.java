package com.yc.sandfactory.controller;

import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.bean.ResponseBean;
import com.yc.sandfactory.bean.RoleBean;
import com.yc.sandfactory.entity.SysFunc;
import com.yc.sandfactory.entity.SysRole;
import com.yc.sandfactory.service.ISysFuncService;
import com.yc.sandfactory.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/6/9 上午10:44
 */
@RestController
@RequestMapping("/admin/sysrole")
public class SysRoleController extends BaseController {

    @Autowired
    private ISysRoleService service;

    @Autowired
    private ISysFuncService funcService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseBean list(int pageNum, int pageSize) {
        try {
            Pagination pagination = service.list(pageNum, pageSize);
            return ResponseBean.createSuccess(pagination);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ResponseBean.FAIL;
    }

    @RequestMapping(value = "funcs", method = RequestMethod.GET)
    public ResponseBean queryAllFunc() {
        try {
            List<SysFunc> list = funcService.queryAll();
            return ResponseBean.createSuccess(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ResponseBean.FAIL;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseBean add(@RequestBody RoleBean roleBean) {
        try {
            SysRole role = new SysRole();
            role.setName(roleBean.getName());
            this.service.add(role, roleBean.getFuncs());
            return ResponseBean.SUCCESS;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ResponseBean.FAIL;
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public ResponseBean delRole(@PathVariable Integer id) {
        try {
            if (id != null) {
                this.service.del(id);
                return ResponseBean.SUCCESS;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ResponseBean.FAIL;
    }

    @RequestMapping(value = "rolefunc/{id}", method = RequestMethod.GET)
    public ResponseBean getRoleFunc(@PathVariable Long id) {
        try {
            if (id != null) {
                List<Long> list = this.service.getRoleFunc(id);
                return ResponseBean.createSuccess(list);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ResponseBean.FAIL;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ResponseBean edit(@RequestBody RoleBean roleBean) {
        try {
            SysRole role = new SysRole();
            role.setId(roleBean.getId());
            role.setName(roleBean.getName());
            this.service.update(role, roleBean.getFuncs());
            return ResponseBean.SUCCESS;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ResponseBean.FAIL;
    }
}
