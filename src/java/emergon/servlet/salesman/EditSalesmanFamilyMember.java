/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.servlet.salesman;

import emergon.entity.Family;
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
@WebServlet(name = "EditSalesmanFamilyMember", urlPatterns = {"/salesman/editFamilyMember"})
public class EditSalesmanFamilyMember extends HttpServlet {

    SalesmanService service = new SalesmanService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String salesmanId = req.getParameter("id");
        String name = req.getParameter("name");
        String relation = req.getParameter("relation");
        String dob = req.getParameter("dob");
        req.setAttribute("salesmanId", salesmanId);
        Family family = service.editFamily(salesmanId, name, relation, dob);
        req.setAttribute("family", family);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/salesman/editSalesmanFamilyForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String salesmanId = req.getParameter("id");
        String name = req.getParameter("name");
        String relation = req.getParameter("relation");
        String dob = req.getParameter("dob");
        String message = service.updateFamilyMember(salesmanId, name, relation, dob);
        req.setAttribute("message", message);
        resp.sendRedirect(req.getContextPath() + "/salesman/inspectFamily?id=" + salesmanId+"&message="+message);

    }

}
