package com.yc.sandfactory.controller;

import com.alibaba.fastjson.JSONObject;
import com.yc.sandfactory.bean.ResponseBean;
import com.yc.sandfactory.config.SysCons;
import com.yc.sandfactory.entity.SysUser;
import com.yc.sandfactory.service.ISysUserService;
import com.yc.sandfactory.token.TokenFactory;
import com.yc.sandfactory.util.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/public")
public class LoginController extends BaseController {
	
	@Autowired
	private ISysUserService userService;
	@Autowired
	private SysCons sysCons;

	@Autowired
	private TokenFactory tokenFactory;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseBean login(@RequestBody JSONObject params) {
		String username = params.getString("username");
		String password = params.getString("password");
		SysUser sysUser = userService.get(username, DigestUtil.MD5Digest(password, sysCons.getMd5Salt()));
		if(sysUser != null) {
//			sysUser.setUsername(null);
			sysUser.setCreateTime(0);
			sysUser.setPassword(null);

			String token = tokenFactory.getOperator().add(sysUser);
			return ResponseBean.createSuccess(token);
		}
		return ResponseBean.createError("用户名或密码错误");
	}
}
