/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.servlet.salesman;

import emergon.service.SalesmanService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "CreateSalesmanServlet", urlPatterns = {"/salesman/createSalesman"})
public class CreateSalesmanServlet extends HttpServlet {
    
    SalesmanService service = new SalesmanService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/salesman/salesmanCreateForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String comm = request.getParameter("comm");
        service.createSalesman(name,city,comm);
        response.sendRedirect(contextPath+"/ListSalesmanServlet");
      
    }

   
}
