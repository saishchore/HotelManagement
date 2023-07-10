package com.cg.hbm.entites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity														//Auto generate Payments table with fields in database
public class Payments 
{
	@Id														//Annotation used to make or mark that variable as primary key
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYMENT_SEQ")				//Generate Auto value for id using sequence
    @SequenceGenerator(sequenceName = "payment_seq", allocationSize = 1, name = "PAYMENT_SEQ")
	private int paymentId;
	private double amount;
	
	@ManyToOne												//Providing asociation as ManyToOne between bookingdetails and payments
	@JoinColumn(name = "booking_id")
	private BookingDetails bookingdetails;
	
	//Getters and Setters
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	public BookingDetails getBookingdetails() {
		return bookingdetails;
	}
	public void setBookingdetails(BookingDetails bookingdetails) {
		this.bookingdetails = bookingdetails;
	}
	
	//Parameterized Constructor
	public Payments(int paymentId, double amount, BookingDetails bookingdetails) 
	{
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.bookingdetails = bookingdetails;
	}
	
	//Default Constructor
	public Payments() {
		super();
	}
	
	
	
}