<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 2017/11/14
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--
    使用< jsp:useBean>指令 导入并初始化实例
    1.< jsp:useBean id="实例化对象名称" scope=“保存范围” class=“包.类名称“/>
    2.主要属性：
    (1)id：表示实例化对象的名称
    (2)scope：表示此对象保存的范围，一共有四种属性范围：page、request、session、application
    (3)class：对象所对应的包.类名称
-->
<jsp:useBean id="simple" scope="page" class="package1.SimpleBean" />


<!-- import方式导入javabean -->
<%--@ page import="package1.*" --%>

<%
    //SimpleBean simple = new SimpleBean(); //import方式导入javabean 后初始化实例


    simple.setName("ivan");
    simple.setAge(23);

    HttpSession session1 =(HttpSession)request.getSession();

%>
<!--
访问参考：
http://www.runoob.com/jsp/jsp-javabean.html
http://localhost:8081/servletDemo/jspUseJavabean.jsp

-->
<html>
<head>
    <title>jsp use javabean</title>

</head>
<body>
    <h1>如何使用jsp调用javabean</h1>
    <h3>姓名:<%=simple.getName()%></h3>
    <h3>年龄:<%=simple.getAge()%></h3>
    <p>session id: <%= session1.getId() %></p>

</body>
</html>
