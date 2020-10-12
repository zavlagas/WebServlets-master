/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.entity;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author User
 */
public class Salesman {

    private int scode;
    private String sname;
    private String scity;
    private double scomm;
    private List<Family> family;

    public Salesman() {
    }

    public Salesman(int scode) {
        this.scode = scode;
    }
    

    public Salesman(String sname) {
        this.sname = sname;
    }

    public Salesman(String sname, String scity, double scomm) {
        this.sname = sname;
        this.scity = scity;
        this.scomm = scomm;
    }

    public Salesman(int scode, String sname, String scity, double scomm) {
        this.scode = scode;
        this.sname = sname;
        this.scity = scity;
        this.scomm = scomm;
    }

    public Salesman(int scode, String sname, String scity, double scomm, List<Family> family) {
        this.scode = scode;
        this.sname = sname;
        this.scity = scity;
        this.scomm = scomm;
        this.family = family;
    }

    public int getScode() {
        return scode;
    }

    public void setScode(int scode) {
        this.scode = scode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    public double getScomm() {
        return scomm;
    }

    public void setScomm(double scomm) {
        this.scomm = scomm;
    }

    public List<Family> getFamily() {
        return family;
    }

    public void setFamily(List<Family> family) {
        this.family = family;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Salesman{scode=").append(scode);
        sb.append(", sname=").append(sname);
        sb.append(", scity=").append(scity);
        sb.append(", scomm=").append(scomm);
        sb.append(", family=").append(family);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.scode;
        hash = 23 * hash + Objects.hashCode(this.sname);
        hash = 23 * hash + Objects.hashCode(this.scity);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.scomm) ^ (Double.doubleToLongBits(this.scomm) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.family);
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
        final Salesman other = (Salesman) obj;
        if (this.scode != other.scode) {
            return false;
        }
        if (Double.doubleToLongBits(this.scomm) != Double.doubleToLongBits(other.scomm)) {
            return false;
        }
        if (!Objects.equals(this.sname, other.sname)) {
            return false;
        }
        if (!Objects.equals(this.scity, other.scity)) {
            return false;
        }
        if (!Objects.equals(this.family, other.family)) {
            return false;
        }
        return true;
    }

}
