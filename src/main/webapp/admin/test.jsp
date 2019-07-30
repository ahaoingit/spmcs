<%--
  Created by IntelliJ IDEA.
  User: 陈俊
  Date: 2019/7/8
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="cn.ahaogg.web.Online" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    long num = Online.getCount();
%>

我是打酱油的,当前在线人数为：<%=num %>


</body>
</html>
