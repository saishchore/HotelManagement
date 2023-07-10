package com.cg.hbm.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity														//Auto generate Payments table with fields in database
@Table(name="Users")										//Annotation is used to provide named we mention in database apart from Entity
public class User {
	@Id														//Annotation used to make or mark that variable as primary key
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")			//Generate Auto value for id using sequence
    @SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "USER_SEQ")
	private int userId;
	private String userName;
	private String email;
	private String password;
	private String role;
	private String mobile;
	private String address;
	
	@OneToMany(mappedBy = "user")							//Providing asociation as OneToMany between bookingdetails and user
	@Fetch(FetchMode.JOIN)
	private List<BookingDetails> bookdetails;
	
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
	
	public List<BookingDetails> getBookdetails() {
		return bookdetails;
	}
	public void setBookdetails(List<BookingDetails> bookdetails) {
		this.bookdetails = bookdetails;
	}
	
	//Parameterized Constructor
	public User(@NotNull int userId,
			@NotNull(message = "Please Enter Name") @Size(min = 5, max = 9, message = "Enter UserName in between 5 and 9") String userName,
			@NotEmpty(message = "Please Enter Name") @Email(regexp = "^[A-Za-z] {1}[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter Email in proper format.") String email,
			@NotEmpty(message = "Please Enter Password") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{6,20}$", message = "Enter password in between 6 and 10") String password,
			@NotEmpty(message = "Please Enter Role") @Size(min = 3, max = 12, message = "Enter Role in between 3 and 12") String role,
			@NotEmpty(message = "Please Enter Mobile No.") @Size(min = 5, max = 10, message = "Enter mobile no. in between 5 and 10 ") @Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "Invalid Mobile No.") String mobile,
			@NotEmpty(message = "Please Enter Address") @Size(min = 5, max = 25, message = "Enter address in between 5 and 25") String address,
			List<BookingDetails> bookdetails) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.address = address;
		this.bookdetails = bookdetails;
	}
	
	//Default Constructor
	public User() {
		super();
	}
	
	//Override toString method for all fields
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", mobile=" + mobile + ", address=" + address + ", bookdetails=" + bookdetails
				+ "]";
	}
	
	//Parameterized Constructor
	public User(int userId, String userName, String email, String password, String role, String mobile,
			String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.address = address;
	}
	
}