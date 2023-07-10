package com.cg.hbm.entites;

import java.util.ArrayList;
//import java.sql.Blob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity														//Auto generate Payments table with fields in database
//@Table(name = "RoomDetails")
public class RoomDetails {
	@Id														//Annotation used to make or mark that variable as primary key
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROOM_SEQ")			//Generate Auto value for id using sequence
    @SequenceGenerator(sequenceName = "room_seq", allocationSize = 1, name = "ROOM_SEQ")
	private int roomId;
	private String roomNo;
	private String roomType;
	private double ratePerDay;
	private boolean isAvailable;
		
	@ManyToOne//(cascade = CascadeType.ALL)					//Providing asociation as ManyToOne between roomdetails and hotel
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	@OneToMany(mappedBy = "roomdetails",cascade = CascadeType.ALL)				//Providing asociation as OneToMany between bookingdetails and roomdetails
	private List<BookingDetails> bookingdetail = new ArrayList<BookingDetails>();
	
	//Getters And Setters 
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getRatePerDay() {
		return ratePerDay;
	}
	public void setRatePerDay(double ratePerDay) {
		this.ratePerDay = ratePerDay;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public List<BookingDetails> getBookingdetail() {
		return bookingdetail;
	}
	public void setBookingdetail(List<BookingDetails> bookingdetail) {
		this.bookingdetail = bookingdetail;
	}
	
	//Parameterized Constructor
	public RoomDetails(@NotNull int roomId,
			@NotEmpty(message = "Please Enter Room No.") @Size(min = 1, max = 3, message = "Enter Room No. in between 1 and 3") String roomNo,
			@NotEmpty(message = "Please Enter Room Type") @Size(min = 3, max = 6, message = "Enter Room Type in between 3 and 6") String roomType,
			@NotNull(message = "Please Provide Rate Per Day") @DecimalMin("1.0") double ratePerDay,
			@NotNull(message = "Please provide booking is available as true or false") @AssertFalse boolean isAvailable,
			Hotel hotel, List<BookingDetails> bookingdetail) {
		super();
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.ratePerDay = ratePerDay;
		this.isAvailable = isAvailable;
		this.hotel = hotel;
		this.bookingdetail = bookingdetail;
	}
	
	//Default Constructor
	public RoomDetails() {
		super();
	}
	
	//Parameterized Constructor
	public RoomDetails(int roomId,
			@NotEmpty(message = "Please Enter Room No.") @Size(min = 1, max = 3, message = "Enter Room No. in between 1 and 3") String roomNo,
			@NotEmpty(message = "Please Enter Room Type") @Size(min = 3, max = 6, message = "Enter Room Type in between 3 and 6") String roomType,
			@NotNull(message = "Please Provide Rate Per Day") @DecimalMin("1.0") double ratePerDay,
			@NotNull(message = "Please provide booking is available as true or false") boolean isAvailable) {
		super();
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.ratePerDay = ratePerDay;
		this.isAvailable = isAvailable;
	}
	
}