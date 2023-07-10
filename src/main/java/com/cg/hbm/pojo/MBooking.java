package com.cg.hbm.pojo;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class MBooking 				//Maintain pojo class for entity class for taking particular input and showing output
{
	private int bookingId;			//Parameters maintain in pojo class 
	@FutureOrPresent
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate bookedFrom;
	
	@FutureOrPresent
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate bookedTo;
	
	@NotNull(message="Enter no of adults")			//Validation part
	@Min(1)
	private int noOfAdults;
	
	@NotNull(message="Enter no of children")		//Validation part
	@Min(0)
	private int noOfChildren;
	
	@NotNull(message="Enter total amount")			//Validation part
	@Min(1)
	private double totalamount;
	
	@NotNull(message="Enter room id")				//Validation part
	@Min(1)
	private int roomId;
	
	@NotNull(message="Enter hotel id")				//Validation part
	@Min(1)
	private int hotelId;
	
//	@NotNull(message="Enter user id")				//Validation part
//	@Min(1)
	private String userName;
	
	private int userId;
	
	private String hotelName;
	
		
	//Getters And Setters
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
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
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	//Parameterized Constructor
	public MBooking(int bookingId, LocalDate bookedFrom, LocalDate bookedTo,
			@NotNull(message = "enter no of adults") @Min(1) int noOfAdults, int noOfChildren,
			@NotNull(message = "enter total amount") @Min(1) double totalamount,
			@NotNull(message = "enter room id") @Min(1) int roomId,
			@NotNull(message = "enter hotel id") @Min(1) int hotelId) {
		super();
		this.bookingId = bookingId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.totalamount = totalamount;
		this.roomId = roomId;
		this.hotelId = hotelId;
	}
	
	//Default Constructor
	public MBooking() {
		super();
	}
	
	
}
