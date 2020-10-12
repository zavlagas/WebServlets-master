/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.dao;

import emergon.entity.Customer;
import emergon.entity.Product;
import emergon.entity.Sales;
import emergon.entity.Salesman;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SalesDao extends SuperDao {

    private final String FINDALLSALES = "SELECT * FROM sales;";
    private final String CREATESALE = "INSERT  INTO `sales`(`Pcode`,`Sdate`,`Ccode`,`Smcode`,`Quant`,`Cost`) values (?,?,?,?,?,?)";
    private final String DELETEBYID = "DELETE FROM sales WHERE scode = ? ";
    private final String FINDBYID = "SELECT * FROM sales WHERE scode = ?";

    public List<Sales> getAllSales() {
        List<Sales> ListOfSales = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        conn = openConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDALLSALES);
            while (rs.next()) {
                int salesId = rs.getInt(1);
                int salesmanId = rs.getInt(2);
                int customerId = rs.getInt(3);
                int productId = rs.getInt(4);
                int productQuant = rs.getInt(5);
                double cost = rs.getDouble(6);
                Date salesDate = rs.getDate(7);

                Salesman sm = new Salesman(salesmanId);
                Customer cu = new Customer(customerId);
                Product pro = new Product(productId);

                Sales sales = new Sales(salesId, sm, cu, pro, productQuant, cost, salesDate);
                ListOfSales.add(sales);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(stmt, rs);
        }
        return (ListOfSales);
    }

    public void createSale(int smId, int cuId, int proId, int quantity, double saleCost, Date dateOfSale) {
        // "INSERT  INTO `sales`(`Pcode`,`Sdate`,`Ccode`,`Smcode`,`Quant`,`Cost`) values (?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(CREATESALE);
            pstmt.setInt(1, proId);
            pstmt.setDate(2, dateOfSale);
            pstmt.setInt(3, cuId);
            pstmt.setInt(4, smId);
            pstmt.setInt(5, quantity);
            pstmt.setDouble(6, saleCost);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstmt, null);
        }

    }

    public void deleteById(int salesId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(DELETEBYID);
            pstmt.setInt(1, salesId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnections(pstmt, null);
        }

    }

    public Sales findById(int SaleId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Sales sale = null;

        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(FINDBYID);
            pstmt.setInt(1, SaleId);
            rs = pstmt.executeQuery();
            rs.next();
            int salesId = rs.getInt(1);
            int salesmanId = rs.getInt(2);
            int customerId = rs.getInt(3);
            int productId = rs.getInt(4);
            int productQuant = rs.getInt(5);
            double cost = rs.getDouble(6);
            Date salesDate = rs.getDate(7);

            Salesman sm = new Salesman(salesmanId);
            Customer cu = new Customer(customerId);
            Product pro = new Product(productId);

            sale = new Sales(salesId, sm, cu, pro, productQuant, cost, salesDate);

        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(pstmt, rs);
        }
        
        
        return (sale);

    }

}
