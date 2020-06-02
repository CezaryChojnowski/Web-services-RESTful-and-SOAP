package com.rsi.demo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;

import java.util.StringTokenizer;

@Component
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String authHeader = req.getHeader("authorization");
        if(authHeader!=null) {
            String authHeader2 = authHeader.replaceFirst("Basic ", "");
            byte[] decodedString = null;
            System.out.println("authTokenBezBasic :" + authHeader2);
            byte[] bytes = authHeader2.getBytes();
            System.out.println("bytes " + new String(bytes));
            byte[] decodeBytes2 = Base64.getDecoder().decode(bytes);
            String decodedString2 = new String(decodeBytes2);
            System.out.println("decodedString: " + decodedString2);

            StringTokenizer tokenizer = new StringTokenizer(decodedString2, ":");
            String username = tokenizer.nextToken();
            String password = tokenizer.nextToken();
            System.out.println(username);
            System.out.println(password);
        }
    }
}
