/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.dao;

import emergon.entity.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class CustomerDao extends SuperDao {

    private final String FINDBYID = "SELECT * FROM customer WHERE ccode = ?";
    private final String UPDATECUSTOMERBYID = "UPDATE customer SET cname = ? WHERE ccode = ? ";
    private final String DELETECUSTOMERBYID = "DELETE FROM customer WHERE ccode = ?";

    public List<Customer> findAll() {

        List<Customer> customers = new ArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn;

        try {
            //Connect to DB and get data
            conn = openConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT ccode, cname FROM CUSTOMER;");
            while (rs.next()) {
                int ccode = rs.getInt("ccode");
                String cname = rs.getString(2);
                Customer c = new Customer(ccode, cname);
                customers.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(stmt, rs);
        }
        return (customers);
    }

    public void create(String cname) {
        PreparedStatement pstm = null;
        String query = "INSERT INTO customer(cname) VALUES (?)";
        try {
            pstm = openConnection().prepareStatement(query);
            pstm.setString(1, cname);
            int result = pstm.executeUpdate();
            if (result > 0) {
                System.out.println("Customer successfully creating");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstm, null);
        }

    }

    public Customer findById(int CustomerId) {
        Customer customer = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(FINDBYID);
            pstmt.setInt(1, CustomerId);
            rs = pstmt.executeQuery();
            rs.next();
            int code = rs.getInt(1);
            String name = rs.getString(2);
            customer = new Customer(code, name);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstmt, rs);
        }
        return (customer);
    }

    public void update(Customer customer) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(UPDATECUSTOMERBYID);
            pstmt.setString(1, customer.getCname());
            pstmt.setInt(2, customer.getCcode());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstmt, null);
        }

    }

    public void delete(int CustomerId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(DELETECUSTOMERBYID);
            pstmt.setInt(1, CustomerId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            closeConnections(pstmt, null);

        }

    }

}
