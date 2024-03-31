<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 2017/11/13
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  //String msg=(String)request.getAttribute("msg");
  HttpSession session1 =(HttpSession)request.getSession();

%>

<html>
  <head>
    <title>servletDemo</title>

    <link rel="stylesheet" href="css/style.css">

  </head>
  <body>
    <h1>Hello World!</h1>
    <p>session id: <%= session1.getId() %></p>
    <div>
      <a href="./HelloJava">go HelloJava</a>
    </div>
    <div>
      <a href="./jspUseJavabean.jsp">go jspUseJavabean</a>
    </div>
  </body>
  <script src="js/index.js"></script>
</html>
