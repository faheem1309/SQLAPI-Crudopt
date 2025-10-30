package com.pda.BankQL.API.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bank {
		
		@Id
	 	private int bid;          
	    private String aname;     
	    private String bname;     
	    private double bal;
		public int getBid() {
			return bid;
		}
		public void setBid(int bid) {
			this.bid = bid;
		}
		public String getAname() {
			return aname;
		}
		public void setAname(String aname) {
			this.aname = aname;
		}
		public String getBname() {
			return bname;
		}
		public void setBname(String bname) {
			this.bname = bname;
		}
		public double getBal() {
			return bal;
		}
		public void setBal(double bal) {
			this.bal = bal;
		}
		@Override
		public String toString() {
			return "Bank [bid=" + bid + ", aname=" + aname + ", bname=" + bname + ", bal=" + bal + "]";
		}
	    
	    
}
