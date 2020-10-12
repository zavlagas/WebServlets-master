/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.dao.CustomerDao;
import emergon.entity.Customer;
import java.util.List;

/**
 *
 * @author User
 */
public class CustomerService {

    CustomerDao cdao = new CustomerDao();

    public List<Customer> getCustomers() {

        return (cdao.findAll());
    }

    public void createCustomer(String cname) {
        cdao.create(cname);
    }

    public Customer findCustomer(String id) {
        int CustomerId = Integer.parseInt(id);
        Customer customer = cdao.findById(CustomerId);
        return (customer);
    }

    public void updateCustomer(String id, String name) {
        int CustomerId = Integer.parseInt(id);
        Customer customer = new Customer(CustomerId, name);
        cdao.update(customer);
    }

    public void deleteCustomer(String id) {
        int CustomerId = Integer.parseInt(id);
        cdao.delete(CustomerId);
    }

}
