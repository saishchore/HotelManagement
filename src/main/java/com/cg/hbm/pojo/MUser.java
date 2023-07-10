package com.cg.hbm.pojo;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MUser  					//Maintain pojo class for entity class for taking particular input and showing output
{
	private int userId;					//Parameters maintain in pojo class
	
	@NotNull(message = "Please Enter User Name")											//Validation part
	@Size(min = 5, max = 9, message = "Enter UserName in between 5 and 9")
	private String userName;
	
	@NotEmpty(message = "Please Enter UserName")									//Validation part
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Enter Email in proper format.")
	private String email;
	
	@NotEmpty(message = "Please Enter Password")									//Validation part
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{6,20}$", message = "Enter password in between 6 and 10")
	private String password;
	
	@NotEmpty(message = "Please Enter Role")										//Validation part
	@Size(min = 3, max = 12, message = "Enter Role in between 3 and 12")
	private String role;
	
	@NotEmpty(message = "Please Enter Mobile No.")									//Validation part
	@Size(min = 5, max = 10, message = "Enter mobile no. in between 5 and 10 ")
	@Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "Invalid Mobile No.")
	private String mobile;
	
	@NotEmpty(message = "Please Enter Address")										//Validation part
	@Size(min = 5, max = 25, message = "Enter address in between 5 and 25")
	private String address;
	
	//Getters And Setters
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	///Parameterized Constructor
	public MUser(int userId,
			@NotNull(message = "Please Enter Name") @Size(min = 5, max = 9, message = "Enter UserName in between 5 and 9") String userName,
			@NotEmpty(message = "Please Enter UserName") @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter Email in proper format.") String email,
			@NotEmpty(message = "Please Enter Password") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{6,20}$", message = "Enter password in between 6 and 10") String password,
			@NotEmpty(message = "Please Enter Role") @Size(min = 3, max = 12, message = "Enter Role in between 3 and 12") String role,
			@NotEmpty(message = "Please Enter Mobile No.") @Size(min = 5, max = 10, message = "Enter mobile no. in between 5 and 10 ") @Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "Invalid Mobile No.") String mobile,
			@NotEmpty(message = "Please Enter Address") @Size(min = 5, max = 25, message = "Enter address in between 5 and 25") String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.address = address;
	}
	
	//Default Constructor
	public MUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
