<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Hober Login</title>
<link rel="icon" href="images/hober-technology.png" type="image/x-icon">
<link rel="stylesheet" href="css/logCss.css" type="text/css">
<style type="text/css">
	* { margin: 0;padding: 0;outline: none; }
	html,body { height: 100%;min-width: 960px;min-height: 650px;font: 10px hoberFont;overflow: auto; }
	a { text-decoration: inherit;color: inherit; }
</style>
	
<script type="text/javascript">
	var dom = document;
	function $(id){ return dom.getElementById(id); }
	function $$(className){ return dom.getElementsByClassName(className); }
</script>
	<script src="js/jquery-1.12.4.min.js"></script>
	<!--ajax异步请求-->
	<script type="text/javascript">
        $(function(){
            $("#loginbutt").click(function(){
                var param = $("#loginform").serialize();
                $.post(
                    "/spmcs/userservlet",
                    param,
                    function (data) {
                        if (data.code == 1) {
                            //要加载主页
                            location.href="/spmcs/index.jsp";
                        }else {
                            //要填充到span里
                            $("#errorspan").css({color:"red"});
                            $("#errorspan").html("Username or password is incorrect");
                        }
                    },"json"
                );
            });
        });
	</script>
</head>

<body>
	<div id="wrapper">
		<!--head-->
		<div id="header">
			<div class="container">
				<img src="images/hober-technology.png" alt="logo" class="logo" onClick="window.location.reload()">
				<span class="head-span">&nbsp;&nbsp;|&nbsp;&nbsp;Solar Pumping System Solution</span>
			</div>
		</div>
		<!--hidden-->
		<div class="invisible"></div>
		<!--main-->
		<div id="main">
			<div id="login">
				<h1 style="padding: 10px 0;color: #888;font-weight: 200;text-align: center;">Hober Account</h1>
				<hr color="#EEE" size="1">
				<div style="margin: 12% auto;width: 73%;">
				<form method="post" onsubmit="checkForm(this)" id="loginform">
					<input type="hidden" name="method" value="login">
					<span id="errorspan" style="font-size: 16px"></span>
					<label for="username" class="log-label">User Account:</label>
					<input type="email" class="log-input" id="username" name="user_email" value="" placeholder="E-Mail">
					<label for="password" class="log-label">Password:</label>
					<input type="password" class="log-input" id="password" name="user_pwd" value="" placeholder="Password" maxlength="36">
					<a href="register.jsp" target="_blank" class="user-a flt-left">Sign up</a>
					<a href="forgetpwd.html" target="_blank" class="user-a flt-right">Forget password</a>
					<input type="button" class="submit" value="Log in" id="loginbutt">
				</form>
				</div>
			</div>
		</div>
		<!--hidden-->
		<div class="invisible"></div>
		<!--foot-->
		<div id="footer">
			Copyright 2019 Hober| All Rights Reserved | Powered by <a href="http://www.hobertek.com" class="foot-a" target="_self">HOBER</a> | <a href="http://www.hobertek.com" class="foot-a" target="_self">HOBER TECHNOLOGY</a>
		</div>
	</div>
	<script type="text/javascript">
		function checkForm(form){
			for(i=0;i<form.length-1;i++)
				{
					if(form.elements[i].value == ""){
					form.elements[i].focus();
					return false;
				}
			}
		}
	</script>
</body>
</html>
