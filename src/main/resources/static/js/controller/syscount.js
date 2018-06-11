/**
 * Created by admin on 2017/7/27.
 * 系统状态js
 */
//alert("系统状态");
//进入页面请求系统状态数据
var chart = echarts.init(document.getElementById('eChart'));
var option = {
  tooltip: {
    trigger: 'axis',
    formatter: '重量：{c0}KG',
    axisPointer: {
      type: 'line',
      lineStyle: {
        width: 0
      }
    }
  },
  grid: {
    x: 55,
    y: 45,
    x2: 35,
    y2: 55,
    borderWidth: 0,
    containLabel: true
  },
  xAxis: [
    {
      type: 'category',
      boundaryGap: true,
      data: [],
      axisLabel: {
        margin: 15,
        textStyle: {
          color: '#c6c6c6'
          , align: 'right'
          , fontSize: 12
        },
        //rotate: 30,
        interval: 0,
        //formatter: function(val,index){
        //  return val.replace(/-/g,"/")
        //},
        showMaxLabel: true,
        showMinLabel: true
      },
      axisLine: {
        lineStyle: {
          color: '#ddd',
          width: 1
        }

      },
      axisTick: {
        lineStyle: {
          color: '#ddd',
          width: 1
        }
      },
      splitLine: {
        show: false
      },
      splitArea: {
        show: false
      }
    }
  ],
  yAxis: [
    {
      type: 'value',
      axisLabel: {
        margin: 15,
        textStyle: {
          color: '#c6c6c6'
        }
      },
      axisLine: {
        lineStyle: {
          color: '#ddd',
          width: 1
        }
      },
      axisTick: {
        lineStyle: {
          color: '#ddd',
          width: 1
        }
      }
      //splitLine: {
      //  show: false
      //},
      //splitArea: {
      //  show: false
      //}
    }
  ],
  series: [
    {
      name: "新授权数",
      type: 'bar',
      itemStyle: {
        normal: {
          color: '#94ddd3'
        },
        emphasis: {
          color: '#94ddd3'
        }
      }
    }
  ],
  noDataLoadingOption: {
    effect: 'bar'
  }

};

$(document).ready(function () {
  //需要加上1毫秒延迟，否则请求不使用ajax全局配置
  layui.use('layer', function () {
    layer = layui.layer;
    layer.closeAll('page');

    setTimeout(function () {
      // $.ajax({
      //   type: 'GET',
      //   url: "/rias/web/auth/index",
      //   success: function (res) {
      //     var res = JSON.parse(res);
      //     $("#appTotal").html(res.appTotal + "个");
      //     $("#appCallInterfaceTotal").html(res.appCallInterfaceTotal + "次");
      //     option.series[0].data = [];
      //     if (res.monthList) {
      //       for (var i = 0; i < res.monthList.length; i++) {
      //         option.xAxis[0].data.push(res.monthList[i]['month'].substr(2, 8));
      //         option.series[0].data.push(res.monthList[i].count);
      //       }
      //     }
      //     chart.setOption(option);
      //   }
      // });

      var json = '{"appCallInterfaceTotal":20,"appTotal":10,"monthList":[{"month":"2018-06","count":1},{"month":"2018-05","count":2},{"month":"2018-04","count":3},{"month":"2018-03","count":4},{"month":"2018-02","count":5},{"month":"2018-01","count":6},{"month":"2017-12","count":7},{"month":"2017-11","count":8},{"month":"2017-10","count":9},{"month":"2017-09","count":10},{"month":"2017-08","count":11},{"month":"2017-07","count":12}],"success":"true"}';
      var res = JSON.parse(json);
      $("#appTotal").html(res.appTotal + "量");
      $("#appCallInterfaceTotal").html(res.appCallInterfaceTotal + "KG");
      option.series[0].data = [];
      if (res.monthList) {
        for (var i = 0; i < res.monthList.length; i++) {
          option.xAxis[0].data.push(res.monthList[i]['month'].substr(2, 8));
          option.series[0].data.push(res.monthList[i].count);
        }
      }
      chart.setOption(option);

    }, 1);

  });

});



