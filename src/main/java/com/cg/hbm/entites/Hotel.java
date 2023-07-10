package com.cg.hbm.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity											//Auto generate Hotel table with fields in database
public class Hotel {
	@Id											//Annotation used to make or mark that variable as primary key
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOTEL_SEQ")			//Generate Auto value for id using sequence
    @SequenceGenerator(sequenceName = "hotel_seq", allocationSize = 1, name = "HOTEL_SEQ")
	private int hotelId;
	
	@NotEmpty(message = "Please Enter City")								//Validation part
	@Size(min = 3, max = 20, message = "Enter City in between 3 and 20")
	private String city;
	
	@NotEmpty(message = "Please Enter Hotel Name")							//Validation part
	@Size(min = 4, max = 20, message = "Enter Hotel Name in between 4 and 9")
	private String hotelName;
	
	@NotEmpty(message = "Please Enter Address")								//Validation part
	@Size(min = 3, max = 25, message = "Enter address in between 3 and 25")
	private String address;
	
	@NotEmpty(message = "Please Enter Description")							//Validation part
	@Size(min = 5, max = 150, message = "Enter Description in between 5 and 150")
	private String description;
	
	@NotNull(message = "Please Provide Rate Per Day")						//Validation part
	@DecimalMin(value = "1.0")
	private double avgRatePerDay;
	
	@NotEmpty(message = "Please Enter Email")								//Validation part
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Enter Email in proper format.")
	private String email;
	
