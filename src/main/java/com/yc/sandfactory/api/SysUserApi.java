package com.yc.sandfactory.api;

import com.alibaba.fastjson.JSONObject;
import com.yc.sandfactory.bean.ResponseBean;
import com.yc.sandfactory.config.SysCons;
import com.yc.sandfactory.entity.SysUser;
import com.yc.sandfactory.service.ISysUserService;
import com.yc.sandfactory.util.DigestUtil;
import com.yc.sandfactory.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project: sandfactory
 * @author: yc
 */
@RestController
@RequestMapping("/api/user")
public class SysUserApi {

  public Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ISysUserService userService;

  @Autowired
  private SysCons sysCons;

  @RequestMapping(value = "updatePwd")
  public ResponseBean updatePwd(@RequestBody JSONObject params) {
    try {

      String oldpwd = params.getString("oldPwd");
      String newPwd = params.getString("newPwd");

      // 获取当前登录人信息
      SysUser user = UserUtil.currentUser();

      // 验证旧密码是否存在
      SysUser sysUser =
          userService.get(user.getUsername(), DigestUtil.MD5Digest(oldpwd, sysCons.getMd5Salt()));
      if (sysUser == null) {
        return ResponseBean.createError("原密码错误");
      }

      //更新新密码
      userService.changePwd(sysUser.getId(), DigestUtil.MD5Digest(newPwd, sysCons.getMd5Salt()));
      return ResponseBean.SUCCESS;
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
    return ResponseBean.FAIL;
  }
}
