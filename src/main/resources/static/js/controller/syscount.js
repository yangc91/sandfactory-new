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
      $.ajax({
        type: 'GET', url: "/admin/record/count", success: function (res) {
          if (res.flag == 1) {
            var result = res.result;
            $("#appTotal").html(result.todayNo + "量");
            $("#appCallInterfaceTotal").html(result.todayWeight + "KG");
            option.series[0].data = [];
            if (result.monthList) {
              for (var i = 0; i < result.monthList.length; i++) {
                option.xAxis[0].data.push(result.monthList[i]['month'].substr(2, 8));
                option.series[0].data.push(result.monthList[i].weight);
              }
            }
            chart.setOption(option);
          } else {
            layer.alert(res.msg)
          }
        }
      });
    }, 1);

  });

});



