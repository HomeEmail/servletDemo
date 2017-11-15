package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Filter 要在web.xml里配置下访问方式

public class MyFilter implements Filter {
    public void init(FilterConfig config) throws ServletException{

    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException{
        System.out.println("request 被处理前...");

        long startTime = System.currentTimeMillis();//执行前时间

        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;

        //处理...
        System.out.println("getLocalAddr: "+request.getLocalAddr());
        System.out.println("getRemoteAddr: "+request.getRemoteAddr());
        System.out.println("getLocalName: "+request.getLocalName());
        System.out.println("getRemotePort: "+request.getRemotePort());

        System.out.println("getRequestURI: "+req.getRequestURI());
        System.out.println("getQueryString: "+req.getQueryString());
        System.out.println("req.getRemoteAddr: "+req.getRemoteAddr());
        String url;
        url=req.getQueryString()==null?req.getRequestURI() : (req.getRequestURI()+"?"+req.getQueryString());
        System.out.println("request url: "+url);


        chain.doFilter(request,response);//交给下个Filter或Servlet
        //一定要执行这句，佛祖不会执行Servlet代码

        System.out.println("request 被处理之后，response 达到浏览器之前...");

        long endTime=System.currentTimeMillis();//执行后时间
        System.out.println("执行"+url+" 用了："+(endTime-startTime)+" 毫秒.");//总用时

    }
    public void destroy(){

    }
}
