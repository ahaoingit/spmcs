<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<link rel="stylesheet" href="css/realtime.css" type="text/css">
</head>

<body>
	<div class="header">
		<form method="post" id="timeform">
			<input type="hidden" name="method" value="findRealTimeAll">
			<select class="select" name="m_serialnum" id="selectId">
				<option value="" hidden="">--- Please Choose ---</option>
			</select>
			<input type="date" name="time">
			<input type="button" value="submit" id="timebutt">
		</form>
		<div class="pos-abs flt-right" style="top: 0;left: 94%;width: 6%;height: 55px">
			<img src="ui/links.png" alt="" class="ui">
		</div>
	</div>
	<div style="margin-top: 2%;width: 1200px;height: 500px" id="imagediv">
	</div>
<script src="js/jquery-1.12.4.min.js"></script>
	<script src="js/echarts.js"></script>
<script>
    /*填充序列号*/
    $(function () {
        $.post(
            "/spmcs/machineservlet",
            "method=findMachineAll",
            function (data) {
				if (data.code == 0)
				{
				    alert(data.message);
				}
				if (data.code == 1)
				{
				    var serial = data.obj;
				    var node = $("#selectId");
				    $.each(serial,function (index,ele) {
                        node.append("<option value=" + ele.m_serialnum +">"+ele.m_serialnum+"</option>");
                    });
				}
            },"json"
        );
    });
	/*
	* 得到数据；
	* */
	$(function () {
		$("#timebutt").click(function () {
		    var param = $("#timeform").serialize();
			$.post(
			    "/spmcs/realtimeservlet",
				param,
				function (data) {
                    var timeArr = new Array();
                    var photovoltaicPower = new Array();//光伏功率
                    var ac_input_power = new Array();//交流输入率
					var totalPower = new Array();//总功率
					for (i = 0 ; i<data.obj.length ; ++i)
					{
					    var time = new Date(data.obj[i].time.time);
					    timeArr.push((time.getMonth()+1)+"/"+time.getDate()+" " +time.getHours()+":"+time.getMinutes()+":" +time.getSeconds());
                        photovoltaicPower.push(data.obj[i].photovoltaic_input_voltage*data.obj[i].photovoltaic_input_current);
					    ac_input_power.push(data.obj[i].AC_input_power);
					    totalPower.push(data.obj[i].photovoltaic_input_voltage*data.obj[i].photovoltaic_input_current+data.obj[i].AC_input_power);
					}
                    var chart = echarts.init(document.getElementById('imagediv'));
                    var option={
                        title:{
                            text:'Input Power Diagram',
							left:20
						},
						tooltip:{},
						legend:{
                            type:'scroll',
                            data:['Photovoltaic_input_Power','AC_input_power','TotalPower']
						},
                        xAxis: {
                            type: "category",
                            data: timeArr
                        },
                        yAxis:{
                            name: 'Power(W)',
                            type: 'value'
                        },
                        series:[
                            {
                                type:'line',
                                name:'Photovoltaic_input_Power',
                                data:photovoltaicPower
                            },
                            {
                                type:'line',
                                name:'AC_input_power',
                                data:ac_input_power
                            },
                            {
                                type:'line',
                                name:'TotalPower',
                                data:totalPower
                            }
                        	]
                    	};
                    chart.setOption(option);
                },"json"
			);
   		});
    });


</script>
</body>
</html>
