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
        $("#perName").val("");
        $("#addlog").html("");
        //显示添加界面
        layer.open({
          type: 1,
          title: "添加用户",
          content: $('#addPerson'),
          btn: [],
          offset:'100px',
          area: '450px'
        });
        // 获取树
        allTree();
        // 初始化树
        initTree("addTree");
        // 调用接口
        addRole();
      },
      edit:function(index){
        var data = dataObj.search.result[index];
        var thisId = data.id;
        var thisName = data.name;
        $("#editPerName").val(thisName);
        layer.open({
            type: 1,
            title: "编辑用户",
            content: $('#editPerson'),
            btn: [],
            offset:'100px',
            area: '450px'
        });
        // 获取树及树选中的ID
        allTree();
        getRoleTree(thisId);

        // 添加checked
        dataObj.allTree.forEach(function(el){
          dataObj.roleTree.forEach(function(element){
            if(el.id == element){
              el.checked = true
            }
          });
          if(el.child){
            el.child.forEach(function(childEl){
              dataObj.roleTree.forEach(function(element){
                if(childEl.id == element){
                  childEl.checked = true
                }
              });
            });
          }
        });
        // 初始化树
        editInitTree("editTree");
        // 调用接口
        editRole(thisId);
        
      },
      del:function(index){
        var data = dataObj.search.result[index];
        var thisId = data.id;
        layer.open({
          type: 1,
          title: "删除提示",
          content: "<p class='text-center' style='padding:80px 0 60px' >是否删除此角色</p>",
          btn: ["确定","取消"],
          btnAlign:"c",
          area: '450px',
          yes:function(){
            $.ajax({
              type:"get",
              url:"/admin/sysrole/del/"+thisId,
              success:function(res){
                if(res.flag == 1){
                  goPage(1,function(){
                    //给操作按钮绑定事件
                    bindHandleBar();
                    //渲染分页
                    initPage();
                  });
                  layer.closeAll();
                }
              }
            });
          }
      });
        
      }

    };
  
    //跳转到某一页
    function goPage(index, fn){
      $.ajax({
        type: 'GET',
        url: "/admin/sysrole/list",
        data: {
          pageNum: index,
          pageSize: dataObj.page.pageSize,
         
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
  
    
// 树配置
    dataObj.treeSetting={
      view: {
        selectedMulti: false,
        fontCss:{
          "line-height":"20px"
        }
      },
      check: {
        enable: true,
        autoCheckTrigger: true
      },
      data: {
        simpleData: {
            enable: true,
            pIdKey: "parentId"
        },
        key:{
          children:"child"
          
        }
      }
      
    }


    // 新增初始化树
    function initTree(treeDom){
        var showCont = $("#addlog");
        var setting = dataObj.treeSetting;
        setting.callback={
          onCheck: onCheck
        }
        var zNodes =dataObj.allTree;
       
        function onCheck(e, treeId, treeNode) {
            
            var treeObj = $.fn.zTree.getZTreeObj(treeDom);
            var nodes = treeObj.getCheckedNodes(true);
            showCont.html("");
            var str = "";
            for(var i=0;i<nodes.length;i++){
                str +='<li class="wsk_popTreeLi">'+nodes[i].name+'</li>';
            }
            showCont.html(str);
    
            
        };
    
        $(document).ready(function(){
            $.fn.zTree.init($("#"+treeDom), setting, zNodes);
            
        });
    };
    // 编辑初始化树
    function editInitTree(treeDom){
        var showCont = $("#editlog");
        var setting = dataObj.treeSetting;
        setting.callback={
          onCheck: onCheck
        }
        var zNodes =dataObj.allTree;
        
        function onCheck(e, treeId, treeNode) {
            
            var treeObj = $.fn.zTree.getZTreeObj(treeDom);
            var nodes = treeObj.getCheckedNodes(true);
            
            mosaicStr(nodes);
            
        };
        function mosaicStr(nodes){
          showCont.html("");
          var str = "";
          for(var i=0;i<nodes.length;i++){
              str +='<li class="wsk_popTreeLi">'+nodes[i].name+'</li>';
          }
          showCont.html(str);

        };
    
        $(document).ready(function(){
            $.fn.zTree.init($("#"+treeDom), setting, zNodes);
            var treeObj = $.fn.zTree.getZTreeObj(treeDom);
            var nodes = treeObj.getCheckedNodes(true);
            mosaicStr(nodes);
        });
    };
  
    
    // 获取全部角色功能树
    function allTree(){
      $.ajax({
        url:"/admin/sysrole/funcs",
        type:'get',
        // contentType:"application/json",
        async:false,
        success:function(res){
         if(res.flag ==1){
           dataObj.allTree = handleData(res.result);
           
         }else{
           layer.msg(res.messages);
         }
        }
      });
    }

    // 获取角色功能树
    function getRoleTree(id){
      $.ajax({
        url:"/admin/sysrole/rolefunc/"+id,
        type:'get',
        // contentType:"application/json",
        async:false,
        success:function(res){
          if(res.flag ==1){
            dataObj.roleTree = res.result;
            
          }else{
            layer.msg(res.messages);
          }
        }
      });
    }

    // 处理树数据去除ICON
    function handleData(treeTData){
      for(var i=0;i<treeTData.length;i++){    
        delete treeTData[i].icon;
        if(treeTData[i].child){
          //循环child数组
          for(j=0;j<treeTData[i].child.length;j++){
            delete treeTData[i].child[j].icon;
          }
        }
      }
      return treeTData;
    }

    // 新增按钮事件
    function addRole(){
      
      $("#addRoleBtn").unbind().bind("click",function(){
        var treeObj = $.fn.zTree.getZTreeObj("addTree");
        var nodes = treeObj.getCheckedNodes(true);
        var perName = $("#perName").val();
        var arr=[];
        if(nodes.length>0){
          nodes.forEach(function(el){
            arr.push(el.id);
          });
        }
        
        if(perName && nodes.length>0){
          $.ajax({
            url:"/admin/sysrole/add",
            type:"post",
            data:JSON.stringify({
              name:perName,
              funcs:arr
            }),
            success:function(res){
              if(res.flag == 1){
                goPage(1,function(){
                  //给操作按钮绑定事件
                  bindHandleBar();
                  //渲染分页
                  initPage();
                });
                layer.closeAll();
              }else{
                layer.msg(res.messages)
              }
            }
          })
        }else{
          layer.msg("请选择模块或填写角色名称！")
        }
      });
    }
    // 编辑按钮事件
    function editRole(id){
      
      $("#editRoleBtn").unbind().bind("click",function(){
        var treeObj = $.fn.zTree.getZTreeObj("editTree");
        var nodes = treeObj.getCheckedNodes(true);
        var perName = $("#editPerName").val();
        var arr=[];
        if(nodes.length>0){
          nodes.forEach(function(el){
            arr.push(el.id);
          });
        }
        if(perName && nodes.length>0){
          $.ajax({
            url:"/admin/sysrole/edit",
            type:"post",
            data:JSON.stringify({
              id:id,
              name:perName,
              funcs:arr
            }),
            success:function(res){
              if(res.flag == 1){
                goPage(1,function(){
                  //给操作按钮绑定事件
                  bindHandleBar();
                  //渲染分页
                  initPage();
                });
                layer.closeAll();
              }else{
                layer.msg(res.messages)
              }
            }
          })
        }else{
          layer.msg("请选择模块或填写角色名称！")
        }
      });
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