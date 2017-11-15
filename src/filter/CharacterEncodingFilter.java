package filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    private String characterEncoding;//编码方式，配置在web.xml中
    private boolean enabled;//是否启用该Filter,配置在web.xml中

    public void init(FilterConfig config) throws ServletException{
        characterEncoding = config.getInitParameter("characterEncoding");
        enabled = "true".equalsIgnoreCase(config.getInitParameter("enabled").trim());

    }
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException,ServletException{
        if(enabled&&characterEncoding!=null){ //如果启用该Filter
            request.setCharacterEncoding(characterEncoding);
            response.setCharacterEncoding(characterEncoding);
            System.out.println("执行了字符编码Filter...");
        }
        chain.doFilter(request,response);//执行下一个Filter或Servlet

    }
    public void destroy(){
        characterEncoding=null;//销毁时清空资源
    }
}
