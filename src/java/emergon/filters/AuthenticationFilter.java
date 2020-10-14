/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //Transform request to httpServletRequest
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        //Check if session has attribute username
        HttpSession session = httpRequest.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println("username:" + username);
        String loginPage = "login.jsp";
        String loginServlet = "LoginServlet";
        String cssPage="styling.css";
        String requestUri = httpRequest.getRequestURI();
        System.out.println("requestUri" + requestUri);

        boolean isUsernameNull = (username == null);
        System.out.println("isUsernameNull " + isUsernameNull);
        boolean isUserTryingToLogin = (requestUri.contains(loginPage) || requestUri.contains(loginServlet)) || requestUri.contains(cssPage);
        System.out.println("isUserTryingToLogin " + isUserTryingToLogin);

        if (isUsernameNull && !isUserTryingToLogin) { //username = null && url=/products/list
            HttpServletResponse resp = (HttpServletResponse) response;
            String contextPath = httpRequest.getContextPath();
            resp.sendRedirect(contextPath + "/login.jsp");

        } else {
            chain.doFilter(request, response);
        }
      
    }

}
