package emergon.servlet.salesman;

import emergon.entity.Salesman;
import emergon.service.SalesmanService;
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
@WebServlet(name = "ListSalesmanServlet", urlPatterns = {"/ListSalesmanServlet"})
public class ListSalesmanServlet extends HttpServlet {
    
    SalesmanService service = new SalesmanService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();
        List<Salesman> salesmen = service.getSalesman();
        HttpSession session = request.getSession();
        session.setAttribute("salesmen", salesmen);
        RequestDispatcher dispatcher = request.getRequestDispatcher("salesman/salesmanList.jsp");
        dispatcher.forward(request, response);
        
    }
    
}
