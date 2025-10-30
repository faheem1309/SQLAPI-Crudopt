package com.pda.Mess.ql.API.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MessBill {

    @Id
    private int bid;         
    private String sname;     
    private int roomno;       
    private String dept;      
    private double cpd;       
    private int nod;          
    private double total;

    // Auto calculate total whenever cost/day or number of days changes
    public void calculateTotal() {
        this.total = this.cpd * this.nod;
    }

    public int getBid() {
        return bid;
    }
    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getRoomno() {
        return roomno;
    }
    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }

    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }

    public double getCpd() {
        return cpd;
    }
    public void setCpd(double cpd) {
        this.cpd = cpd;
        calculateTotal(); // update total automatically
    }

    public int getNod() {
        return nod;
    }
    public void setNod(int nod) {
        this.nod = nod;
        calculateTotal(); // update total automatically
    }

    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "MessBill [bid=" + bid + ", sname=" + sname + ", roomno=" + roomno +
                ", dept=" + dept + ", cpd=" + cpd + ", nod=" + nod + ", total=" + total + "]";
    }
}
