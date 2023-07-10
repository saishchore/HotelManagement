package com.cg.hbm.pojo;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MHotel 				//Maintain pojo class for entity class for taking particular input and showing output
{
	private int hotelId;			//Parameters maintain in pojo class
	
	@NotEmpty(message = "Please Enter City")								//Validation part
	@Size(min = 3, max = 20, message = "Enter City in between 3 and 20")
	private String city;
	
	@NotEmpty(message = "Please Enter Hotel Name")							//Validation part
	@Size(min = 4, max = 20, message = "Enter Hotel Name in between 4 and 20")
	private String hotelName;
	
	@NotEmpty(message = "Please Enter Address")								//Validation part
	@Size(min = 3, max = 25, message = "Enter Address in between 3 and 25")
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
	
//	@NotEmpty(message = "Please Enter Url")
	@Size(min = 1, message = "Enter the url with minimum size 1")
	private String imageUrl;
	
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
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	//Parameterized Constructor
	public MHotel(int hotelId,
			@NotEmpty(message = "Please Enter City") @Size(min = 3, max = 20, message = "Enter City in between 3 and 20") String city,
			@NotEmpty(message = "Please Enter Hotel Name") @Size(min = 4, max = 20, message = "Enter Hotel Name in between 4 and 20") String hotelName,
			@NotEmpty(message = "Please Enter Address") @Size(min = 3, max = 25, message = "Enter Address in between 3 and 25") String address,
			@NotEmpty(message = "Please Enter Description") @Size(min = 5, max = 150, message = "Enter Description in between 5 and 150") String description,
			@NotNull(message = "Please Provide Rate Per Day") @DecimalMin("1.0") double avgRatePerDay,
			@NotEmpty(message = "Please Enter Email") @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter Email in proper format.") String email,
			@NotEmpty(message = "Please Enter Mobile No.") @Size(min = 5, max = 10, message = "Enter mobile no. in between 5 and 10 ") @Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "Invalid Mobile No.") String phone1,
			@NotEmpty(message = "Please Enter Mobile No.") @Size(min = 5, max = 10, message = "Enter mobile no. in between 5 and 10 ") @Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "Invalid Mobile No.") String phone2,
			@NotEmpty(message = "Please Enter Website") @Pattern(regexp = "(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)", message = "Invalid website") String website,
			@Size(min = 1, message = "Enter the url with minimum size 1") String imageUrl) {
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
	
	
	public MHotel(int hotelId,
			@NotEmpty(message = "Please Enter City") @Size(min = 3, max = 20, message = "Enter City in between 3 and 20") String city,
			@NotEmpty(message = "Please Enter Hotel Name") @Size(min = 4, max = 20, message = "Enter Hotel Name in between 4 and 20") String hotelName,
			@NotEmpty(message = "Please Enter Address") @Size(min = 3, max = 25, message = "Enter Address in between 3 and 25") String address,
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
	public MHotel() {
		super();
	}
	
	
	
}
