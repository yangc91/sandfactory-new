package com.yc.sandfactory.controller;

import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.bean.ResponseBean;
import com.yc.sandfactory.config.SysCons;
import com.yc.sandfactory.entity.SysUser;
import com.yc.sandfactory.service.ISysRoleService;
import com.yc.sandfactory.service.ISysUserService;
import com.yc.sandfactory.service.ISystemLogService;
import com.yc.sandfactory.util.Constants;
import com.yc.sandfactory.util.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/6/9 上午10:48
 */
@RestController
@RequestMapping("/admin/sysuser")
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService service;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISystemLogService systemLogService;

    @Autowired
    private SysCons sysCons;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseBean list(int pageNum, int pageSize) {
        try {
            Pagination pagination = service.queryUsers(pageNum, pageSize);
            return ResponseBean.createSuccess(pagination);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ResponseBean.FAIL;
    }

    @RequestMapping(value = "reset/{userId}", method = RequestMethod.GET)
    public ResponseBean resetPwd(@PathVariable Long userId) {
        try {
            this.service.changePwd(userId, DigestUtil.MD5Digest(sysCons.getAdminDefaultPwd(), sysCons.getMd5Salt()));
            systemLogService.addLog(Constants.ENUM_LOG_TYPE.userManagerLog, "重置【"+userId+"】密码成功");
            return ResponseBean.SUCCESS;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ResponseBean.FAIL;
    }

    @RequestMapping(value = "del/{userId}", method = RequestMethod.GET)
    public ResponseBean del(@PathVariable Long userId) {
        try {
            this.service.delete(userId);
            systemLogService.addLog(Constants.ENUM_LOG_TYPE.userManagerLog, "删除【"+userId+"】成功");
            return ResponseBean.SUCCESS;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ResponseBean.FAIL;
    }

    @RequestMapping(value = "disable/{userId}", method = RequestMethod.GET)
    public ResponseBean disable(@PathVariable Long userId) {
        try {
            this.service.disable(userId);
            systemLogService.addLog(Constants.ENUM_LOG_TYPE.userManagerLog, "禁用【"+userId+"】成功");
            return ResponseBean.SUCCESS;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ResponseBean.FAIL;
    }

    @RequestMapping(value = "enable/{userId}", method = RequestMethod.GET)
    public ResponseBean enable(@PathVariable Long userId) {
        try {
            this.service.enable(userId);
            systemLogService.addLog(Constants.ENUM_LOG_TYPE.userManagerLog, "启用【"+userId+"】成功");
            return ResponseBean.SUCCESS;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ResponseBean.FAIL;
    }

    @RequestMapping(value = "roles", method = RequestMethod.GET)
    public ResponseBean roles() {
        try {
            Pagination pagination = roleService.list(null, null);
            return ResponseBean.createSuccess(pagination);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ResponseBean.FAIL;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseBean add(@RequestBody SysUser user) {
        user.setCreateTime(System.currentTimeMillis());
        user.setPassword(DigestUtil.MD5Digest(sysCons.getAdminDefaultPwd(), sysCons.getMd5Salt()));
        user.setStatus(SysUser.Status.ENABLE.getValue());
        if(service.add(user)) {
            systemLogService.addLog(Constants.ENUM_LOG_TYPE.userManagerLog, "添加【"+user.getUsername()+"】成功");
            return ResponseBean.SUCCESS;
        }
        return ResponseBean.createError("账户已经被使用，请更换");
    }

    @RequestMapping(value = "userrole/{userId}", method = RequestMethod.GET)
    public ResponseBean getUserRole(@PathVariable Long userId) {
        try {
            List<Long> list = this.service.queryUserRoles(userId);
            return ResponseBean.createSuccess(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ResponseBean.FAIL;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ResponseBean edit(@RequestBody SysUser user) {
        try {
            service.edit(user);
            systemLogService.addLog(Constants.ENUM_LOG_TYPE.userManagerLog, "编辑【"+user.getUsername()+"】成功");
            return ResponseBean.SUCCESS;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ResponseBean.FAIL;
    }

}
