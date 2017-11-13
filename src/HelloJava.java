import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;

@WebServlet("/HelloJava")
public class HelloJava extends HttpServlet {

    private String message=null;

    public void init() throws ServletException{
        message="23333233 xx";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        message="Hello Java, this message is from servlet! xxx";
        //message="xxoo";
        response.setContentType("text/html");

        PrintWriter out=response.getWriter();
        out.println("<h1>"+message+"</h1>");

    }
}
