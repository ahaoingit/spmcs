<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<link rel="stylesheet" href="css/realtime.css" type="text/css">
	<script src="js/jquery-1.12.4.min.js"></script>
	<script>
        $(function () {
            $.post(
                "/spmcs/realtimeservlet",
                "method=getRealTime",
                function (data) {
                    if (data.code == 0)
					{
					    alert(data.message);
					}
					if (data.code == 1)
					{
					    var realtime = data.obj;
					    var node = $("#containerId");
					    $.each(realtime,function (index , ele) {
							var str = "<div class=\"header\">\n" +
                                "\t<span class=\"header-font\">Machine Model&nbsp;:</span>\n" +
                                "\t<span class=\"head-span-input\"><input type=\"text\" value=\""+ele.m_model+"\" readonly></span>\n" +
                                "\t<span class=\"header-font\">Serial Number&nbsp;:</span>\n" +
                                "\t<span class=\"head-span-input\"><input type=\"text\" value=\""+ele.realTime.m_serialnum+"\" readonly></span>\n" +
                                "\t<!--右侧ui-->\n" +
                                "\t<div style=\"top: 0;left: 94%;width: 6%;height: 55px\" class=\"pos-abs flt-right\"><img src=\"ui/links.png\" alt=\"\" class=\"ui ui-right\"></div>\n" +
                                "</div>\n" +
                                "\n" +
                                "\n" +
                                "<div class=\"main\">\n" +
                                "\t<div class=\"main-bookmark\">Machine Operation Status</div>\n" +
                                "\t<div style=\"float: left;width: 50%\">\n" +
                                "\n" +
                                "\t\t<div class=\"data-inline\">\n" +
                                "\t\t\t<span>Photovoltaic output voltage</span>\n" +
                                "\t\t\t<span class=\"data-value\">"+ele.realTime.photovoltaic_input_voltage+"V</span>\n" +
                                "\t\t</div>\n" +
                                "\t\t<div class=\"data-inline\">\n" +
                                "\t\t\t<span>Photovoltaic output current</span>\n" +
                                "\t\t\t<span class=\"data-value\">"+ele.realTime.photovoltaic_input_current+"</span>\n" +
                                "\t\t</div>\n" +
                                "\t\t<div class=\"data-inline\">\n" +
                                "\t\t\t<span>Photovoltaic input power</span>\n" +
                                "\t\t\t<span class=\"data-value\">-------</span>\n" +
                                "\t\t</div>\n" +
                                "\t\t<div class=\"data-inline\">\n" +
                                "\t\t\t<span>Mixed state</span>\n" +
                                "\t\t\t<span class=\"data-value\">"+ele.realTime.solar_ac_status+"</span>\n" +
                                "\t\t</div>\n" +
                                "\t</div>\n" +
                                "\n" +
                                "\t<div style=\"float: right;width: 50%\">\n" +
                                "\t\t<div class=\"data-inline\">\n" +
                                "\t\t<span>AC input power</span>\n" +
                                "\t\t<span class=\"data-value\">"+ele.realTime.AC_input_power+"</span>\n" +
                                "\t</div>\n" +
                                "\t\t<div class=\"data-inline\">\n" +
                                "\t\t\t<span>AC Output Phase Number</span>\n" +
                                "\t\t\t<span class=\"data-value\">"+ele.realTime.AC_output_phase+"</span>\n" +
                                "\t\t</div>\n" +
                                "\t\t<div class=\"data-inline\">\n" +
                                "\t\t\t<span>AC output frequency</span>\n" +
                                "\t\t\t<span class=\"data-value\">"+ele.realTime.AC_output_frequency+"</span>\n" +
                                "\t\t</div>\n" +
                                "\t\t<div class=\"data-inline\">\n" +
                                "\t\t\t<span>AC Output Current</span>\n" +
                                "\t\t\t<span class=\"data-value\">"+ele.realTime.AC_output_current+"</span>\n" +
                                "\t\t</div>\n" +
                                "\t</div>\n" +
                                "\t<br clear=\"all\">\n" +
                                "\t<div class=\"main-bottom\">\n" +
                                "\t\t<table frame=\"void\" cellspacing=\"10px\">\n" +
                                "\t\t\t<tr>\n" +
                                "\t\t\t\t<td>Machine temperature&nbsp;:<span>"+ele.realTime.machine_Internal_temperature+"</span></td>\n" +
                                "\t\t\t\t<td>Switch State&nbsp;:<span>"+ele.realTime.s_code+"</span></td>\n" +
                                "\t\t\t</tr>\n" +
                                "\t\t\t<tr>\n" +
                                "\t\t\t\t<td>Fault Code&nbsp;:<span>"+ele.realTime.f_status+"</span></td>\n" +
                                "\t\t\t\t<td>Warning Code&nbsp;:<span>"+ele.realTime.w_status+"</span></td>\n" +
                                "\t\t\t</tr>\n" +
                                "\t\t\t<tr>\n" +
                                "\t\t\t\t<td>Runing time&nbsp;:<span>-----</span></td>\n" +
                                "\t\t\t\t<td>Total Power Generation&nbsp;:<span></span></td>\n" +
                                "\t\t\t</tr>\n" +
                                "\t\t</table>\n" +
                                "\n" +
                                "\t</div>\n" +
                                "\n" +
                                "</div>";
							node.append(str);
                        });
					}
                }, "json"
            );
        })
        setInterval(function () {
            $.post(
                "/spmcs/realtimeservlet",
                "method=getRealTime",
                function (data) {
                }, "json"
            );
        }, 30 * 1000);
	</script>
