/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.servlet.product;

import emergon.service.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "DeleteProductServlet", urlPatterns = {"/product/deleteProduct"})
public class DeleteProductServlet extends HttpServlet {


    ProductService service = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pcode = request.getParameter("id");
        String message = service.deleteProduct(pcode);
         String contextPath = request.getContextPath();
        if(message == null){
           
            response.sendRedirect(contextPath+"/ListProductServlet");
        //redirect to the list of products
        
        }else{
            request.setAttribute("minima", message);
            RequestDispatcher dispatc = request.getRequestDispatcher("/errorPage.jsp");
            dispatc.forward(request, response);
//         response.getWriter().print(message);
        }
        //Send Back The Response
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
