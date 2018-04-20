package step002.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-03-02
 * @description : HTTP GET 요청의 파라미터를 복호화 & public key 제공하기 위한 필터 정의
 */
@WebFilter("/*")
public class TestFilter2 implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
        System.out.println("TestFilter2 init");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("TestFilter2 doFilter before");
        chain.doFilter(request, response);
        System.out.println("TestFilter2 doFilter after");
    }
    
    @Override
    public void destroy() {
        System.out.println("TestFilter2 destroy");
    }
}