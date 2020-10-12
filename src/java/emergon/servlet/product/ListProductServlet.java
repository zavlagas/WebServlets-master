package emergon.servlet.product;

import emergon.entity.Product;
import emergon.service.ProductService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ListProductServlet" ,urlPatterns = "/ListProductServlet",
        initParams = @WebInitParam(name ="location" , value = "D:/Uploads")
)

public class ListProductServlet extends HttpServlet {

    private ProductService service = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        /*Accept the get request from the browser 
//        Get the list of products from the DB
        List<Product> listOfProducts = service.getProducts();
//        Store them into The Session 
        HttpSession session = req.getSession();
        session.setAttribute("products", listOfProducts);
        //Get Initial parametre from ServletContext
        ServletContext myGlobalContextObject = getServletContext();
        String globalParameter = myGlobalContextObject.getInitParameter("Country");
        req.setAttribute("Country", globalParameter);

        ServletConfig configObjectOfThisServlet = getServletConfig();
        String initParam = configObjectOfThisServlet.getInitParameter("location");
        req.setAttribute("location", initParam);

//        Pass the request to the Jsp page to show the list of products 

//        */
        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productList.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
