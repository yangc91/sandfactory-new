/**
 * Created by admin on 2017/10/12.
 */
layui.use(['form', 'table', 'laydate', 'laytpl' ,'laypage'], function () {
    var dataObj = {
      page: {
        pageSize: 10,
        pageNo: 1
      },
      search: {},

    };
  
    var form = layui.form;
    var table = layui.table;
    var laydate = layui.laydate;
    var laytpl = layui.laytpl;
    var laypage = layui.laypage;
    //渲染下拉框，避免路由切换后下拉框空白问题
    form.render('select');
    form.render('radio');
  
    //一些方法
    var $ = layui.$, active = {
     
      //定义添加方法
      addPer: function () {
        $("#addperName").val("");
        $("#addAccount").val("");
        //显示添加界面
        layer.open({
          type: 1,
          title: "添加用户",
          content: $('#addPerson'),
          btn: [],
          area: '450px'
        });
        getAllUserRole();
        allUserRoleView();
        // 提交事件 
        $("#addUserBtn").unbind().bind("click",function(){
          var arr=[]; 
          var addPerName = $("#addperName").val();
          
          var addAccount = $("#addAccount").val();
          $("input:checkbox[name='add']:checked").each(function() { // 遍历name=standard的多选框
             
              arr.push($(this).val());
          });
          
          if(arr.length>0 && addPerName && addAccount){
            $.ajax({
              type:"post",
              url:"/admin/sysuser/add",
              // contentType : "application/json",
              data:JSON.stringify({
                "username":addAccount,
            　　"name":addPerName,
            　　"roles":arr
              }),
              success:function(res){
                if(res.flag ==1){
                  goPage(1,function(){
                    //给操作按钮绑定事件
                    bindHandleBar();
                    //渲染分页
                    initPage();
                  });
                  
                  layer.closeAll();
                }else{
                  layer.msg(res.messages);
                }  
                
              }
            });
          }else{
            layer.msg("账号或姓名或角色不能为空")
          }
        });

      },
    //   编辑用户
      edit:function(index){
        var data = dataObj.search.result[index];
        var thisId = data.id;
        var username = data.username;
        var name = data.name;
        $("#editAccount").val(username);
        $("#editPerName").val(name);
        $("#editCheckboxList").html("");
        layer.open({
            type: 1,
            title: "编辑用户",
            content: $('#editPerson'),
            btn: [],
            area: '450px'
        });
  
        getAllUserRole();
        getUserRole(thisId);
        userRoleView();

      // 提交事件 
        $("#editUserBtn").unbind().bind("click",function(){
          var arr=[];
          var editPerName = $("#editPerName").val();
          $("input:checkbox[name='edit']:checked").each(function() { // 遍历name=standard的多选框
             
              arr.push($(this).val());
          });
          
          if(arr.length>0 && editPerName){
            $.ajax({
              type:"post",
              url:"/admin/sysuser/edit",
              // contentType : "application/json",
              data:JSON.stringify({
                "id":thisId,
            　　"name":editPerName,
            　　"roles":arr
              }),
              success:function(res){
                if(res.flag ==1){
                  goPage(1,function(){
                    //给操作按钮绑定事件
                    bindHandleBar();
                    //渲染分页
                    initPage();
                  });
                  
                  layer.closeAll();
                }else{
                  layer.msg(res.messages);
                }  
                
              }
          });
          }
        });

      },
    //   重置密码
      resetPas:function (index) {  
        var data = dataObj.search.result[index];
        var thisId =data.id;
        layer.open({
            type: 1,
            title: "重置密码",
            content: "<p class='text-center' style='padding:80px 0 60px' >是否将此用户密码重置</p>",
            btn: ["确定","取消"],
            btnAlign:"c",
            area: '450px',
            yes:function(){
              $.ajax({
                  type:"get",
                  url:"/admin/sysuser/reset/"+thisId,
                  success:function(res){
                    if(res.flag ==1){
                      goPage(1,function(){
                        //给操作按钮绑定事件
                        bindHandleBar();
                        //渲染分页
                        initPage();
                      });
                      layer.close(layer.index)
                      layer.msg("重置成功");
                     
                    }else{
                      layer.msg(res.messages);
                    }  
                    
                  }
              }); 
            }
        });
      },
    //   删除操作
      del:function(index){
        var data = dataObj.search.result[index];
        var thisId =data.id;
        layer.open({
            type: 1,
            title: "删除提示",
            content: "<p class='text-center' style='padding:80px 0 60px' >是否删除此用户</p>",
            btn: ["确定","取消"],
            btnAlign:"c",
            area: '450px',
            yes:function(){
              $.ajax({
                  type:"get",
                  url:"/admin/sysuser/del/"+thisId,
                  success:function(res){
                    if(res.flag ==1){
                      goPage(1,function(){
                        //给操作按钮绑定事件
                        bindHandleBar();
                        //渲染分页
                        initPage();
                      });
                      layer.close(layer.index)
                      layer.msg("删除成功");
                      }else{
                        layer.msg(res.messages);
                    } 
                  }
              }); 
            }
        });
      },
      startOrEnd:function(index){
        var data = dataObj.search.result[index];
        var thisId =data.id;
        var status = $(this).attr("data-status");
        if(status ==1){
          layer.open({
            type: 1,
            title: "禁用提示",
            content: "<p class='text-center' style='padding:80px 0 60px' >是否禁用此用户</p>",
            btn: ["确定","取消"],
            btnAlign:"c",
            area: '450px',
            yes:function(){
              $.ajax({
                  url:"/admin/sysuser/disable/"+thisId,
                  type:"get",
                  success:function(res){
                    if(res.flag ==1){
                      goPage(1,function(){
                        //给操作按钮绑定事件
                        bindHandleBar();
                        //渲染分页
                        initPage();
                      });
                      layer.closeAll();
                    }else{
                      layer.msg(res.messages);
                    }  
                    
                  }
              }); 
            }
          });
        }else{
          layer.open({
            type: 1,
            title: "启用提示",
            content: "<p class='text-center' style='padding:80px 0 60px' >是否启用此用户</p>",
            btn: ["确定","取消"],
            btnAlign:"c",
            area: '450px',
            yes:function(){
                $.ajax({
                    url:"/admin/sysuser/enable/"+thisId,
                    type:"get",
                    success:function(res){
                      if(res.flag ==1){
                        goPage(1,function(){
                          //给操作按钮绑定事件
                          bindHandleBar();
                          //渲染分页
                          initPage();
                        });
                        layer.closeAll();
                      }else{
                        layer.msg(res.messages);
                      }
                    }
                }); 
            }
          });
        }
      }

    };
  
    //跳转到某一页
    function goPage(index, fn){
      $.ajax({
        type: 'GET',
        url: "/admin/sysuser/list",
        data: {
          pageNum: index,
          pageSize: dataObj.page.pageSize
        },
        success: function (res) {
          
          if(res.flag == 1){
            
            dataObj.search.result = res.result.list;
          
            dataObj.page.pageTotal = res.result.total;
            var searchTpl = searchModule.innerHTML,
                searchDataView = document.getElementById("searchDataView");
            laytpl(searchTpl).render(dataObj.search.result, function (html) {
              searchDataView.innerHTML = html;
              form.render('checkbox');
            });
            //渲染数据后回调
            if(fn && (typeof fn == "function")){
              fn();
            }
          }else{
            layer.alert(res.msg)
          }
        }
      });
    }
  
    //渲染分页
    function initPage(){
      laypage.render({
        elem: 'pager',
        count: dataObj.page.pageTotal,//数据总数目
        limit: dataObj.page.pageSize,//每页显示条数
        groups: 5,//连续显示分页数目
        layout: ['prev','page','next'],
        jump: function (obj, first) {
          //更新每页显示的条数
          dataObj.page.pageSize = obj.limit;
          if (!first) {
            goPage(obj.curr);
          }
        }
      });
    }
  
    

    // 获取全部用户角色列表
    function getAllUserRole(){
      $.ajax({
        url:"/admin/sysuser/roles/",
        type:"get",
        // contentType : "application/json",
        async:false,
        success:function(res){
          if(res.flag ==1){
            dataObj.allUserRole = res.result.list;
          }else{
            layer.msg(res.messages);
          }
          
        }
      }); 
    }
    // 获取当前用户角色列表
    function getUserRole(id){
      $.ajax({
        url:"/admin/sysuser/userrole/"+id,
        type:"get",
        async:false,
        success:function(res){
          
          if(res.flag ==1){
            dataObj.userRole = res.result;
          }else{
            layer.msg(res.messages);
          }
          
        }
      });
    }
    // 处理当前用户角色列表显示

    function userRoleView() {
      var allUserRole = dataObj.allUserRole;
      var userRole = dataObj.userRole;
      
      $("#editCheckboxList").html(" ");
      var roleStr ='';
      
      allUserRole.forEach(function(allEl){
        
        userRole.forEach(function(thisEl){
          
          if(thisEl == allEl.id){
            allEl.checked = "checked";
          }
        });

        if(allEl.checked){
          roleStr += '<input type="checkbox" value="'+allEl.id+'" name="edit" title="'+allEl.name+'" lay-skin="primary" checked> '
        }else{
          roleStr += '<input type="checkbox" value="'+allEl.id+'" name="edit" title="'+allEl.name+'" lay-skin="primary"> '
        }

      });
      
      $("#editCheckboxList").html(roleStr);
      form.render('checkbox');
      
    }
    //处理全部角色列表显示
    function allUserRoleView() {
      var allUserRole = dataObj.allUserRole;
      var userRole = dataObj.userRole;
      
      var roleStr ='';
      for(var i=0;i<allUserRole.length;i++){ 
        roleStr += '<input type="checkbox" value="'+allUserRole[i].id+'" name="add" title="'+allUserRole[i].name+'" lay-skin="primary"> '
      }
      $("#addCheckboxList").html(roleStr);
      form.render('checkbox');
      
    }
    
     //表格操作栏目点击入口
    function activeItem(type,index){
      active[type] ? active[type].call(this,index) : "";
    }
  
    //操作栏绑定事件方法
    function bindHandleBar(){
      $(".handle-td a").unbind().on('click', function () {
        var type = $(this).data('type');
        var index = $(this).data('id');
        active[type] ? active[type].call(this,index) : "";
      });
    }

    //绑定表格外事件
    $(".batchBar .layui-btn").unbind().on('click', function () {
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : "";
    });

    
    //弹出页面点击取消
    $(".page-cancel").unbind().on('click', function () {
      layer.closeAll('page');
    });
  
    //进入页面请求数据列表
    $(function(){
      goPage(1,function(){
        //给操作按钮绑定事件
        bindHandleBar();
        //渲染分页
        initPage();
      });
    });
  
  });