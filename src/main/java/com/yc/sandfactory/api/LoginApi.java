package com.yc.sandfactory.api;

import com.alibaba.fastjson.JSONObject;
import com.yc.sandfactory.bean.ResponseBean;
import com.yc.sandfactory.config.SysCons;
import com.yc.sandfactory.controller.BaseController;
import com.yc.sandfactory.entity.SysUser;
import com.yc.sandfactory.service.ISysUserService;
import com.yc.sandfactory.service.ISystemLogService;
import com.yc.sandfactory.token.TokenFactory;
import com.yc.sandfactory.util.Constants;
import com.yc.sandfactory.util.DigestUtil;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class LoginApi extends BaseController {
	
	@Autowired
	private ISysUserService userService;
	@Autowired
	private SysCons sysCons;

	@Autowired
	private TokenFactory tokenFactory;

	@Autowired
	private ISystemLogService systemLogService;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseBean login(@RequestBody JSONObject params, HttpServletRequest request) {
		String username = params.getString("username");
		String password = params.getString("password");
		SysUser sysUser = userService.get(username, DigestUtil.MD5Digest(password, sysCons.getMd5Salt()));
		if(sysUser != null) {
//			sysUser.setUsername(null);
			sysUser.setCreateTime(0);
			sysUser.setPassword(null);

			String token = tokenFactory.getOperator().add(sysUser);

			request.setAttribute("loginUser", sysUser);

			systemLogService.addLog(Constants.ENUM_LOG_TYPE.loginLog, "【"+username+"】登录成功");
			return ResponseBean.createSuccess(token);
		}
		return ResponseBean.createError("用户名或密码错误");
	}
}
