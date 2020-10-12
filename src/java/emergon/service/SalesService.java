/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.dao.CustomerDao;
import emergon.dao.ProductDao;
import emergon.dao.SalesDao;
import emergon.dao.SalesmanDao;
import emergon.entity.Customer;
import emergon.entity.Product;
import emergon.entity.Sales;
import emergon.entity.Salesman;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class SalesService {

    SalesDao sdao = new SalesDao();
    CustomerDao cdao = new CustomerDao();
    SalesmanDao smdao = new SalesmanDao();
    ProductDao pdao = new ProductDao();

    public List<Sales> getArrayListConverter(List<Sales> sales) {
        List<Sales> listOfSales = new ArrayList<>();
        for (Sales sale : sales) {
            Salesman salesman = smdao.findById(sale.getSalesman().getScode());
            Customer customer = cdao.findById(sale.getCustomer().getCcode());
            Product product = pdao.findById(sale.getProduct().getPcode());
            Sales saleEntity = new Sales(sale.getScode(), salesman, customer, product, sale.getProductQuantity(), sale.getProductCost(), sale.getDateOfSale());
            listOfSales.add(saleEntity);
        }
        return (listOfSales);
    }

    public Sales getSaleConverter(Sales sales) {

        Salesman salesman = smdao.findById(sales.getSalesman().getScode());
        Customer customer = cdao.findById(sales.getCustomer().getCcode());
        Product product = pdao.findById(sales.getProduct().getPcode());
        Sales sale = new Sales(sales.getScode(), salesman, customer, product, sales.getProductQuantity(), sales.getProductCost(), sales.getDateOfSale());

        return (sale);
    }

    public List<Sales> getAllSales() {
        List<Sales> listOfsales = sdao.getAllSales();
        List<Sales> sales = getArrayListConverter(listOfsales);
        return (sales);
    }

    public void createSale(String salesmanId, String customerId, String productId, String quant, String cost, String date) {
        int smId = Integer.parseInt(salesmanId);
        int cuId = Integer.parseInt(customerId);
        int proId = Integer.parseInt(productId);
        int quantity = Integer.parseInt(quant);
        double saleCost = Integer.parseInt(cost);
        Date dateOfSale = Date.valueOf(date);
        sdao.createSale(smId, cuId, proId, quantity, saleCost, dateOfSale);
    }

    public void deleteSalesById(String id) {
        int salesId = Integer.parseInt(id);
        sdao.deleteById(salesId);
    }

    public Sales findSaleById(String id) {
        int SaleId = Integer.parseInt(id);
        Sales sales = sdao.findById(SaleId);
        Sales sale = getSaleConverter(sales);

        return (sale);
    }

}
