/**
 * Created by lhr on 2017/10/12.
 * 登录后框架入口js文件
 * 包含路由配置、公用方法
 */
(function(){
  //cookie设置读取
  function cookieUtil(){}
  cookieUtil.prototype.getCookies = function(){
    var cookies = {};
    if (document.cookie) {
      var objs = document.cookie.split('; ');
      for (var i = 0 ; i < objs.length ; i ++) {
        var name = objs[i].split("=")[0],
            value = objs[i].split("=")[1];
        cookies[name] = value;
      }
    }
    return cookies;
  };
  cookieUtil.prototype.set = function(name, value, opts){
    if (name && value) {
      var cookie = encodeURIComponent(name) + '=' + encodeURIComponent(value) + ";path=/";
      //可选参数
      if (opts) {
        if (opts.maxAge) {
          cookie += '; max-age=' + opts.maxAge;
        }
        if (opts.path) {
          cookie += '; path=' + opts.path;
        }
        if (opts.domain) {
          cookie += '; domain=' + opts.domain;
        }
        if (opts.secure) {
          cookie += '; secure';
        }
      }
      document.cookie = cookie;
      return cookie;
    } else {
      return '';
    }
  };
  cookieUtil.prototype.get = function(name){
    return decodeURIComponent(this.getCookies()[name]) || null;
  };
  cookieUtil.prototype.remove = function(name){
    if (this.getCookies()[name]) {
      document.cookie = name + '=; max-age=0';
    }
  };
  window.cookieUtil = new cookieUtil();

  //定义页面需要用到的字典数据
  var dictionary = {
    
  };
  window.dictionary = dictionary;

  //路由配置
  vipspa.start({
    view: '#ui-view',
    router: {
      'deptManage':{
        templateUrl:'view/departManage.html',  //系统管理之部门管理
        controller:'js/controller/departManage.js'
      },
      'userManage':{
          templateUrl:'view/userManage.html',  //系统管理之用户管理
          controller:'js/controller/userManage.js'
      },
        'roleManage':{
        templateUrl:'view/roleManage.html',  //系统管理之角色管理
        controller:'js/controller/roleManage.js'
      },
      'logManage':{
        templateUrl:'view/logManage.html',  //系统管理之日志管理
        controller:'js/controller/logManage.js'
      },

      'videoManage':{
        templateUrl:'view/video/newVideo.html',  //视频管理
        controller:'js/controller/videoManage.js'
      },

      'recordList':{
        templateUrl:'view/recordList.html',  //称重管理之称重列表
        controller:'js/controller/recordList.js'
      },
        'recordNew':{
            templateUrl:'view/recordNew.html',  //称重管理之最新称重
            controller:'js/controller/recordNew.js'
        },

      'noData':{
        templateUrl:'view/noData.html',  //无数据
        controller:'js/controller/noData.js'
      },

      'welcome':{
        templateUrl:'view/welcome.html',  //欢迎页面
        controller:'js/controller/welcome.js'
      },

      'syscount':{
        templateUrl:'view/syscount.html',  //欢迎页面
        controller:'js/controller/syscount.js'
      },

      'defaults': 'syscount' //默认路由
    },
    errorTemplateId: '#error'  //可选的错误模板，用来处理加载html模块异常时展示错误内容
  });

  /**
   * 对Date的扩展，将 Date 转化为指定格式的String
   * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符
   * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
   * eg:
   * (new Date()).format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
   * (new Date()).format("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04
   * (new Date()).format("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04
   * (new Date()).format("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04
   * (new Date()).format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
   */
  Date.prototype.format=function(fmt) {
    var o = {
      "M+" : this.getMonth() + 1, //月份
      "d+" : this.getDate(), //日
      "h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时
      "H+" : this.getHours(), //小时
      "m+" : this.getMinutes(), //分
      "s+" : this.getSeconds(), //秒
      "q+" : Math.floor((this.getMonth()+3)/3), //季度
      "S" : this.getMilliseconds() //毫秒
    };
    var week = {
      "0" : "\u65e5",
      "1" : "\u4e00",
      "2" : "\u4e8c",
      "3" : "\u4e09",
      "4" : "\u56db",
      "5" : "\u4e94",
      "6" : "\u516d"
    };
    if(/(y+)/.test(fmt)){
      fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    if(/(E+)/.test(fmt)){
      fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);
    }
    for(var k in o){
      if(new RegExp("("+ k +")").test(fmt)){
        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
      }
    }
    return fmt;
  };


  //ajax拦截器
  var layer;
//配置全局拦截器
  layui.use('layer', function () {
    layer = layui.layer;
    layer.config({
      resize: false//默认不可拉伸
    });
    $.ajaxPrefilter(function (options,originalOptions,jqXHR) {
      // options对象 包括accepts、crossDomain、contentType、url、async、type、headers、error、dataType等许多参数选项
      // originalOptions对象 就是你为$.ajax()方法传递的参数对象，也就是 { url: "/index.php" }
      // jqXHR对象 就是经过jQuery封装的XMLHttpRequest对象(保留了其本身的属性和方法)
      // debugger
      options.timeout = 60000;
      options.dataType = "json";
      options.cache = false;

      // 是否为表单提交 == FormData
     
      var isForm = originalOptions.data instanceof FormData;

      if(options.global){
        if(!isForm){
          options.contentType = "application/json";
        }
        
        options.headers = {
          //"Authorization": cookieObj.get("ticket") == "undefined" ? "" : cookieObj.get("ticket")
        }
      }

    });
    $(document).ajaxStart(function () {

    }).ajaxSend(function (event, request, settings) {

    }).ajaxError(function (event, xhr, options, exc) {
      var status = xhr.status;
      if (status == 401) {
        layer.ready(function () {
          layer.open({
            title: '提示'
            , content: '页面已过期，请重新登录'
            , yes: function (index) {
              window.location.href = "login.html";
              layer.close(index);
            }
          });
        });
      } else if (status == 403) {
        layer.ready(function () {
          layer.open({
            title: '提示'
            , content: '页面已过期，请重新登录'
            , yes: function (index) {
              window.location.href = "login.html";
              layer.close(index);
            }
          });
        });
      } else if (status == 413) {
        layer.ready(function () {
          layer.open({
            title: '提示'
            , content: '文件太大，请重新选择'
          });
        });
      } else if (status == 404) {
        layer.ready(function () {
          layer.open({
            title: '提示'
            , content: '请求地址不存在'
          });
        })

      } else if (status == 500) {
        layer.ready(function () {
          layer.open({
            title: '提示'
            , content: '服务器内部异常'
          });
        })
      } else if (status == 502) {
        layer.ready(function () {
          layer.open({
            title: '提示'
            , content: '服务未启动，请先检查服务状态'
          });
        });
      } else if (status == 503) {
        layer.ready(function () {
          layer.open({
            title: '提示'
            , content: '服务器已超载或维护中导致请求无法完成'
          });
        });
      } else if (status == 504) {
        layer.ready(function () {
          layer.open({
            title: '提示'
            , content: '请求超时,请稍候重试'
          });
        });
      } else {
        layer.ready(function () {
          layer.open({
            title: '提示'
            , content: '网络异常'
          });
        });
      }
    }).ajaxComplete(function () {
      layer.ready(function () {
        layer.closeAll('loading');
      });
    });
  });

})();

