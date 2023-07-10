package com.cg.hbm.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity									//Auto generate BookingDetails table with fields in database
//@Table(name = "BookingDetails")
public class BookingDetails {
	@Id									//Annotation used to make or mark that variable as primary key
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOKING_SEQ")				//Generate Auto value for id using sequence
    @SequenceGenerator(sequenceName = "booking_seq", allocationSize = 1, name = "BOOKING_SEQ")
	private int bookingId;
	private LocalDate bookedFrom;
	private LocalDate bookedTo;
	private int noOfAdults;
	private int noOfChildren;
	private double amount;
	
	
	@ManyToOne//(cascade = CascadeType.ALL)				//Providing asociation as ManyToOne between bookingdetails and user
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "bookingdetails", cascade = CascadeType.ALL) //Providing asociation as OneToMany between bookingdetails and payments
	private List<Payments> payment = new ArrayList<Payments>();
	
	@ManyToOne//(cascade = CascadeType.ALL)				//Providing asociation as ManyToOne between bookingdetails and roomdetails
	@JoinColumn(name = "room_id")
	private RoomDetails roomdetails;
	
	@ManyToOne//(cascade = CascadeType.ALL)				//Providing asociation as OneToOne between bookingdetails and hotel
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	
	//Getters and Setters
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getBookedFrom() {
		return bookedFrom;
	}
	public void setBookedFrom(LocalDate bookedFrom) {
		this.bookedFrom = bookedFrom;
	}
	public LocalDate getBookedTo() {
		return bookedTo;
	}
	public void setBookedTo(LocalDate bookedTo) {
		this.bookedTo = bookedTo;
	}
	public int getNoOfAdults() {
		return noOfAdults;
	}
	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}
	public int getNoOfChildren() {
		return noOfChildren;
	}
	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Payments> getPayment() {
		return payment;
	}
	public void setPayment(List<Payments> payment) {
		this.payment = payment;
	}
	public RoomDetails getRoomdetails() {
		return roomdetails;
	}
	public void setRoomdetails(RoomDetails roomdetails) {
		this.roomdetails = roomdetails;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	//Default Constructor
	public BookingDetails() {
		super();
		
	}
	
	//Parameterized Constructor
	public BookingDetails(int bookingId, LocalDate bookedFrom, LocalDate bookedTo, int noOfAdults, int noOfChildren,
			double amount, User user, List<Payments> payment, RoomDetails roomdetails, Hotel hotel) {
		super();
		this.bookingId = bookingId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.amount = amount;
		this.user = user;
		this.payment = payment;
		this.roomdetails = roomdetails;
		this.hotel = hotel;
	}
	
	//Parameterized Constructor
	public BookingDetails(int bookingId, LocalDate bookedFrom, LocalDate bookedTo, int noOfAdults, int noOfChildren,
			double amount) {
		super();
		this.bookingId = bookingId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.amount = amount;
	}
	
	//Parameterized Constructor
	public BookingDetails(int bookingId, LocalDate bookedFrom, LocalDate bookedTo, int noOfAdults, int noOfChildren,
			double amount, User user, RoomDetails roomdetails, Hotel hotel) {
		super();
		this.bookingId = bookingId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.amount = amount;
		this.user = user;
		this.roomdetails = roomdetails;
		this.hotel = hotel;
	}
	
}