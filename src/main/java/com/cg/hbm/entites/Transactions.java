package com.cg.hbm.entites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

//@Entity
public class Transactions {
	//@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACT_SEQ")
   // @SequenceGenerator(sequenceName = "transact_seq", allocationSize = 1, name = "TRANSACT_SEQ")
	private int transactionId;
	private double amount;
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
}