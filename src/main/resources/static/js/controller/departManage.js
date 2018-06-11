layui.use(['form', 'table', 'laydate', 'laytpl' ,'laypage'], function () {

    var form = layui.form;
    var table = layui.table;
    var laydate = layui.laydate;
    var laytpl = layui.laytpl;
    var laypage = layui.laypage;
    
    var treeObj = {
        isTreeClick :false
    };
     // 获取全部角色功能树
    function allTree(){
        $.ajax({
          url:"/admin/orgdept/tree",
          type:'get',
          success:function(res){
           if(res.flag ==1){
             var treeTData = res.result;
             treeObj.allTree = res.result;
             treeObj.allTree.forEach(function(el){
                if(el.children){
                    el.open = true;
                }else{
                    el.isParent = true;
                }
             })
             initTree();
           }else{
             layer.msg(res.messages);
           }
          }
        });
    };
    allTree();

    // 初始化树
    function initTree(){
        var setting = {
            view: {
                selectedMulti: false
            },
            edit: {
                enable: true,
                showRemoveBtn: false,
                showRenameBtn: false
            },
            data: {
                keep: {
                    parent:true,
                    leaf:true
                },
                simpleData: {
                    enable: true,
                    pIdKey: "parentId",
                },
                key:{
                    children:"children",
                    checked:"checked"
                }
            },
            callback: {
                beforeDrag: beforeDrag,
                onClick: zTreeOnClick
            }
        };
    
        var zNodes =treeObj.allTree;
        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
 
    }
    function beforeDrag(treeId, treeNodes) {
        return false;
    }
    // 点击树时
    function zTreeOnClick(event, treeId, treeNode) {
       
        $("#addDept").hide();
        $("#editDept").show();
        $("#editDeptName").val(treeNode.name);
        $("#editDeptNum").val(treeNode.sort);
        $("#editSave").removeClass("layui-btn-disabled");
        $("#addLeaf").removeClass("layui-btn-disabled");
        $("#addLeaf").addClass("layui-btn-normal");
        $("#remove").removeClass("layui-btn-disabled");
        $("#remove").addClass("layui-btn-warm");
        sonAdd();
    };
    // 添加父级
    $("#addParent").bind("click",function(){
        treeObj.isParent = true;
        $("#addDept").show();
        $("#editDept").hide();
        saveOperate();
        
    });
    
    
    // 添加子级
    function sonAdd(){
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = zTree.getSelectedNodes();
        
        $("#addLeaf").unbind().bind("click",function(){
            if($(this).hasClass("layui-btn-normal")){
               
                if(nodes[0].isParent){
                    treeObj.isParent = false;
                    $("#addDept").show();
                    $("#editDept").hide();
                    saveOperate();
                }else{
                    layer.msg("不能添加子部门")
                }  
            }  
        }); 
    }
    
    
    // 新增取消

    $("#add-cancel").unbind().bind("click",function(){
        $("#addDept").hide();
        $("#editDept").show();
    });

    // 新增保存操作

    function saveOperate(){
        $("#saveInfo").unbind().bind("click",function(e){
            var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
            nodes = zTree.getSelectedNodes(),
            treeNode = nodes[0];
            var pid
            var DeptName =  $("#addDeptName").val();
            var Deptsort =  $("#addDeptNum").val();
            if(!DeptName && !Deptsort){
                layer.msg("输入框不能为空");
                return false;
            };
            if(treeNode){ 
                pid = treeNode.id;
            }else{
                pid=0;
            };

            $.ajax({
                url:"/admin/orgdept/add",
                type:"POST",
                data:JSON.stringify({
                　　"name":DeptName,
                　　"parentId":pid,
                　　"sort":Deptsort
                }),
                success:function (res) { 
                    
                    if(res.flag == 1){
                        allTree();
                        $("#addDept").hide();
                        $("#editDept").show();
                        $("#editSave").addClass("layui-btn-disabled");
                        $("#addLeaf").addClass("layui-btn-disabled");
                        $("#addLeaf").removeClass("layui-btn-normal");
                        $("#remove").addClass("layui-btn-disabled");
                        $("#remove").removeClass("layui-btn-warm"); 
                    }else{
                        layer.msg(res.messages)
                    } 
                }
            });

        });
    };

    //编辑保存
    $("#editSave").unbind().bind("click",function () {  
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = zTree.getSelectedNodes();
        var editDeptName = $("#editDeptName").val();
        var editDeptNum = $("#editDeptNum").val();
        if(nodes.length>0){
            var thisId = nodes[0].id;
            var thisPid = nodes[0].pid;
            
            $.ajax({
                url:"/admin/orgdept/edit",
                type:"POST",
                data:JSON.stringify({
                    "id":thisId,
                　　"name":editDeptName,
                　　"parentId":thisPid,
                　　"sort":editDeptNum
                }),
                success:function (res) { 
                    if(res.flag == 1){
                        allTree(); 
                        $("#editDeptName").val("");
                        $("#editDeptNum").val("");
                        $("#editSave").addClass("layui-btn-disabled");
                        $("#addLeaf").addClass("layui-btn-disabled");
                        $("#addLeaf").removeClass("layui-btn-normal");
                        $("#remove").addClass("layui-btn-disabled");
                        $("#remove").removeClass("layui-btn-warm");
                    }else{
                        layer.msg(res.messages)
                    }
                
                }
            });
        }
        
    });

    // 编辑删除
    $("#remove").unbind().bind("click",function () {  
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = zTree.getSelectedNodes();
        
        if($(this).hasClass("layui-btn-warm")){
             
            var thisId = nodes[0].id;
            $.ajax({
                url:"/admin/orgdept/del/"+thisId,
                type:"get",
                success:function (res) {  
                    if(res.flag == 1){
                        allTree();
                        $("#editDeptName").val("");
                        $("#editDeptNum").val("");
                        $("#editSave").addClass("layui-btn-disabled");
                        $("#addLeaf").addClass("layui-btn-disabled");
                        $("#addLeaf").removeClass("layui-btn-normal");
                        $("#remove").addClass("layui-btn-disabled");
                        $("#remove").removeClass("layui-btn-warm"); 
                    }else{
                        layer.msg(res.messages)
                    } 
                }
            });
        }else{
            
        }
        
    });

    

});