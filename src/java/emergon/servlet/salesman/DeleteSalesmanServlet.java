/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.servlet.salesman;

import emergon.service.SalesmanService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "DeleteSalesmanServlet", urlPatterns = {"/salesman/deleteSalesman"})
public class DeleteSalesmanServlet extends HttpServlet {
    
    SalesmanService service = new SalesmanService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        String scode = req.getParameter("id");
        String message = service.deleteSalesman(scode);
        
        if (message == null) {
            resp.sendRedirect(contextPath + "/ListSalesmanServlet");
        } else {
            resp.getWriter().print(message);
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
}
