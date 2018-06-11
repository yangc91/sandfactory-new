package com.yc.sandfactory.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/6/5 下午11:30
 */
@Component
public class SysCons {
    /**
     * MD5盐值
     */
    @Value("${md5.salt}")
    private String md5Salt;

    /**
     * 管理员默认密码
     */
    @Value("${admin.default.pwd}")
    private String adminDefaultPwd;

    public String getMd5Salt() {
        return md5Salt;
    }

    public String getAdminDefaultPwd() {
        return adminDefaultPwd;
    }
}
