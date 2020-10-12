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
@WebServlet(name = "CreateSalesmanFamilyMember", urlPatterns = {"/salesman/createSalesmanFamily"})
public class CreateSalesmanFamilyMember extends HttpServlet {

    SalesmanService service = new SalesmanService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String salesmanId = req.getParameter("id");
        req.setAttribute("salesmanId", salesmanId);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/salesman/createFamilyMember.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String salemanId = req.getParameter("id");
        String name = req.getParameter("name");
        String relation = req.getParameter("relation");
        String dob = req.getParameter("dob");
        service.createFamilyMember(salemanId ,name ,relation ,dob);
        resp.sendRedirect(req.getContextPath()+"/salesman/inspectFamily?id="+salemanId);
        
    }

}
