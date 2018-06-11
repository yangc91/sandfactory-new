/**
 * Created by admin on 2017/10/12.
 */
if(cookieUtil.get('username') == "undefined"){
  window.location.href = "login.html";
}
layui.use(['layer','element','laytpl'], function(){
  var element = layui.element;
  var layer = layui.layer;
  var laytpl = layui.laytpl;
  var dataObj ={
    search:{}
  };
   //初始化用户名
  $("#username").html(cookieUtil.get('username'));
  var Authorization = cookieUtil.get('Token') ;
   
 // 全局设置header
  $(document).ajaxSend(function (event, xhr) {
            
    xhr.setRequestHeader("Authorization","Bearer "+Authorization) ;  
  });
  
// 调用用户菜单权限
  function getMenu(){
    //获取列表
    var menuList = Array.prototype.slice.call($("#menuList li a"));
    $.ajax({
      type: 'GET',
      url: "/admin/anony/index",
      ansyc:false,
      success: function (res) {
         
        if(res.flag == 1){
          if(res.result.funcs.length >0){
            var arr = [];
            res.result.funcs.forEach(function(el){
              arr.push(el.name);
              if(el.child){
                el.child.forEach(function(el_child){
                  arr.push(el_child.name);
                })
              }
            });
            var aa = menuList instanceof Array;
            
            // 对应显示菜单
            menuList.forEach(function(el){
              arr.forEach(function(element){
                if(element == el.innerText){
                  $(el).show();
                }
              });
            });

          }else{
            layer.open({
              titile:"提示",
              btnAlign:"c",
              content:"<p class='text-center mt40 mb40'>该用户没有使用权限</p>",
              area:"540px",
              yes:function(){
                cookieUtil.remove("username");
                cookieUtil.remove("Token");
                window.location.href = "login.html";
              }
            });
          }
         
        }else{
          layer.alert(res.msg)
        }
      }
    });
  }
  getMenu();
 
  //根据浏览器地址选中左侧菜单
  var navId = window.location.hash.slice(1);
  if(navId != "syscount"){
    if($(".nav-" + navId).attr("class").indexOf("layui-nav-item") >= 0){  //是一级菜单
      $(".layui-nav-item").not($(".nav-" + navId)).removeClass("layui-this");
      $(".layui-nav-item dd").removeClass("layui-this");
    }else{
      //是二级菜单，先展开对应的一级菜单
      $(".layui-nav-item").not($(".nav-" + navId).parent().parent()).removeClass("layui-nav-itemed");
      $(".nav-" + navId).parent().parent().addClass("layui-nav-itemed");
      $(".layui-nav-item").removeClass("layui-this");
      $(".layui-nav-item dd").not($(".nav-" + navId)).removeClass("layui-this");
    }
    $(".nav-" + navId).addClass("layui-this");
  }
  

 
  //点击退出按钮
  $("#exit").on('click',function(){
    layer.confirm('是否退出系统？', function (index) {
      //点击确定回调
      cookieUtil.remove("username");
      cookieUtil.remove("Token");
      window.location.href = "login.html";
    });
  });

  //点击logo显示首页
  $("#logo").on('click',function(){
    //是一级菜单
    $(".layui-nav-item").not($(".nav-home")).removeClass("layui-this");
    $(".layui-nav-item dd").removeClass("layui-this");
    $(".nav-home").addClass("layui-this");
  });
 

  //监听hashChange的时候执行路由和隐藏tips
  var oldHashChange = window.onhashchange;
  window.onhashchange = function(){
    oldHashChange();
    layer.closeAll("tips");
  }

});
