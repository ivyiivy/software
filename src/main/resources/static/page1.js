$(document).ready(function(){
	/**  -------------首页地图初始化 start----- */
	alert("asdadasa");
	var data2 = JSON
   	$.ajax({
		url : "/page1",
		type : "POST",
		dataType : "JSON",
		data: {},
		contentType : "application/json",
		success : function(data) {//这里得到后台Java响应的json数据,即resultJsonMapData
            alert("yes!!");
		    var myChart = echarts.init(document.getElementById('main'));
		    var data1 =  $.parseJSON(data); //此处代码很关键，后台返回的JSON字符串数据ECharts是无法直接解析的，必须
                                                    //解析一下，使他变成JSON对象（JS对象），ECharts才能操作该数据。
            document.write(data1)
		    var option = {
                        series: [
                            {
                                name: '访问来源',
                                type: 'pie',
                                radius: '55%',
                                roseType: 'angle',
                                data: data1
                            }
                        ]
                    };

			myChart.setOption(option);

		},
		error : function(errorMsg) {
	        //请求失败时执行该函数
			layer.msg('服务器开了点小差，请稍后刷新页面!', {icon: 0});
	        myChart.hideLoading();
	    }
	});
});
