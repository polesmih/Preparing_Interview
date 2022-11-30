package com.example.lesson_6;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter
public class FilterWeb implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
