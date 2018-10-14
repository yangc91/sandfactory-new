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
            startTime:"",
            endTime:"",
            xh:"",
            ch:"",
            sh:"",
            fh:"",
            crlx:""
        }
    };

    var form = layui.form;
    var table = layui.table;
    var laydate = layui.laydate;
    var laytpl = layui.laytpl;
    var laypage = layui.laypage;
    //渲染下拉框，避免路由切换后下拉框空白问题
    form.render('select');
    form.render('radio');
    laydate.render({
        elem: '#startTime'
    });
    laydate.render({
        elem: '#endTime'
    });

    //一些方法
    var $ = layui.$, active = {
    };

    //跳转到某一页
    function goPage(index, fn){
        $.ajax({
            type: 'GET',
            url: "/admin/record/list",
            data: {
                pageNum: index,
                pageSize: dataObj.page.pageSize,
                startTime:dataObj.search.startTime,
                endTime:dataObj.search.endTime,
                xh:dataObj.search.xh,
                ch:dataObj.search.ch,
                sh:dataObj.search.sh,
                fh:dataObj.search.fh,
                crlx:dataObj.search.crlx
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

    // 回车键搜索
    $("input[name='xh']").keydown(function(event) {
        enter(event)
    });
    $("input[name='ch']").keydown(function(event) {
        enter(event)
    });
    $("input[name='sh']").keydown(function(event) {
        enter(event)
    });
    $("input[name='fh']").keydown(function(event) {
        enter(event)
    });

    function enter(event) {
        var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        if (keyCode == 13) {
            $("#searchBtn").trigger('click');
            return false;
        }
    };

    $("#searchBtn").click(function () {
        dataObj.search.startTime = $("#startTime").val();
        dataObj.search.endTime = $("#endTime").val();
        dataObj.search.xh = $("#xh").val();
        dataObj.search.ch = $("#ch").val();
        dataObj.search.sh = $("#sh").val();
        dataObj.search.fh = $("#fh").val();
        dataObj.search.crlx = $("#crlx").val();
        goPage(1,function(){
            //给操作按钮绑定事件
            bindHandleBar();
            //渲染分页
            initPage();
        });
    });

});