/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.dao;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import emergon.entity.Family;
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
public class SalesmanDao extends SuperDao {

    private final String FINDALL = "SELECT * FROM salesman;";
    private final String DELETEBYID = "DELETE FROM salesman WHERE scode = ?";
    private final String CREATESALESMAN = "INSERT INTO salesman (sname,scity,scomm) VALUES (?,?,?);";
    private final String FINDBYID = "SELECT * FROM salesman WHERE scode = ? ";
    private final String UPDATESALESMANBYID = "UPDATE salesman SET sname = ? , scity = ? , scomm = ? WHERE scode = ?";
    private final String FINDFAMILYBYID = "SELECT * FROM family WHERE salesman = ? ";
    private final String CREATEFAMILYMEMBER = "INSERT INTO family (fname,frelationship,dob,salesman) VALUES (?,?,?,?);";
    private final String DELETEFAMILYMEMBER = "DELETE FROM family WHERE fname = ? AND frelationship = ? AND dob = ? AND salesman = ?";
    private final String FINDFAMILY = "SELECT * FROM family WHERE fname = ? AND frelationship = ? AND dob = ? AND salesman = ?; ";
    private final String UPDATEFAMILYMEMBER = "UPDATE family SET fname = ? , frelationship = ? , dob = ? WHERE salesman = ? AND fname = ? AND frelationship = ? AND dob = ?;";

    public List<Salesman> findAll() {
        List<Salesman> salesmen = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = openConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int scode = rs.getInt(1);
                String sname = rs.getString(2);
                String scity = rs.getString(3);
                double scomm = rs.getDouble(4);
                Salesman sm = new Salesman(scode, sname, scity, scomm);
                salesmen.add(sm);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(stmt, rs);
        }
        return (salesmen);
    }

    public String delete(int idcode) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String message = null;
        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(DELETEBYID);
            pstmt.setInt(1, idcode);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            message = ex.getLocalizedMessage();
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstmt, null);
        }
        return (message);
    }

    public void create(Salesman salesman) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(CREATESALESMAN);
            pstmt.setString(1, salesman.getSname());
            pstmt.setString(2, salesman.getScity());
            pstmt.setDouble(3, salesman.getScomm());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            String message = ex.getLocalizedMessage();
            System.out.println(message);

        } finally {
            closeConnections(pstmt, null);
        }
    }

    public Salesman findById(int salesmanId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Salesman salesman = null;

        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(FINDBYID);
            pstmt.setInt(1, salesmanId);
            rs = pstmt.executeQuery();
            rs.next();
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String city = rs.getString(3);
            double commision = rs.getDouble(4);
            salesman = new Salesman(id, name, city, commision);

        } catch (SQLException ex) {
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstmt, rs);
        }
        return (salesman);
    }

    public void update(Salesman salesman) {
        Connection conn = null;
        PreparedStatement pstm = null;

        conn = openConnection();
        try {
            pstm = conn.prepareStatement(UPDATESALESMANBYID);
//    "UPDATE salesman SET sname = ? , scity = ? , scomm = ? WHERE scode = ?"
            pstm.setString(1, salesman.getSname());
            pstm.setString(2, salesman.getScity());
            pstm.setDouble(3, salesman.getScomm());
            pstm.setInt(4, salesman.getScode());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstm, null);
        }
    }

    public List<Family> findSalesmanFamily(Salesman salesman) {
        List<Family> familyList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(FINDFAMILYBYID);
            pstmt.setInt(1, salesman.getScode());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                String relation = rs.getString(2);
                Date dob = rs.getDate(3);
                Family family = new Family(relation, name, dob);
                familyList.add(family);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstmt, rs);
        }

        return (familyList);
    }

    public void createFamilyMember(Salesman salesman, Family family) {
        //"INSERT INTO family (fname,frelationship,dob,salesman) VALUES (?,?,?,?);";
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(CREATEFAMILYMEMBER);
            pstmt.setString(1, family.getFname());
            pstmt.setString(2, family.getFrelationship());
            pstmt.setDate(3, family.getDob());
            pstmt.setInt(4, salesman.getScode());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstmt, null);
        }

    }

    public void deleteFamilyMember(Salesman salesman, Family family) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = openConnection();
        try {
            //"DELETE FROM family WHERE fname = ? AND frelationship = ? AND dob = ? AND salesman = ?";
            pstmt = conn.prepareStatement(DELETEFAMILYMEMBER);
            pstmt.setString(1, family.getFname());
            pstmt.setString(2, family.getFrelationship());
            pstmt.setDate(3, family.getDob());
            pstmt.setInt(4, salesman.getScode());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstmt, null);
        }
    }

    public String updateFamilyMember(Family family, Salesman salesman) {
        //"UPDATE  SET fname = ? , frelationship = ? , dob = ? WHERE salesman = ? AND fname = ? AND frelationship = ? AND dob = ?;";
        Connection conn = null;
        PreparedStatement pstmt = null;
        String message = null;

        conn = openConnection();
        try {
            pstmt = conn.prepareStatement(UPDATEFAMILYMEMBER);
            pstmt.setString(1, family.getFname());
            pstmt.setString(2, family.getFrelationship());
            pstmt.setDate(3, family.getDob());
            pstmt.setInt(4, salesman.getScode());
            pstmt.setString(5, family.getFname());
            pstmt.setString(6, family.getFrelationship());
            pstmt.setDate(7, family.getDob());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            message = ex.getLocalizedMessage();
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstmt, null);
        }

        return (message);
    }

    public Family findFamilyMember(int smId, String name, String relation, Date dateOfBirth) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Family family = null;

        conn = openConnection();
        try {
            //"SELECT * FROM FAMILY WHERE fname = ? AND frelationship = ? AND dob = ? AND salesman = ?; ";
            pstmt = conn.prepareStatement(FINDFAMILY);
            pstmt.setString(1, name);
            pstmt.setString(2, relation);
            pstmt.setDate(3, dateOfBirth);
            pstmt.setInt(4, smId);
            rs = pstmt.executeQuery();
            rs.next();
            String fname = rs.getString(1);
            String frelationship = rs.getString(2);
            Date dob = rs.getDate(3);
            family = new Family(frelationship, fname, dob);
        } catch (SQLException ex) {
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstmt, rs);
        }

        return (family);
    }

}
