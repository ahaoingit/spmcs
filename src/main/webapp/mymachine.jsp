<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<link rel="stylesheet" href="css/mymachine.css" type="text/css">
</head>
<script src="js/jquery-1.12.4.min.js"></script>
<script>
    $(function () {
        $.post(
            "/spmcs/machineservlet",
            "method=findMachineAll",
            function (data) {
				if (data.code == 0)
				{
				    alert(data.message);
				}
				if (1 == data.code )
				{
				    var machine = data.obj;
                    var node = $("#containerId");
                    $.each(machine,function (index,ele) {
                        var str = "<div class=\"content-head pos-rel\">\n" +
                            "\t\t\t\t<span>Model&nbsp;:</span>\n" +
                            "\t\t\t\t<!--数据改写span-->\n" +
                            "\t\t\t\t<span class=\"date-span\">"+ele.model.m_model+"</span>\n" +
                            "\t\t\t\t<span>Serial&nbsp;Number&nbsp;:</span>\n" +
                            "\t\t\t\t<!--数据改写span-->\n" +
                            "\t\t\t\t<span class=\"date-span\">"+ele.m_serialnum+"</span>\n" +
                            "\t\t\t\t<span style=\"float: right\">\n" +
                            "\t\t\t\t\t<img src=\"ui/link.png\" alt=\"\" style=\"position: absolute;top: 10%;height: 80%\">\n" +
                            "\t\t\t\t</span>\n" +
                            "\t\t\t</div>\n" +
                            "\t\t\t<div class=\"content-main\">\n" +
                            "\t\t\t\t<div class=\"info\">\n" +
                            "\t\t\t\t\t<div class=\"info-head\">Input Voltage</div>\n" +
                            "\t\t\t\t\t<!--不可填内容-->\n" +
                            "\t\t\t\t\t<div class=\"hidden\"></div>\n" +
                            "\t\t\t\t\t<div class=\"info-left\">\n" +
                            "\t\t\t\t\t\t<img src=\"images/图标.jpg\" alt>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div class=\"info-right\">\n" +
                            "\t\t\t\t\t\t<span>Maximum Input Voc Voltage&nbsp;:</span><br>\n" +
                            "\t\t\t\t\t\t<span class=\"date-value\" data-type=\"horizontal\">"+ele.model.max_input_voltage+"</span><br>\n" +
                            "\t\t\t\t\t\t<span>Minimum Input Vmp voltage&nbsp;:</span><br>\n" +
                            "\t\t\t\t\t\t<span class=\"date-value\" data-type=\"horizontal\">"+ele.model.min_input_voltage+"</span>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<!--不可填内容-->\n" +
                            "\t\t\t\t\t<div class=\"hidden\"></div>\n" +
                            "\t\t\t\t</div>\n" +
                            "\t\t\t\t<div class=\"info\">\n" +
                            "\t\t\t\t\t<div class=\"info-head\">Recommended Vmp In-Voltage</div>\n" +
                            "\t\t\t\t\t<!--不可填内容-->\n" +
                            "\t\t\t\t\t<div class=\"hidden\"></div>\n" +
                            "\t\t\t\t\t<div class=\"info-left\">\n" +
                            "\t\t\t\t\t\t<img src=\"images/图标.jpg\" alt>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div class=\"info-right\">\n" +
                            "\t\t\t\t\t\t<span>Solar Energy&nbsp;:</span><br>\n" +
                            "\t\t\t\t\t\t<span class=\"date-value\" data-type=\"horizontal\">"+ele.model.full_solar_recommend_input_voltage+"</span><br>\n" +
                            "\t\t\t\t\t\t<span>Mixed Input</span><br>\n" +
                            "\t\t\t\t\t\t<span class=\"date-value\" data-type=\"horizontal\">"+ele.model.mixed_solar_recommend_input_voltage+"</span>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<!--不可填内容-->\n" +
                            "\t\t\t\t\t<div class=\"hidden\"></div>\n" +
                            "\t\t\t\t</div>\n" +
                            "\t\t\t\t<div class=\"info\">\n" +
                            "\t\t\t\t\t<div class=\"info-head\">Machine Power</div>\n" +
                            "\t\t\t\t\t<!--不可填内容-->\n" +
                            "\t\t\t\t\t<div class=\"hidden\"></div>\n" +
                            "\t\t\t\t\t<div class=\"info-left\">\n" +
                            "\t\t\t\t\t\t<img src=\"images/图标.jpg\" alt>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div class=\"info-right\">\n" +
                            "\t\t\t\t\t\t<span>Rated Power&nbsp;:</span><br>\n" +
                            "\t\t\t\t\t\t<span class=\"date-value\" data-type=\"horizontal\">"+ele.model.rated_power+"</span><br>\n" +
                            "\t\t\t\t\t\t<span>Maximum Input Power&nbsp;:</span><br>\n" +
                            "\t\t\t\t\t\t<span class=\"date-value\" data-type=\"horizontal\">"+ele.model.max_input_power+"</span>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<!--不可填内容-->\n" +
                            "\t\t\t\t\t<div class=\"hidden\"></div>\n" +
                            "\t\t\t\t</div>\n" +
                            "\t\t\t\t<div class=\"info\">\n" +
                            "\t\t\t\t\t<div class=\"info-head\">Machine Frequency & Phase</div>\n" +
                            "\t\t\t\t\t<!--不可填内容-->\n" +
                            "\t\t\t\t\t<div class=\"hidden\"></div>\n" +
                            "\t\t\t\t\t<div class=\"info-left\">\n" +
                            "\t\t\t\t\t\t<img src=\"images/图标.jpg\" alt>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div class=\"info-right\">\n" +
                            "\t\t\t\t\t\t<span>Maximum Output Frequency&nbsp;:</span><br>\n" +
                            "\t\t\t\t\t\t<span class=\"date-value\" data-type=\"horizontal\">"+ele.model.max_output_frequency+"</span><br>\n" +
                            "\t\t\t\t\t\t<span>Output Phase&nbsp;:</span><br>\n" +
                            "\t\t\t\t\t\t<span class=\"date-value\" data-type=\"horizontal\">"+ele.model.output_phase+"</span>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<!--不可填内容-->\n" +
                            "\t\t\t\t\t<div class=\"hidden\"></div>\n" +
                            "\t\t\t\t</div>\n" +
                            "\t\t\t\t<div class=\"info\">\n" +
                            "\t\t\t\t\t<div class=\"info-head\">Machine Voltage & Current</div>\n" +
                            "\t\t\t\t\t<!--不可填内容-->\n" +
                            "\t\t\t\t\t<div class=\"hidden\"></div>\n" +
                            "\t\t\t\t\t<div class=\"info-left\">\n" +
                            "\t\t\t\t\t\t<img src=\"images/图标.jpg\" alt>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div class=\"info-right\">\n" +
                            "\t\t\t\t\t\t<span>Rated output voltage&nbsp;:</span><br>\n" +
                            "\t\t\t\t\t\t<span class=\"date-value\" data-type=\"horizontal\">"+ele.model.rated_output_voltage+"</span><br>\n" +
                            "\t\t\t\t\t\t<span>Maximum Output Current&nbsp;:</span><br>\n" +
                            "\t\t\t\t\t\t<span class=\"date-value\" data-type=\"horizontal\">"+ele.model.max_output_current+"</span>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<!--不可填内容-->\n" +
                            "\t\t\t\t\t<div class=\"hidden\"></div>\n" +
                            "\t\t\t\t</div>\n" +
                            "\t\t\t\t<div class=\"info\">\n" +
                            "\t\t\t\t\t<div class=\"info-head\">Version Information</div>\n" +
                            "\t\t\t\t\t<!--不可填内容-->\n" +
                            "\t\t\t\t\t<div class=\"hidden\"></div>\n" +
                            "\t\t\t\t\t<div class=\"info-left\">\n" +
                            "\t\t\t\t\t\t<img src=\"images/图标.jpg\" alt>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<div class=\"info-right\">\n" +
                            "\t\t\t\t\t\t<span>Software Version&nbsp;:</span><br>\n" +
                            "\t\t\t\t\t\t<span class=\"date-value\" data-type=\"horizontal\">"+ele.model.soft_version+"</span><br>\n" +
                            "\t\t\t\t\t\t<span>Hardware version&nbsp;:</span><br>\n" +
                            "\t\t\t\t\t\t<span class=\"date-value\" data-type=\"horizontal\">"+ele.model.hard_version+"</span>\n" +
                            "\t\t\t\t\t</div>\n" +
                            "\t\t\t\t\t<!--不可填内容-->\n" +
                            "\t\t\t\t\t<div class=\"hidden\"></div>\n" +
                            "\t\t\t\t</div>\n" +
                            "\t\t\t\t<br clear=\"both\">\n" +
                            "\t\t\t</div><br>";
                        node.append(str);
                    });
				}
            },"json"
        );
    });
