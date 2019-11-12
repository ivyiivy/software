$(document).ready(function(){
// 使用刚指定的配置项和数据显示图表。

    var myChart = echarts.init($("#main")[0]);
    myChart.setOption({
        series: [
            {
                name: '访问来源',
                type: 'pie',
                radius: '55%',
                roseType: 'angle',
                data: [
                    {value: 235, name: '视频广告', itemStyle: {color: '#c23531'}},
                    {value: 274, name: '联盟广告', itemStyle: {color: '#5951c2'}},
                    {value: 310, name: '邮件营销', itemStyle: {color: '#59c282'}},
                    {value: 335, name: '直接访问', itemStyle: {color: '#a353c2'}},
                    {value: 400, name: '搜索引擎', itemStyle: {color: '#b3c23f'}}
                ]
            }
        ]
    })
})
