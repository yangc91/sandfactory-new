package com.yc.sandfactory.controller;

import com.alibaba.fastjson.JSONObject;
import com.yc.sandfactory.bean.IndexBean;
import com.yc.sandfactory.bean.ResponseBean;
import com.yc.sandfactory.config.SysCons;
import com.yc.sandfactory.entity.SysUser;
import com.yc.sandfactory.service.ISysFuncService;
import com.yc.sandfactory.service.ISysUserService;
import com.yc.sandfactory.util.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/6/6 上午12:02
 */
@RestController
@RequestMapping("/admin/anony")
public class IndexController extends BaseController {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysFuncService sysFuncService;

    @Autowired
    private SysCons sysCons;

    @RequestMapping(value="index", method=RequestMethod.GET)
    public ResponseBean index(HttpServletRequest request) {
        SysUser sysUser = getLoginUser(request);
        IndexBean indexBean = new IndexBean(sysUser.getName(), sysFuncService.queryFuncs(sysUser.getId()));
        return ResponseBean.createSuccess(indexBean);
    }

    @RequestMapping(value="changePwd")
    public ResponseBean changePwd(@RequestBody JSONObject params,
                                  HttpServletRequest request) {
        String oldPwd = params.getString("oldPwd");
        String newPwd = params.getString("newPwd");
        SysUser sysUser = this.getLoginUser(request);
        if(null == this.userService.get(sysUser.getUsername(), DigestUtil.MD5Digest(oldPwd, sysCons.getMd5Salt()))) {
            return ResponseBean.createError("原密码不正确，请确认");
        }
        this.userService.changePwd(sysUser.getId(), DigestUtil.MD5Digest(newPwd, sysCons.getMd5Salt()));
        return ResponseBean.createSuccess("");
    }
}
