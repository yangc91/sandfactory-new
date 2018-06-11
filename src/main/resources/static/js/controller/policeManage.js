/**
 * Created by admin on 2017/10/12.
 */
layui.use(['form', 'table', 'laydate', 'laytpl' ,'laypage'], function () {
    var dataObj = {
      page: {
        pageSize: 10,
        pageNo: 1
      },
      search: {
        sex: "",
        keyword: "",
        regDate: ""
      },
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
        
        //动态给新生成的下拉框添加规则校验
        $("#perCountry+div input").rules("add", {required: true, messages: {required: '请选择城市'}});
        //显示添加界面
        layer.open({
          type: 1,
          title: "添加用户",
          content: $('#addPerson'),
          btn: [],
          area: '450px'
        });

      },
    //   编辑用户
      edit:function(index){
        var data = dataObj.search.result[index];
        layer.open({
            type: 1,
            title: "编辑用户",
            content: $('#editPerson'),
            btn: [],
            area: '450px'
        });
  
          
      },
    //   重置密码
      resetPas:function (index) {  
        var data = dataObj.search.result[index];
        layer.open({
            type: 1,
            title: "重置密码",
            content: "<p class='mt20 text-center'>是否重置密码</p>",
            // btn: [],
            area: '450px',
            yes:function(){
                $.ajax({
                    type:"",
                    url:"",
                    data:{},
                    success:function(){
        
                    }
                }); 
            }
        });
      },
    //   删除操作
      del:function(index){
        var data = dataObj.search.result[index];
        layer.open({
            type: 1,
            title: "删除提示",
            content: "<p class='text-center' style='padding:80px 0 60px' >是否删除此用户</p>",
            btn: ["确定","取消"],
            btnAlign:"c",
            area: '450px',
            yes:function(){
                $.ajax({
                    type:"",
                    url:"",
                    data:{},
                    success:function(){
        
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
        url: "js/test/table1.json",
        data: {
          pageNo: index,
          pageSize: dataObj.page.pageSize,
          sex: dataObj.search.sex,
          keyword: dataObj.search.keyword,
          regDate: dataObj.search.regDate
        },
        success: function (res) {
          if(res.status == 200){
            dataObj.search.result = res.list;
            dataObj.page.pageTotal = res.total;
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
        layout: ['prev','page','next','skip','limit'],
        jump: function (obj, first) {
          //更新每页显示的条数
          dataObj.page.pageSize = obj.limit;
          if (!first) {
            goPage(obj.curr);
          }
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