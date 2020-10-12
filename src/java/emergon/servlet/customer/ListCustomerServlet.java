package emergon.servlet.customer;

import emergon.entity.Customer;
import emergon.service.CustomerService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ListCustomerServlet", urlPatterns = {"/ListCustomerServlet"})
public class ListCustomerServlet extends HttpServlet {

    private CustomerService service = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = new ArrayList();
        String contextPath = req.getContextPath();
        customers = service.getCustomers();
        HttpSession session = req.getSession();
        session.setAttribute("customers", customers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/customerList.jsp");
        dispatcher.forward(req, resp);

    }

}
