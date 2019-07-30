<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<style type="text/css">
	* { margin: 0;padding: 0;outline: none; }
	body,html { height: 100%;overflow: auto;background: url("images/mac_bg.png.jpg") repeat-y top center; }
	a { color:inherit;text-decoration: none; }
	.container { margin: 6% auto 0 auto;width: 45%;height: 72%;background-color: #FFF;border-radius: 16px;border: 1px solid #CCC;overflow: hidden; }
	.content-head { height: 36px;color: #686868;background-color: aliceblue;text-align: center;border-bottom: 1px solid #CCC;margin-bottom: 2%; }
	.container > form { box-sizing: border-box;height: 70%;padding-top: 2%; }
	.info { width: 75%;margin: 0 auto;text-align: center }
	.ui { position: relative;top: 15%;height: 70%; }
	.container > form  label { display: block;margin: 1% auto 0 auto;font-size: 18px;box-sizing: border-box;width: 62%;color: #888;text-align: left; }
	.container > form  input { display: block;box-sizing: border-box;margin: 0 auto 4% auto;padding: 4px 8px;box-sizing: border-box;width: 62%;height: 30px;min-width: 138px;color: #484848;border: 1px solid #ACACAC; }
	.container > form input[type="submit"] { margin: 8% auto;width: 62%;height: 32px;font-size: 18px;color: #666;background: linear-gradient(to top,#EAEAEA,#FCFCFC);border: 1px solid #AAA; }
	.container > form input[type="submit"]:hover { background: linear-gradient(to bottom,#EAEAEA,#FCFCFC); }
	#email { padding-left: 35px;background: url("images/user.png") no-repeat 5px center;border-radius: 14px;cursor: auto; }
	:-moz-placeholder { color: #CECECE; }
	::-moz-placeholder { color: #CECECE; }
	input:-ms-input-placeholder { color: #CECECE; }
	input::-webkit-input-placeholder { color: #CECECE; }
	input[type="button"] { margin-top: 12px;box-sizing: border-box;width: 100%;height: 36px;font-size: 16px;color: #FFF;letter-spacing: 2px;background-color:  #07B8F5;border-style: none;border-radius: 16px;cursor: pointer; }
	input[type="button"]:active {background-color: #0FC2F9; }
	input[type="button"]:hover { background-color: #28A8F5; }
</style>
</head>

<body>
	<div class="container">
		<div class="content-head">
			<img src="images/writing.png" alt="" class="ui">
			<span>Add Machine</span>
		</div>
		<form method="post" class="info" id="addform">
			<input type="hidden" name="method" value="addMachine">
			<label for="email">E-Mail&nbsp;:</label>
			<input type="text" id="email" name="user_email" value="${cookie.user_email.value}" readonly>
			<label for="num">Serial Number&nbsp;:</label>
			<input type="text" id="num" name="m_serialnum" value="" placeholder="Machine Serial Number">
			<label for="model">Model&nbsp;:</label>
			<input type="text" id="model" name="m_model" value="" placeholder="Machine Model">
			<label for="address">Installation Address&nbsp;:</label>
			<input type="text" id="address" name="m_address" value="" placeholder="Installation Address">
			<input type="button" value="submit" id="addbutt">
		</form>
	</div>
<script src="js/jquery-1.12.4.min.js"></script>
<script>
	$(function () {
		$("#addbutt").click(function () {
			var param = $("#addform").serialize();
			$.post(
			  "/spmcs/machineservlet",
				param,
				function (data) {
					if (data.code == 1){
					    location.href = "mymachine.jsp";
					} else {
					    alert(data.message.toString());
					}
                },"json"
			);
        });
    });
</script>
</body>
</html>
