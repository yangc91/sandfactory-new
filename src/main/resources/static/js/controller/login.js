/**
 * Created by lhr on 2017/10/12.
 * 登录页面js文件
 */

layui.use(['form','layer'], function () {
  var form = layui.form;//获取form模块
  var layer = layui.layer;
  $(function () {

    var support = (function (input) {
      return function (attr) {
        return attr in input;
      };
    })(document.createElement('input'));

    $('input[placeholder]').placeholder({
      useNative: false,
      hideOnFocus: false,
      style: {
        textShadow: 'none'
      }
    });

    if (!support('autofocus')) {
      $('input[autofocus]').focus();
    }
  });

  form.verify({
    username: function (value, item) { //value：表单的值、item：表单的DOM对象
      if($.trim(value).length == 0){
        return '用户名不能为空';
      }
      if (!new RegExp("^[a-zA-Z0-9_]+$").test(value)) {
        return '用户名只能包含数字字母下划线';
      }
    },
    //我们既支持上述函数式的方式，也支持下述数组的形式
    //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
    pass: function (value, item) { //value：表单的值、item：表单的DOM对象
      if($.trim(value).length == 0){
        return '密码不能为空';
      }
      if (!new RegExp("^[a-zA-Z0-9_]{6,12}").test(value)) {
        return '密码输入错误';
      }
    }
  });
  //监听登录

  $("#login").unbind().bind("click",function(){
    var username= $.trim($("#username").val());
    var password= $.trim($("#password").val());
    $.ajax({
      url:"/admin/public/login",
      type:"post",
      contentType:"application/json",
      dataType: 'json',
      data:JSON.stringify({
        "username":username,
　　    "password":password
      }),
      success:function(res){
         
        if(res.flag==1){
          document.cookie = "username=" + username;
          document.cookie = "Token=" +res.result;
          window.location.href = "index.html";
          
        }else{
          layer.msg(res.message);
        }
      }
    });
  });

  // 回车事件
  $("body").unbind().on("keydown",function(e){
    if(e.keyCode == 13){
      $("#login").trigger("click");
    }
  });

});