</script>
<body>

<div class="container" id="containerId">
	<%--<c:forEach items="${MachineInfo}" var="m">--%>
			<%--<div class="content-head pos-rel">--%>
				<%--<span>Model&nbsp;:</span>--%>
				<%--<!--数据改写span-->--%>
				<%--<span class="date-span">${m.model.m_model}</span>--%>
				<%--<span>Serial&nbsp;Number&nbsp;:</span>--%>
				<%--<!--数据改写span-->--%>
				<%--<span class="date-span">${m.m_serialnum}</span>--%>
				<%--<span style="float: right">--%>
					<%--<img src="ui/link.png" alt="" style="position: absolute;top: 10%;height: 80%">--%>
				<%--</span>--%>
			<%--</div>--%>
			<%--<div class="content-main">--%>
				<%--<div class="info">--%>
					<%--<div class="info-head">Input Voltage</div>--%>
					<%--<!--不可填内容-->--%>
					<%--<div class="hidden"></div>--%>
					<%--<div class="info-left">--%>
						<%--<img src="images/图标.jpg" alt>--%>
					<%--</div>--%>
					<%--<div class="info-right">--%>
						<%--<span>Maximum Input Voc Voltage&nbsp;:</span><br>--%>
						<%--<span class="date-value" data-type="horizontal">${m.model.max_input_voltage}</span><br>--%>
						<%--<span>Minimum Input Vmp voltage&nbsp;:</span><br>--%>
						<%--<span class="date-value" data-type="horizontal">${m.model.min_input_voltage}</span>--%>
					<%--</div>--%>
					<%--<!--不可填内容-->--%>
					<%--<div class="hidden"></div>--%>
				<%--</div>--%>
				<%--<div class="info">--%>
					<%--<div class="info-head">Recommended Vmp In-Voltage</div>--%>
					<%--<!--不可填内容-->--%>
					<%--<div class="hidden"></div>--%>
					<%--<div class="info-left">--%>
						<%--<img src="images/图标.jpg" alt>--%>
					<%--</div>--%>
					<%--<div class="info-right">--%>
						<%--<span>Solar Energy&nbsp;:</span><br>--%>
						<%--<span class="date-value" data-type="horizontal">${m.model.full_solar_recommend_input_voltage}</span><br>--%>
						<%--<span>Mixed Input</span><br>--%>
						<%--<span class="date-value" data-type="horizontal">${m.model.mixed_solar_recommend_input_voltage}</span>--%>
					<%--</div>--%>
					<%--<!--不可填内容-->--%>
					<%--<div class="hidden"></div>--%>
				<%--</div>--%>
				<%--<div class="info">--%>
					<%--<div class="info-head">Machine Power</div>--%>
					<%--<!--不可填内容-->--%>
					<%--<div class="hidden"></div>--%>
					<%--<div class="info-left">--%>
						<%--<img src="images/图标.jpg" alt>--%>
					<%--</div>--%>
					<%--<div class="info-right">--%>
						<%--<span>Rated Power&nbsp;:</span><br>--%>
						<%--<span class="date-value" data-type="horizontal">${m.model.rated_power}</span><br>--%>
						<%--<span>Maximum Input Power&nbsp;:</span><br>--%>
						<%--<span class="date-value" data-type="horizontal">${m.model.max_input_power}</span>--%>
					<%--</div>--%>
					<%--<!--不可填内容-->--%>
					<%--<div class="hidden"></div>--%>
				<%--</div>--%>
				<%--<div class="info">--%>
					<%--<div class="info-head">Machine Frequency & Phase</div>--%>
					<%--<!--不可填内容-->--%>
					<%--<div class="hidden"></div>--%>
					<%--<div class="info-left">--%>
						<%--<img src="images/图标.jpg" alt>--%>
					<%--</div>--%>
					<%--<div class="info-right">--%>
						<%--<span>Maximum Output Frequency&nbsp;:</span><br>--%>
						<%--<span class="date-value" data-type="horizontal">${m.model.max_output_frequency}</span><br>--%>
						<%--<span>Output Phase&nbsp;:</span><br>--%>
						<%--<span class="date-value" data-type="horizontal">${m.model.output_phase}</span>--%>
					<%--</div>--%>
					<%--<!--不可填内容-->--%>
					<%--<div class="hidden"></div>--%>
				<%--</div>--%>
				<%--<div class="info">--%>
					<%--<div class="info-head">Machine Voltage & Current</div>--%>
					<%--<!--不可填内容-->--%>
					<%--<div class="hidden"></div>--%>
					<%--<div class="info-left">--%>
						<%--<img src="images/图标.jpg" alt>--%>
					<%--</div>--%>
					<%--<div class="info-right">--%>
						<%--<span>Rated output voltage&nbsp;:</span><br>--%>
						<%--<span class="date-value" data-type="horizontal">${m.model.rated_output_voltage}</span><br>--%>
						<%--<span>Maximum Output Current&nbsp;:</span><br>--%>
						<%--<span class="date-value" data-type="horizontal">${m.model.max_output_current}</span>--%>
					<%--</div>--%>
					<%--<!--不可填内容-->--%>
					<%--<div class="hidden"></div>--%>
				<%--</div>--%>
				<%--<div class="info">--%>
					<%--<div class="info-head">Version Information</div>--%>
					<%--<!--不可填内容-->--%>
					<%--<div class="hidden"></div>--%>
					<%--<div class="info-left">--%>
						<%--<img src="images/图标.jpg" alt>--%>
					<%--</div>--%>
					<%--<div class="info-right">--%>
						<%--<span>Software Version&nbsp;:</span><br>--%>
						<%--<span class="date-value" data-type="horizontal">${m.model.soft_version}</span><br>--%>
						<%--<span>Hardware version&nbsp;:</span><br>--%>
						<%--<span class="date-value" data-type="horizontal">${m.model.hard_version}</span>--%>
					<%--</div>--%>
					<%--<!--不可填内容-->--%>
					<%--<div class="hidden"></div>--%>
				<%--</div>--%>
				<%--<br clear="both">--%>
			<%--</div>--%>
	<%--</c:forEach>--%>
</div>
</body>
</html>
