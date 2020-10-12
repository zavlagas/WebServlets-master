/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.servlet.salesman;

import emergon.entity.Salesman;
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
@WebServlet(name = "EditSalesmanServlet", urlPatterns = {"/salesman/editSalesman"})
public class EditSalesmanServlet extends HttpServlet {

    SalesmanService service = new SalesmanService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Salesman salesman = service.findById(id);
        req.setAttribute("salesman", salesman);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/salesman/salesmanEditForm.jsp");
        dispatcher.forward(req, resp);
    }

//                <label for="slid">Enter Name</label>
//                <input id="slid" type="number" value="${salesman.scode}" name="id" readonly />
//                <label for="slname">Enter Name</label>
//                <input id="slname" type="text" value="${salesman.sname}" name="name"/>
//                <label for="slCity">Enter City</label>
//                <input id="slCity" type="text" value="${salesman.scity}" name="city"/>
//                <label for="slcomm">Enter Commision</label>
//                <input id="slcomm" type="number" value="${salesman.scomm}" name="comm"/>
//                <input class="btn" type="submit" value="Submit"/>
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String comm = req.getParameter("comm");

        service.updateSalesman(id, name, city, comm);
        resp.sendRedirect(contextPath + "/ListSalesmanServlet");
    }

}
