package com.yc.sandfactory.util;

import com.yc.sandfactory.entity.SysUser;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author: yc
 * @date: 2018-7-15.
 */
public class UserUtil {

  private static Logger logger = LoggerFactory.getLogger(UserUtil.class);

  public static SysUser currentUser() {
    HttpServletRequest request =
        ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    SysUser user = null;
    try {

      user = (SysUser) request.getAttribute("loginUser");
      user.setCurIp(request.getRemoteAddr());
    } catch (Exception e) {
      logger.error("未获取到当前用户信息", e);
    }

    return user;
  }
}