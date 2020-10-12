/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.dao.SalesmanDao;
import emergon.entity.Family;
import emergon.entity.Salesman;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class SalesmanService {

    SalesmanDao smdao = new SalesmanDao();

    public List<Salesman> getSalesman() {

        return (smdao.findAll());
    }

    public String deleteSalesman(String scode) {
        int code = Integer.parseInt(scode);
        String message = smdao.delete(code);
        return (message);
    }

    public void createSalesman(String name, String city, String comm) {
        int commision = Integer.parseInt(comm);
        Salesman salesman = new Salesman(name, city, commision);
        smdao.create(salesman);
    }

    public Salesman findById(String id) {
        int salesmanId = Integer.parseInt(id);
        Salesman salesman = smdao.findById(salesmanId);
        return (salesman);
    }

    public void updateSalesman(String id, String name, String city, String comm) {
        int salesmanId = Integer.parseInt(id);
        double commision = Double.parseDouble(comm);
        Salesman salesman = new Salesman(salesmanId, name, city, commision);
        smdao.update(salesman);
    }

    public Salesman findSalesmanFamilyWith(String id) {
        List<Family> family;
        int salesmanId = Integer.parseInt(id);
        Salesman salesman = smdao.findById(salesmanId);
        family = smdao.findSalesmanFamily(salesman);
        salesman.setFamily(family);

        return (salesman);
    }

    public void createFamilyMember(String salemanId, String name, String relation, String dob) {
        Salesman salesman = findById(salemanId);
        Family family = new Family(relation, name, Date.valueOf(dob));
        smdao.createFamilyMember(salesman, family);
    }

    public void deleteFamilyMember(String salesmanId, String name, String relation, String dob) {
        Salesman salesman = findById(salesmanId);
        Family family = new Family(relation, name, Date.valueOf(dob));
        smdao.deleteFamilyMember(salesman, family);

    }

    public Family editFamily(String salesmanId, String name, String relation, String dob) {
        int smId = Integer.parseInt(salesmanId);
        Date dateOfBirth = Date.valueOf(dob);
        Family family = smdao.findFamilyMember(smId, name, relation, dateOfBirth);
        return (family);
    }

    public String updateFamilyMember(String salesmanId, String name, String relation, String dob) {
        int id = Integer.parseInt(salesmanId);
        Salesman salesman = smdao.findById(id);
        Date bithDate = Date.valueOf(dob);
        Family family = new Family(relation, name, bithDate);
        String message = smdao.updateFamilyMember(family, salesman);
        return (message);
    }

}
