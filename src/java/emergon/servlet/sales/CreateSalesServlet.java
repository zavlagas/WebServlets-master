/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.servlet.sales;

import emergon.entity.Customer;
import emergon.entity.Product;
import emergon.entity.Salesman;
import emergon.service.SalesService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet(name = "CreateSalesServlet", urlPatterns = {"/sales/create"})
public class CreateSalesServlet extends HttpServlet {

    SalesService service = new SalesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/sales/salesCreateForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String salesmanId = req.getParameter("salesman");
        String customerId = req.getParameter("customer");
        String productId = req.getParameter("product");
        String quant = req.getParameter("quantity");
        String cost = req.getParameter("cost");
        String date = req.getParameter("date");
        
        service.createSale(salesmanId,customerId,productId,quant,cost,date);
        
        resp.sendRedirect(req.getContextPath()+"/ListSalesServlet");

    }

}
