/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.entity;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author User
 */
public class Sales {

    private int scode;
    private Salesman salesman;
    private Customer customer;
    private Product product;
    private int productQuantity;
    private double productCost;
    private Date dateOfSale;

    public Sales() {
    }

    public Sales(Salesman salesman, Customer customer, Product product, int productQuantity, double productCost, Date dateOfSale) {
        this.salesman = salesman;
        this.customer = customer;
        this.product = product;
        this.productQuantity = productQuantity;
        this.productCost = productCost;
        this.dateOfSale = dateOfSale;
    }

    public Sales(int scode, Salesman salesman, Customer customer, Product product, int productQuantity, double productCost, Date dateOfSale) {
        this.scode = scode;
        this.salesman = salesman;
        this.customer = customer;
        this.product = product;
        this.productQuantity = productQuantity;
        this.productCost = productCost;
        this.dateOfSale = dateOfSale;
    }

    public int getScode() {
        return scode;
    }

    public void setScode(int scode) {
        this.scode = scode;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sales{scode=").append(scode);
        sb.append(", salesman=").append(salesman);
        sb.append(", customer=").append(customer);
        sb.append(", product=").append(product);
        sb.append(", productQuantity=").append(productQuantity);
        sb.append(", productCost=").append(productCost);
        sb.append(", dateOfSale=").append(dateOfSale);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.scode;
        hash = 83 * hash + Objects.hashCode(this.salesman);
        hash = 83 * hash + Objects.hashCode(this.customer);
        hash = 83 * hash + Objects.hashCode(this.product);
        hash = 83 * hash + this.productQuantity;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.productCost) ^ (Double.doubleToLongBits(this.productCost) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.dateOfSale);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sales other = (Sales) obj;
        if (this.scode != other.scode) {
            return false;
        }
        if (this.productQuantity != other.productQuantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.productCost) != Double.doubleToLongBits(other.productCost)) {
            return false;
        }
        if (!Objects.equals(this.salesman, other.salesman)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.dateOfSale, other.dateOfSale)) {
            return false;
        }
        return true;
    }

}
