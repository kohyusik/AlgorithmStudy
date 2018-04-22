package step002.web.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-03-02
 * @description : HTTP GET 요청의 파라미터를 복호화 & public key 제공하기 위한 필터 정의
 */
@WebFilter("/*")
public class TestFilter extends OncePerRequestFilter {
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    
        System.out.println("OncePerRequestFilter...");
//        if (true) throw new NullPointerException();
        filterChain.doFilter(request, response);
    }
}