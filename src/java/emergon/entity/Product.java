/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.entity;

/**
 *
 * @author User
 */
public class Product {

    private int pcode;
    private String pdescr;
    private double pprice;

    public Product() {
    }

    public Product(int pcode) {
        this.pcode = pcode;
    }

    public Product(int pcode, String pdescr, double pprice) {
        this.pcode = pcode;
        this.pdescr = pdescr;
        this.pprice = pprice;
    }

    public Product(String pdescr, double pprice) {
        this.pdescr = pdescr;
        this.pprice = pprice;
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public String getPdescr() {
        return pdescr;
    }

    public void setPdescr(String pdescr) {
        this.pdescr = pdescr;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    @Override
    public String toString() {
        return "Product{" + "pcode=" + pcode + ", pdescr=" + pdescr + ", pprice=" + pprice + '}';
    }

}
