/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.dao;

import emergon.entity.Product;
import java.sql.Connection;
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
public class ProductDao extends SuperDao {

    private final String FINDALL = "SELECT pcode,pdescr,pprice FROM PRODUCT;";
    private final String DELETEBYID = "DELETE FROM product WHERE pcode = ?";
    private final String CREATEPRODUCT = "INSERT INTO product (pprice,pdescr) VALUES (?,?);";
    private final String FINDBYID = "SELECT * FROM PRODUCT WHERE pcode = ? ";
    private final String UPDATEPRODUCTBYID = "UPDATE product SET pdescr = ? , pprice = ? WHERE pcode = ?";

    public List<Product> findAll() {
        List<Product> products = new ArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn;

        try {
            //Connect to DB and get data
            conn = openConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int pcode = rs.getInt(1);
                String pdescr = rs.getString(2);
                double pprice = rs.getDouble(3);
                Product p = new Product(pcode, pdescr, pprice);
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(stmt, rs);
        }
        return (products);
    }

    public String delete(int code) {
        boolean deleted = false;
        String message = null;
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(DELETEBYID);
            pstmt.setInt(1, code);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                deleted = true;
            }
        } catch (SQLException ex) {
            message = ex.getLocalizedMessage();
        } finally {
            closeConnections(pstmt, null);
        }
        return (message);
    }

    public void create(Product product) {
        boolean created = false;
        String message = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(CREATEPRODUCT);
            pstmt.setDouble(1, product.getPprice());
            pstmt.setString(2, product.getPdescr());
            pstmt.executeUpdate();
 
        } catch (SQLException ex) {
            message = ex.getLocalizedMessage();
            System.out.println(message);

        } finally {
            closeConnections(pstmt, null);
        }
    }

    public Product findById(int pcode) {
        Connection conn = null;
        PreparedStatement pstm = null;
        Product product = null;
        ResultSet rs = null;

        conn = openConnection();
        try {
            pstm = conn.prepareStatement(FINDBYID);
            pstm.setInt(1, pcode);
            rs = pstm.executeQuery();
            rs.next();
            int code = rs.getInt(1);
            String desc = rs.getString("pdescr");
            double price = rs.getDouble("pprice");
            product = new Product(code, desc, price);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstm, rs);
        }
        return (product);
    }

    public void update(Product p) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(UPDATEPRODUCTBYID);
            pstmt.setString(1, p.getPdescr());
            pstmt.setDouble(2, p.getPprice());
            pstmt.setInt(3, p.getPcode());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            String message = ex.getLocalizedMessage();
//            System.out.println(message);

        } finally {
            closeConnections(pstmt, null);
        }
    }

}
