/**
 * Created by lhr on 2017/7/29.
 * 扩展jquery.validate.js 方法
 */

jQuery.validator.addMethod('username', function(value, element) {
    var reg = /^[\da-zA-Z]{2,16}$/;
    return this.optional(element) || (reg.test(value));
}, "2-16位英文字母数字");
jQuery.validator.addMethod('pwd', function(value, element) {
    var reg = /^[\da-zA-Z]{6,16}$/;
    if(reg.test(value)){
        if(value.search(/\d/) >= 0 && value.search(/[a-zA-Z]/) >= 0){
            return this.optional(element) || true;
        }
    }
    return this.optional(element) || false;
}, "6-16位英文数字，同时包含数字和英文");
jQuery.validator.addMethod('telephone', function(value, element) {
    var reg = /^[1]([3]|[4]|[5]|[7]|[8]|[9])\d{9}$/;
    return this.optional(element) || (reg.test(value));
}, "请输入合法的手机号码");
jQuery.validator.addMethod('pkgName', function(value, element) {
    var reg = /^([\da-zA-Z]+\.)+[\da-zA-Z]+$/;
    return this.optional(element) || (reg.test(value));
}, "请输入合法的应用包名");
jQuery.validator.addMethod('fingerCert', function(value, element) {
    var reg = /^([\da-zA-Z]{2}:){19}[\da-zA-Z]{2}$/;
    return this.optional(element) || (reg.test(value));
}, "请输入合法的证书指纹SHA1");
jQuery.validator.addMethod('email', function(value, element) {
    var reg = /^.*?@.*?\.(com|cn)$/;
    return this.optional(element) || (reg.test(value));
}, "请输入合法的邮箱地址");
jQuery.validator.addMethod('notEmpty', function(value, element) {
    if(value.trim().length == 0){
        return this.optional(element) || false;
    }
    return this.optional(element) || true;
}, "请输入内容");