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

    @Value("${ivm.ip}")
    private String ivmIp;

    @Value("${ivm.ip.out}")
    private String ivmIpOut;

    @Value("${ivm.port}")
    private Integer ivmport;

    @Value("${ivm.name}")
    private String ivmName;

    @Value("${ivm.pwd}")
    private String ivmPwd;

    public String getMd5Salt() {
        return md5Salt;
    }

    public String getAdminDefaultPwd() {
        return adminDefaultPwd;
    }

    public String getIvmIp() {
        return ivmIp;
    }

    public void setIvmIp(String ivmIp) {
        this.ivmIp = ivmIp;
    }

    public Integer getIvmport() {
        return ivmport;
    }

    public void setIvmport(Integer ivmport) {
        this.ivmport = ivmport;
    }

    public String getIvmName() {
        return ivmName;
    }

    public void setIvmName(String ivmName) {
        this.ivmName = ivmName;
    }

    public String getIvmPwd() {
        return ivmPwd;
    }

    public void setIvmPwd(String ivmPwd) {
        this.ivmPwd = ivmPwd;
    }

    public String getIvmIpOut() {
        return ivmIpOut;
    }

    public void setIvmIpOut(String ivmIpOut) {
        this.ivmIpOut = ivmIpOut;
    }
}
