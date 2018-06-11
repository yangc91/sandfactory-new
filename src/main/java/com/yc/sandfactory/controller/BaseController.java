package com.yc.sandfactory.controller;

import com.yc.sandfactory.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/6/5 下午11:10
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected SysUser getLoginUser(HttpServletRequest request) {
        Object obj = request.getAttribute("loginUser");
        if(obj == null) {
            return null;
        }
        return (SysUser)obj;
    }
}
