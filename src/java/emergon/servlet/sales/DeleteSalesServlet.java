/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.servlet.sales;

import emergon.service.SalesService;
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
@WebServlet(name = "DeleteSalesServlet", urlPatterns = {"/sales/deleteSales"})
public class DeleteSalesServlet extends HttpServlet {
    
    SalesService service = new SalesService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        service.deleteSalesById(id);
        resp.sendRedirect(req.getContextPath() + "/ListSalesServlet");
        
    }
    
}
