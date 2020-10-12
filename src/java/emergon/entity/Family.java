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
public class Family {

    private String frelationship;
    private String fname;
    private Date dob;

    public Family() {
    }

    public Family(String frelationship, String fname, Date dob) {
        this.frelationship = frelationship;
        this.fname = fname;
        this.dob = dob;
    }

    public String getFrelationship() {
        return frelationship;
    }

    public void setFrelationship(String frelationship) {
        this.frelationship = frelationship;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.frelationship);
        hash = 79 * hash + Objects.hashCode(this.fname);
        hash = 79 * hash + Objects.hashCode(this.dob);
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
        final Family other = (Family) obj;
        if (!Objects.equals(this.frelationship, other.frelationship)) {
            return false;
        }
        if (!Objects.equals(this.fname, other.fname)) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        return true;
    }

}
