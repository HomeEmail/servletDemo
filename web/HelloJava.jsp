<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 2017/11/15
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:directive.page import="java.util.*" />
<jsp:directive.page import="java.lang.*" />


<%
    String msg=(String)request.getAttribute("msg");

%>
<html>
<head>
    <title>HellJava</title>
</head>
<body>
    <h1>从HelloJava servlet 跳转过来的</h1>
    <h3><%= msg %></h3>
</body>
</html>
