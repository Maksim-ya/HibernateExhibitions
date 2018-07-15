package com.maksim.controller;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Максим on 09/May/18.
 */
public class EncodingFilter implements Filter {
    private FilterConfig filterConfig = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;

    }
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
        servletResponse.setCharacterEncoding("UTF-8");
    }
}
