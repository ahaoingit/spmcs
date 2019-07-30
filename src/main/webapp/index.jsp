<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width,height=device-height,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Hober Monitoring System of Solar Water Pump</title>
    <link rel="stylesheet" href="css/index.css" type="text/css">
    <style type="text/css">
        * { margin: 0;padding: 0;outline: none; }
        html,body { height: 100%;min-width: 1100px;min-height:  650px;font: 10px hober,"Trebuchet MS";overflow: auto; }
        a { color: inherit;text-decoration: inherit; }
    </style>
    <script type="text/javascript">
        var dom = document;
        function $(id){ return dom.getElementById(id); }
        function $$(className){ return dom.getElementsByClassName(className); }
        function $$$(tagName){ return dom.getElementsByTagName(tagName); }
        function liChange(li,url){
            li.style.backgroundColor = "rgb(108,208,255)";
            var ul = $$("ul-h");
            for(var i=0;i<ul.length;i++)
                for(var n=0;n<ul[i].children.length;n++)
                    if(ul[i].children[n] != li && ul[i].children[n] != ul[2].children[1])
                        ul[i].children[n].style.backgroundColor = "transparent";
            window.open(url,"frame");
        }
    </script>
</head>

<body>
<div class="header">
    <table cellspacing="0" cellpadding="0" border="0" class="tb">
        <tr class="tr tr-font">
            <td><img src="images/hober-technology.png" alt="logo" class="logo" onClick="window.open('http://www.hobertek.com','_blank')"></td>
            <td><img src="ui/icon1.png" alt="" class="ui"><br>Machine</td>
            <td><img src="ui/icon4.png" alt="" class="ui"><br>Real-Time Date</td>
            <td><img src="ui/icon5.png" alt="" class="ui"><br>Fault</td>
            <td><img src="ui/icon6.png" alt="" class="ui"><br>Setting</td>
            <td style="visibility: hidden"></td>
            <td><img src="ui/BJ.png" alt=""></td>
            <td id="loginout"><img src="ui/icon9.png" alt="" ></td>
        </tr>
    </table>
</div>
<div class="main">
    <div class="main-left">
        <div class="main-head">
            Control Bar
        </div>
        <div class="main-content pos-rel">
            <!--head_last div-->
            <div class="cascade">
                <ul class="ul-h">
                    <li onclick="liChange(this,'./setting.html')">Paraneter Setting</li>
                </ul>
            </div>
            <!--head_nth_last(2) div-->
            <div class="cascade">
                <ul class="ul-h">
                    <li onClick="liChange(this,'./table.jsp')">Fault Information</li>
                    <li onClick="liChange(this,'./table.jsp')">Warning Information</li>
                    <li onClick="liChange(this,'./table.jsp')">Switch Information</li>
                </ul>
            </div>
            <!--head_second div-->
            <div class="cascade">
                <ul class="ul-h">
                    <li onClick="liChange(this,'./realtime.jsp')">Real-Time Parameter</li>
                    <li id="getchart">
                        Show Charts
                    </li>
                    <!--二级菜单-->
                    <ul class="toli" id="getli">
                        <li><a href="showchart.jsp" target="frame">Inout Power </a></li>
                        <li><a href="showchart2.jsp" target="frame">Output Frequency</a></li>
                        <li><a href="showchart3.jsp" target="frame">Internal Temperature</a></li>
                    </ul>
                </ul>
            </div>
            <!--head_first div-->
            <div class="cascade">
                <ul class="ul-h">
                    <li onClick="liChange(this,'./mymachine.jsp')">My Machine</li>
                    <li onClick="liChange(this,'./addmachine.jsp')">Add Machine</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="main-right">
        <iframe name="frame" frameborder="0" src="mymachine.jsp">
        </iframe>
    </div>
</div>
<script type="text/javascript">
    var td = $$("tr")[0].children;
    var cascade = $$("cascade");
    var ul = $$("tr");
    for(i=1;i<td.length-3;i++)
        td[i].onclick = (function(i){ return function(){
            function src(i){
                switch(i){
                    case 1: return "ui/icon1s.png";
                    case 2: return "ui/icon4s.png";
                    case 3: return "ui/icon5s.png";
                    case 4: return "ui/icon6s.png";
                }
            }
            function reSrc(j){
                switch(j){
                    case 1: return "ui/icon1.png";
                    case 2: return "ui/icon4.png";
                    case 3: return "ui/icon5.png";
                    case 4: return "ui/icon6.png";
                }
            }
            for(var j=1;j<td.length-3;j++)
                if(j == i){
                    td[i].style.cssText = "color: blue;background-color: #FAFAFA";
                    td[i].children[0].src = src(i);
                    cascade[4-i].style.cssText = "z-index: 10;visibility: visible";
                }
                else{
                    td[j].style.cssText = "color: #FFF;background-color: transparent";
                    td[j].children[0].src = reSrc(j);
                    cascade[4-j].style.cssText = "z-index: -1;visibility: hidden";
                }
        }
        }(i))
</script>
<script src="js/jquery-1.12.4.min.js"  type="text/javascript" ></script>
<script>
    var clickNumber = 0;
    $(function(){
        $("#getchart").click(function(){
            $("#getli").stop().slideToggle();
            if(clickNumber %2 ==0)
                this.style["background-color"] = "DeepSkyBlue";
            else
                this.style["background-color"] = "transparent";
            clickNumber++;
        });
    })
    $(function(){
        $("#getli>li").click(function(){
            $("#getli>li").css({"color":"#FFF","background-color":"rgba(68,180,255,0.95)"});
            this.style.cssText = "color: #FDFDFD;background-color: rgba(48,148,255,1.00)";
        });
    })
    $(function () {
        $("#loginout").click(function () {
            $.post(
                "/spmcs/userservlet",
                "method=loginOut",
                function (data) {
                    if (data.code == 1){
                        location.href = "login.jsp";
                    }
                },"json"
            );
        });
    });
</script>
</body>
</html>
