<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Hober Sign Up</title>
<link rel="icon" href="images/hober-technology.png" type="image/x-icon">
<link rel="stylesheet" href="css/enroll.css" type="text/css">
<style type="text/css">
	* { margin: 0;paddin: 0; }
	html,body { height: 100%;min-width: 1100px;min-height: 650px;font: 10px hoberFont; }
	a { color: inherit;text-decoration: none;outline: none; }
</style>
<noscript><meta http-equiv="Refresh" content="3;url=http://www.hobertek.com" /></noscript>
<script type="text/javascript">
	var dom = document;
	function $(id){ return dom.getElementById(id); }
	function $$(className){ return dom.getElementsByClassName(className); }
	function $$$(tagName){ return dom.getElementsByTagName(tagName); }
</script>
	<script src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">
        $(function () {
            $("#regbutt").click(function () {
                var param = $("#regform").serialize();
                $.post(
                    "/spmcs/userservlet",
                    param,
                    function (data) {
                        if (data.code==1){
                            location.href="login.jsp";
                        } else {
                            alert(data.message);
                        }
                    },"json"
                )
            });
        });
	</script>
</head>

<body>
	<div id="wrapper">
		<!--head-->
		<div id="header">
			<div class="container">
				<div class="float-left">
				<img src="images/hober-technology.png" alt="logo" class="logo" onClick="window.location.reload()">
				</div>
				<span class="head-word">Hober&nbsp;&nbsp;Account&nbsp;&nbsp;Registration</span>
				<div class="float-right">
				<img src="images/regedit.png" alt="logo" class="logo" id="magic" onClick="window.location.reload()">
				</div>
			</div>
		</div>
		<!--不可见块-->
		<div class="invisible"></div>
		<div class="content">
		<!--main-->
			<div id="main">
				<!--注册块-->
				<div id="register">
					<h1 style="padding: 8px 0px;font-size: 1.8rem;font-weight: 200;color: #DDD;text-align: center">Register Hober Account</h1>
					<hr color="#CCC" size="1">
					<!--中部控件块-->
					<div style="margin: 5% auto;width: 60%;height: 80%;">
					<form id="regform" method="post" autocomplete="on" onSubmit="checkForm(this)">
						<input type="hidden" name="method" value="register">
					<label for="username" class="user-label">User Name:</label>
					<input type="text" class="user-input" id="username" name="user_name" value=""
					placeholder="Please Enter Your Name" maxlength="32" onBlur="checkInput(this)">
					<label for="userphone" class="user-label">Phone Number</label>
					<input type="tel" class="user-input" id="userphone" name="user_phonenum" value="" placeholder="Please Enter Your Phone Number" onBlur="checkInput(this)">
					<label for="usermail" class="user-label">E-Mail: </label>
					<input type="email" class="user-input" id="usermail" name="user_email" value="" placeholder="Please Enter Your E-Mail" onBlur="checkInput(this)">
					<laber for="password" class="user-label">Password: </laber>
					<input type="password" class="user-input" id="user_pwd"  name="user_pwd" value="" placeholder="Please Set Your Password" maxlength="36" onBlur="checkInput(this)">
					<laber for="Country" class="user-label">Country:</laber>
					<select class="select" name="user_country">
						<option value="" disabled="disabled" selected="selected" hidden="hidden">Select Nation</option>
						<optgroup class="group" label="----ASIA-----">
						<option value="China">CHINA</option>
						<option value="Japan">JAPAN</option>
						<option value="India">INDIA</option>
						<option value="Malaysia">MALAYSIA</option>
						</optgroup>
						<optgroup class="group" label="---AFRICA----">
						<option value="Egypt">EGYPT</option>
						<option value="Algeria">ALGERIA</option>
						<option value="Ethiopia">ETHIOPIA</option>
						<option value="Angola">ANGOLA</option>
						<option value="Benin">BENIN</option>
						<option value="botswana">BOTSWANA</option>
						<option value="burkina faso">BURKINA FASO</option>
						<option value="burundi">BURUNDI</option>
						<option value="Equatorial Guinea">EQUATORIAL GUINEA</option>
						<option value="Togo">TOGO</option>
						</optgroup>
						<optgroup class="group" label="---AMERICA---">
						<option value="USA">U.S.A</option>
						<option value="Canada">CANADA</option>
						<option value="Brazil">BRAZIL</option>
						<option value="Mexico">MEXICO</option>
						</optgroup>
					</select>
						<input type="button" class="submit" value="Submit" id="regbutt">
						</form>
					</div>
				</div>
			</div>
		</div>
		<!--不可见块-->
		<div class="invisible"></div>
		<div id="footer">
			Copyright 2019 Hober| All Rights Reserved | Powered by <a href="http://www.hobertek.com" class="foot-a" target="_self">HOBER</a> | <a href="http://www.hobertek.com" class="foot-a" target="_self">HOBER TECHNOLOGY</a>
		</div>
	</div>
	<script type="text/javascript">
		function checkForm(form){
			for(i=0;i<form.length;i++)
				{
					if(form.elements[i].value == ""){
					form.elements[i].focus();
					return false;
				}
			}
		}
		function checkInput(input){
			if(input.value=="")
				input.style.boxShadow = "0 0 4px 1px red";
			else
				input.style.boxShadow = "0 0 4px 1px green";
		}
	</script>
</body>
</html>
