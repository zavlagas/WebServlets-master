package emergon.servlet.product;

import emergon.entity.Product;
import emergon.service.ProductService;
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
@WebServlet(name = "EditProduct", urlPatterns = {"/product/editProduct"})
public class EditProductServlet extends HttpServlet {

    ProductService service = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Show Product will fill the form 
        String id = request.getParameter("id");
        Product product = service.findProduct(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/productEditForm.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //Get the parametres from the request 
        //save the object to the database 
        //Redirect to the database
        String contextPath = req.getContextPath();
        String productId = req.getParameter("pcode");
        String descr = req.getParameter("description");
        String price = req.getParameter("price");
        service.updateProduct(productId ,descr, price);
        resp.sendRedirect(contextPath + "/ListProductServlet");
    }

}
