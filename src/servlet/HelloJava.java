package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.sql.*;
import java.util.ArrayList;

import bean.ConfigReadTest;
import bean.MySqlDemo;

//访问路径示例：http://localhost:8081/servletDemo/HelloJava
//@WebServlet("/HelloJava") //或者在web.xml里配置<servlet-mapping>
public class HelloJava extends HttpServlet {

    private String message=null;
    @Override
    public void init() throws ServletException{
        message="23333233 xx";
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        message="Hello Java, this message is from servlet! 66666";

        ServletContext sc=getServletContext();

        String realPath = sc.getRealPath("/WEB-INF/dbConfig.properties");//返回路径就是网站发布的根路径加上传进去的路径字符串,使用这个会自动识别兼容不同系统的路径分隔符
        System.out.println("getServletContext.getRealPath: "+realPath);

        //ConfigReadTest.readFile(realPath);

        //实例化项目中的其他类,这类是简单操作数据库（不是这样用的。）
        MySqlDemo mysqlDemo=new MySqlDemo(sc);
        String[] args=null;
        ArrayList array=mysqlDemo.exec(args);

        request.setAttribute("userList",array);

        //message="xxoo";
        response.setContentType("text/html");
        //response.setCharacterEncoding("UTF-8");

        System.out.println("request.getServletPath():"+request.getServletPath());
        System.out.println("request.getServletContext().getRealPath:"+request.getServletContext().getRealPath("/WEB-INF/web.xml"));


        // PrintWriter out=response.getWriter();
        // out.println("<h1>"+message+"</h1>");

        //使用这种方式跳转到另外一个内容来输出，这跳转是服务端的跳转，，浏览器地址栏不会变
        request.setAttribute("msg","form HelloJava servlet");//保存需要携带的信息
        RequestDispatcher dispatch = request.getRequestDispatcher("/HelloJava.jsp");
        dispatch.forward(request,response);

    }
}
