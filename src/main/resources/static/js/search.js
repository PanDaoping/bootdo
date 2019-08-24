$(function () {
    // 混凝土使用统计
    showHntsytj(1);
    //材料消耗统计情况
    showXhcltjqk(1);

    // 设备保养统计情况
    var barChart = echarts.init(document.getElementById("echarts-bar-chart"));
    var baroption = {
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['实际保养件数','计划保养件数']
        },
        grid:{
            x:30,
            x2:40,
            y2:24
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
            }
        ],
        yAxis : [
            {
                type : 'value',
                minInterval : 1,
                min: 27,
                max: 33
            }
        ],
        series : [
            {
                name:'实际保养件数',
                type:'bar',
                data:[30, 30, 30, 29.5, 28.8, 28.9,30, 28, 28, 29, 28, 30],
                barWidth : 15
                // markPoint : {
                //     data : [
                //         {type : 'max', name: '最大值'},
                //         {type : 'min', name: '最小值'}
                //     ]
                // },
                // markLine : {
                //     data : [
                //         {type : 'average', name: '平均值'}
                //     ]
                // }
            },
            {
                name:'计划保养件数',
                type:'line',
                data:[30, 30, 30, 30, 30, 30,30, 29, 29, 29, 28, 30],
                // markPoint : {
                //     data : [
                //         {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183, symbolSize:18},
                //         {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                //     ]
                // },
                // markLine : {
                //     data : [
                //         {type : 'average', name : '平均值'}
                //     ]
                // }
            }
        ]
    };
    barChart.setOption(baroption);

    window.onresize = barChart.resize;

    //设备故障统计情况
    var sbgzqkChart = echarts.init(document.getElementById("sbgzqk"));
    var sbgzqkoption = {
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            data:['机电故障','皮带损坏','气缸损坏','轨道磨损','控制器异常','开关损坏']
        },

        calculable : true,
        series : [
            {
                // name:'访问来源',
                type:'pie',
                radius : '45%',
                center: ['70%', '60%'],
                data:[
                    {value:15, name:'机电故障'},
                    {value:2, name:'皮带损坏'},
                    {value:17, name:'气缸损坏'},
                    {value:2, name:'轨道磨损'},
                    {value:19, name:'控制器异常'},
                    {value:3, name:'开关损坏'}
                ]
            }
        ]
    };
    sbgzqkChart.setOption(sbgzqkoption);

    window.onresize = sbgzqkChart.resize;


    //设备设备影响工时
    var sbyxgsChart = echarts.init(document.getElementById("sbyxgs"));
    var sbyxgsoption = {
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['维修工时','影响生产工时']
        },
        grid:{
            x:20,
            y1:5,
            x2:10,
            y2:20
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
            }
        ],
        yAxis : [
            {
                type : 'value',
            }
        ],
        series : [
            {
                name:'维修工时',
                type:'line',
                data:[29, 25, 24, 23, 22.6, 24.8, 23,22,26,26,22,25],
            },
            {
                name:'影响生产工时',
                type:'line',
                data:[31, 27, 26, 25, 24.6, 26.8, 25,24,28,28,24,27],
            }
        ]
    };
    sbyxgsChart.setOption(sbyxgsoption);

    window.onresize = sbyxgsChart.resize;

});

function onHntsytj(pram){
    showHntsytj(pram);
}

function onClxh(pram){
    showXhcltjqk(pram);
}

function showHntsytj(sta){
    var hdata = [];
    if(sta === 1){
        hdata = [100, 200, 40, 50, 60, 70, 100];
    }else if(2){
        hdata = [150, 100, 80, 70, 50, 80, 150];
    }

    // 混凝土使用统计
    var hntsytjChart = echarts.init(document.getElementById("hntsytj"));
    var hntsytjoption = {
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['一线'],
            x: 'center',               // 水平安放位置，默认为全图居中，可选为：
            // 'center' ¦ 'left' ¦ 'right'
            // ¦ {number}（x坐标，单位px）
            y: 'top',
        },
        grid:{
            x:30,
            x2:40,
            y1:40,
            y2:24
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['周一','周二','周三','周四','周五','周六','周日']
            }
        ],
        yAxis : [
            {
                type : 'value',
                minInterval : 50,
                min: 0,
                max: 350
            }
        ],
        series : [
            {
                name:'一线',
                type:'bar',
                data:hdata,
                barWidth : 25

            },

        ]
    };
    hntsytjChart.setOption(hntsytjoption);

    window.onresize = hntsytjChart.resize;


}


function showXhcltjqk(sta){
    // 混凝土使用统计
    var hdata = [];
    var ldata = [];
    var sdata = [];
    if(sta === 1){
        hdata = [4, 7, 4, 6.5, 4.1, 7, 6.8];
        ldata = [4, 2, 3, 2.5, 3.1, 4, 2];
        sdata = [1, 4, 1.3, 4, 2, 2.4, 4];
    }else if(2){
        hdata = [5, 6.8, 4.8, 6, 7, 4, 6];
        ldata = [4.3, 2.5, 4, 3, 2, 2, 4];
        sdata = [2, 3.4, 2.3, 4, 1.5, 3.4, 1];
    }

    var xhcltjqkChart = echarts.init(document.getElementById("xhcltjqk"));
    var xhcltjqksoption = {
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['河砂','卵石','水泥']
        },
        grid:{
            x:30,
            x2:40,
            y1:40,
            y2:24
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['周一','周二','周三','周四','周五','周六','周日']
            }
        ],
        yAxis : [
            {
                type : 'value',
                minInterval : 1,
                min: 1,
                max: 9
            }
        ],
        series : [
            {
                name:'河砂',
                type:'line',
                data:hdata,
            },
            {
                name: '卵石',
                type: 'line',
                data: ldata,
            },
            {
                name:'水泥',
                type:'line',
                data:sdata,
            }
        ]
    };
    xhcltjqkChart.setOption(xhcltjqksoption);

    window.onresize = xhcltjqkChart.resize;

}