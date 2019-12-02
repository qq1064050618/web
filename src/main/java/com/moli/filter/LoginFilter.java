package com.moli.filter;

import com.moli.util.CookieUtil;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/*@WebFilter(urlPatterns = {"/*"})*/
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String uri = httpServletRequest.getRequestURI();
        if (uri.equals("/toLoginServ") || uri.equals("/loginServ") || uri.endsWith(".css") || uri.endsWith(".js")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (httpServletRequest.getSession().getAttribute("user") != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                Cookie[] cookies=httpServletRequest.getCookies();
                Map<String,String> map= CookieUtil.getCookieMap(cookies);
                if (map.get("username") != null){
                    HttpSession httpSession=httpServletRequest.getSession();
                    //登陆成功后将信息存入session中
                    httpSession.setAttribute("user",map.get("username"));
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                httpServletResponse.sendRedirect("toLoginServ");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
