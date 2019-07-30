<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/table.css"/>
		<link rel="stylesheet" type="text/css" href="css/base.css"/>
	</head>

	<body>
		<div class="container">
	        <table class="table1" border="0">
	            <thead>
	                <tr><th><input class="input" name="Fruit" type="checkbox" value="" title="" id="checkAll"></th>
	                <th># num</th>
	                <th>Fault Description</th>
	                <th>Occurrence time</th>
	                <th>Delete</th>
	            </tr></thead>
				<tbody class="tbody">
					<tr style="">
						<td>
							<input class="input" name="Fruit" type="checkbox" value="5485">
						</td>
						<td>
							201904220001
						</td>
						<td>
							OVER_LOAD
						</td>
						<td>
							20190616
						</td>
						<td>
							<a href="">delete</a>
						</td>
					</tr>
					<tr style="">
						<td>
							<input class="input" name="Fruit" type="checkbox" value="5492">
						</td>
						<td>
							201904220002
						</td>
						<td>
							OVER_VOLTAGE
						</td>
						<td>
							20190616
						</td>
						<td>
							<a href="">delete</a>
						</td>
					</tr>
					<tr style="">
						<td>
							<input class="input" name="Fruit" type="checkbox" value="5493">
						</td>
						<td>
							201904220003
						</td>
						<td>
							IGBT_ERROR IGBT
						</td>
						<td>
							20190616
						</td>
						<td>
							<a href="">delete</a>
						</td>
					</tr>
				</tbody>
	       </table>
    </div>

	</body>
</html>
