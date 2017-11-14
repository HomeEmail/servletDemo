import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;

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
        message="Hello Java, this message is from servlet! xx22x";
        //message="xxoo";
        response.setContentType("text/html");

        PrintWriter out=response.getWriter();
        out.println("<h1>"+message+"</h1>");

    }
}
