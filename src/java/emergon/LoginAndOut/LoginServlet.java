/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.LoginAndOut;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"}, initParams = {
    @WebInitParam(name = "onoma", value = "NotValid")})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher desp;
        String contextPath = request.getContextPath();
        String path;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("1234")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            path = "/index.jsp";
            response.sendRedirect(contextPath+path);

        } else {
            path = "/login.jsp";
            String message = "Credentials Are Wrong";
            request.setAttribute("message", message);
            response.sendRedirect(contextPath + path + "?message=" + message);
        }

    }

}
