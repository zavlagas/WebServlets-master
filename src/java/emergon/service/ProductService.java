/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.dao.ProductDao;
import emergon.entity.Product;
import java.util.List;

/**
 *
 * @author User
 */
public class ProductService {

    ProductDao pdao = new ProductDao();

    public List<Product> getProducts() {

        return (pdao.findAll());
    }

    public String deleteProduct(String pcode) {
        int code = Integer.parseInt(pcode);
        String message = pdao.delete(code);
        return (message);
    }

    public void createProduct(String descr, String price) {
        double timi = Double.parseDouble(price);
        Product product = new Product(descr, timi);
        pdao.create(product);
    }

    public Product findProduct(String id) {
        int pcode = Integer.parseInt(id);
        Product product = pdao.findById(pcode);
        return(product);
    }

    public void updateProduct(String productId, String descr, String price) {
       int code = Integer.parseInt(productId);
       double timi = Double.parseDouble(price);
       Product p = new Product(code, descr, timi);
       pdao.update(p);
    }

}
