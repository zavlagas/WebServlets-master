/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.servlet.customer;

import emergon.entity.Customer;
import emergon.service.CustomerService;
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
@WebServlet(name = "EditCustomerServlet", urlPatterns = {"/customer/editCustomer"})
public class EditCustomerServlet extends HttpServlet {

    CustomerService service = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Customer customer = service.findCustomer(id);
        req.setAttribute("customer", customer);
        RequestDispatcher dispacher = req.getRequestDispatcher("/customer/customerEditForm.jsp");
        dispacher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id = req.getParameter("id");
       String name = req.getParameter("name");
       service.updateCustomer(id ,name );
       resp.sendRedirect(req.getContextPath()+"/ListCustomerServlet");
    }

}