</head>

<body>
<div id="containerId">




</div>
<%--<c:forEach items="${realtime}" var="ele">
<div class="header">
	<span class="header-font">Machine Model&nbsp;:</span>
	<span class="head-span-input"><input type="text" value="${ele.m_model}" readonly></span>
	<span class="header-font">Serial Number&nbsp;:</span>
	<span class="head-span-input"><input type="text" value="${ele.realTime.m_serialnum}" readonly></span>
	<!--右侧ui-->
	<div style="top: 0;left: 94%;width: 6%;height: 55px" class="pos-abs flt-right"><img src="ui/links.png" alt="" class="ui ui-right"></div>
</div>


<div class="main">
	<div class="main-bookmark">Machine Operation Status</div>
	<div style="float: left;width: 50%">

		<div class="data-inline">
			<span>Photovoltaic output voltage</span>
			<span class="data-value">${ele.realTime.photovoltaic_input_voltage}V</span>
		</div>
		<div class="data-inline">
			<span>Photovoltaic output current</span>
			<span class="data-value">${ele.realTime.photovoltaic_input_current}</span>
		</div>
		<div class="data-inline">
			<span>Photovoltaic input power</span>
			<span class="data-value">-------</span>
		</div>
		<div class="data-inline">
			<span>Mixed state</span>
			<span class="data-value">${ele.realTime.solar_ac_status}</span>
		</div>
	</div>

	<div style="float: right;width: 50%">
		<div class="data-inline">
		<span>AC input power</span>
		<span class="data-value">${ele.realTime.AC_input_power}</span>
	</div>
		<div class="data-inline">
			<span>AC Output Phase Number</span>
			<span class="data-value">${ele.realTime.AC_output_phase}</span>
		</div>
		<div class="data-inline">
			<span>AC output frequency</span>
			<span class="data-value">${ele.realTime.AC_output_frequency}</span>
		</div>
		<div class="data-inline">
			<span>AC Output Current</span>
			<span class="data-value">${ele.realTime.AC_output_current}</span>
		</div>
	</div>
	<br clear="all">
	<div class="main-bottom">
		<table frame="void" cellspacing="10px">
			<tr>
				<td>Machine temperature&nbsp;:<span>${ele.realTime.machine_Internal_temperature}</span></td>
				<td>Switch State&nbsp;:<span>${ele.realTime.s_code}</span></td>
			</tr>
			<tr>
				<td>Fault Code&nbsp;:<span>${ele.realTime.f_status}</span></td>
				<td>Warning Code&nbsp;:<span>${ele.realTime.w_status}</span></td>
			</tr>
			<tr>
				<td>Runing time&nbsp;:<span>-----</span></td>
				<td>Total Power Generation&nbsp;:<span></span></td>
			</tr>
		</table>

	</div>

</div>
</c:forEach>--%>
</body>
</html>
