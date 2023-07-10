package com.cg.hbm.pojo;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MRoomDetails 				//Maintain pojo class for entity class for taking particular input and showing output
{
	private int roomId;					//Parameters maintain in pojo class
	
	@NotEmpty(message = "Please Enter Room No.")								//Validation part
	@Size(min = 1, max = 4, message = "Enter Room No. in between 1 and 4")
	private String roomNo;
	
	@NotEmpty(message = "Please Enter Room Type")								//Validation part
	@Size(min = 2, max = 20, message = "Enter Room Type in between 2 and 20")
	private String roomType;
	
	@NotNull(message = "Please Provide Rate Per Day")							//Validation part
	@DecimalMin(value = "1.0")
	private double ratePerDay;
	
	@NotNull(message = "Please provide booking is available as true or false")	//Validation part
	//@AssertFalse
	//@AssertTrue
	private boolean isAvailable;
	
	@NotNull(message = "Please Enter Hotel Id")									//Validation part
	private int hotelId;
	
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
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	
	//Default Constructor
	public MRoomDetails()
	{
		super();
	}
	
	//Parameterized Constructor
	public MRoomDetails(int roomId,
			@NotEmpty(message = "Please Enter Room No.") @Size(min = 1, max = 3, message = "Enter Room No. in between 1 and 3") String roomNo,
			@NotEmpty(message = "Please Enter Room Type") @Size(min = 3, max = 6, message = "Enter Room Type in between 3 and 6") String roomType,
			@NotNull(message = "Please Provide Rate Per Day") @DecimalMin("1.0") double ratePerDay,
			@NotNull(message = "Please provide booking is available as true or false") boolean isAvailable,
			@NotNull(message = "Please Enter Hotel Id") int hotelId) {
		super();
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.ratePerDay = ratePerDay;
		this.isAvailable = isAvailable;
		this.hotelId = hotelId;
	}
	
	//Parameterized Constructor
	public MRoomDetails(int i, double d, String string, String string2, int j) {
		// TODO Auto-generated constructor stub
	}
	
	
}
