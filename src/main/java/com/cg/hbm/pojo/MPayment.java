package com.cg.hbm.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MPayment 						//Maintain pojo class for entity class for taking particular input and showing output
{
	private int paymentId;					//Parameters maintain in pojo class
	
	@NotNull(message="enter the amount")	//Validation part
	@Min(1)
	private double amount;
	
	@NotNull(message="enter booking id")	//Validation part
	@Min(1)
	private int bookingId;
	
	
	//Getters And Setters
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	//Parameterized Constructor
	public MPayment(int paymentId, @NotNull(message = "enter the amount") @Min(1) double amount,
			@NotNull(message = "enter booking id") @Min(1) int bookingId) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.bookingId = bookingId;
	}
	
	//Default Constructor
	public MPayment() {
		super();
	}
	
	
	
	
}