	@NotEmpty(message = "Please Enter Mobile No.")							//Validation part
	@Size(min = 5, max = 10, message = "Enter mobile no. in between 5 and 10 ")
	@Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "Invalid Mobile No.")
	private String phone1;
	
	@NotEmpty(message = "Please Enter Mobile No.")							//Validation part
	@Size(min = 5, max = 10, message = "Enter mobile no. in between 5 and 10 ")
	@Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "Invalid Mobile No.")
	private String phone2;
	
	@NotEmpty(message = "Please Enter Website")								//Validation part
	@Pattern(regexp = "(www.)?"+ "[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]"+ "{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)", message = "Invalid website")
	private String website;
	
	private String imageUrl;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)				//Providing asociation as OneToMany between roomdetails and hotel
	private List<RoomDetails> roomdetails = new ArrayList<RoomDetails>();
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)											//Providing asociation as OneToOne between bookingdetails and hotel
	private List<BookingDetails> bookingdetails = new ArrayList<BookingDetails>();
	
	
	//Getters And Setters
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAvgRatePerDay() {
		return avgRatePerDay;
	}
	public void setAvgRatePerDay(double avgRatePerDay) {
		this.avgRatePerDay = avgRatePerDay;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public List<RoomDetails> getRoomdetails() {
		return roomdetails;
	}
	public void setRoomdetails(List<RoomDetails> roomdetails) {
		this.roomdetails = roomdetails;
	}
		
	public List<BookingDetails> getBookingdetails() {
		return bookingdetails;
	}
	public void setBookingdetails(List<BookingDetails> bookingdetails) {
		this.bookingdetails = bookingdetails;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	//Parameterized Constructor
	public Hotel(int hotelId,
			@NotEmpty(message = "Please Enter City") @Size(min = 3, max = 20, message = "Enter City in between 3 and 20") String city,
			@NotEmpty(message = "Please Enter Hotel Name") @Size(min = 4, max = 20, message = "Enter Hotel Name in between 4 and 9") String hotelName,
			@NotEmpty(message = "Please Enter Address") @Size(min = 3, max = 25, message = "Enter address in between 3 and 25") String address,
			@NotEmpty(message = "Please Enter Description") @Size(min = 5, max = 150, message = "Enter Description in between 5 and 150") String description,
			@NotNull(message = "Please Provide Rate Per Day") @DecimalMin("1.0") double avgRatePerDay,
			@NotEmpty(message = "Please Enter Email") @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter Email in proper format.") String email,
			@NotEmpty(message = "Please Enter Mobile No.") @Size(min = 5, max = 10, message = "Enter mobile no. in between 5 and 10 ") @Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "Invalid Mobile No.") String phone1,
			@NotEmpty(message = "Please Enter Mobile No.") @Size(min = 5, max = 10, message = "Enter mobile no. in between 5 and 10 ") @Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "Invalid Mobile No.") String phone2,
			@NotEmpty(message = "Please Enter Website") @Pattern(regexp = "(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)", message = "Invalid website") String website,
			String imageUrl) {
		super();
		this.hotelId = hotelId;
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatePerDay = avgRatePerDay;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.website = website;
		this.imageUrl = imageUrl;
	}
	
	//Parameterized Constructor
	
	public Hotel(int hotelId,
			@NotEmpty(message = "Please Enter City") @Size(min = 3, max = 20, message = "Enter City in between 3 and 20") String city,
			@NotEmpty(message = "Please Enter Hotel Name") @Size(min = 4, max = 20, message = "Enter Hotel Name in between 4 and 9") String hotelName,
			@NotEmpty(message = "Please Enter Address") @Size(min = 3, max = 25, message = "Enter address in between 3 and 25") String address,
			@NotEmpty(message = "Please Enter Description") @Size(min = 5, max = 150, message = "Enter Description in between 5 and 150") String description,
			@NotNull(message = "Please Provide Rate Per Day") @DecimalMin("1.0") double avgRatePerDay,
			@NotEmpty(message = "Please Enter Email") @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter Email in proper format.") String email,
			@NotEmpty(message = "Please Enter Mobile No.") @Size(min = 5, max = 10, message = "Enter mobile no. in between 5 and 10 ") @Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "Invalid Mobile No.") String phone1,
			@NotEmpty(message = "Please Enter Mobile No.") @Size(min = 5, max = 10, message = "Enter mobile no. in between 5 and 10 ") @Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "Invalid Mobile No.") String phone2,
			@NotEmpty(message = "Please Enter Website") @Pattern(regexp = "(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)", message = "Invalid website") String website,
			String imageUrl, List<RoomDetails> roomdetails, List<BookingDetails> bookingdetails) {
		super();
		this.hotelId = hotelId;
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatePerDay = avgRatePerDay;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.website = website;
		this.imageUrl = imageUrl;
		this.roomdetails = roomdetails;
		this.bookingdetails = bookingdetails;
	}
	
	public Hotel(int hotelId,
			@NotEmpty(message = "Please Enter City") @Size(min = 3, max = 20, message = "Enter City in between 3 and 20") String city,
			@NotEmpty(message = "Please Enter Hotel Name") @Size(min = 4, max = 20, message = "Enter Hotel Name in between 4 and 9") String hotelName,
			@NotEmpty(message = "Please Enter Address") @Size(min = 3, max = 25, message = "Enter address in between 3 and 25") String address,
			@NotEmpty(message = "Please Enter Description") @Size(min = 5, max = 150, message = "Enter Description in between 5 and 150") String description,
			@NotNull(message = "Please Provide Rate Per Day") @DecimalMin("1.0") double avgRatePerDay,
			@NotEmpty(message = "Please Enter Email") @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter Email in proper format.") String email,
			@NotEmpty(message = "Please Enter Mobile No.") @Size(min = 5, max = 10, message = "Enter mobile no. in between 5 and 10 ") @Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "Invalid Mobile No.") String phone1,
			@NotEmpty(message = "Please Enter Mobile No.") @Size(min = 5, max = 10, message = "Enter mobile no. in between 5 and 10 ") @Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "Invalid Mobile No.") String phone2,
			@NotEmpty(message = "Please Enter Website") @Pattern(regexp = "(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)", message = "Invalid website") String website) {
		super();
		this.hotelId = hotelId;
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatePerDay = avgRatePerDay;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.website = website;
	}
	//Default Constructor
	public Hotel() {
		super();
	}
	
	
	
}