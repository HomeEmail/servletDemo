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
    HttpSession session1 =(HttpSession)request.getSession();

%>
<html>
<head>
    <title>HellJava</title>
</head>
<body>
    <h1>从HelloJava servlet 跳转过来的</h1>
    <h3><%= msg %></h3>
    <p>session id: <%= session1.getId() %></p>
    <%
        ArrayList array=(ArrayList)request.getAttribute("userList");
        for(Object ob : array){
            HashMap map=(HashMap) ob;
    %>
    <div>
        <span>username:<%=map.get("username")%>
        </span><span>id:<%=map.get("id")%></span>
    </div>
    <%
        }
    %>
</body>
</html>
