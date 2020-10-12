/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.servlet.sales;

import emergon.entity.Sales;
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

/**
 *
 * @author User
 */
@WebServlet(name = "ListSalesServlet", urlPatterns = {"/ListSalesServlet"})
public class ListSalesServlet extends HttpServlet {

    SalesService service = new SalesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Sales> sales = service.getAllSales();
        req.setAttribute("sales", sales);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/sales/salesList.jsp");
        dispatcher.forward(req, resp);
    }

}
