package com.cg.hbm.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity							//Auto generate Admin table with fields in database
public class Admin 
{
	@Id							//Annotation used to make or mark that variable as primary key
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMIN_SEQ")
    @SequenceGenerator(sequenceName = "admin_seq", allocationSize = 1, name = "ADMIN_SEQ")
	@Min(1)																			//Validation part
	private int adminId;
	
	@NotEmpty(message="admin name cannot be empty")									//Validation part
	@Size(min = 3, max = 20, message = "admin name must be 3 to 20 letters")		
	private String adminName;
	
	@NotEmpty(message = "Please Enter Password")									//Validation part
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{6,20}$", message = "Enter password size in between 6 and 10")
	private String password;
	
	
	//Getters and Setters
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Override toString method for all fields
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", password=" + password + "]";
	}
	
	//Default Constructor
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Parameterized Constructor
	public Admin(@NotNull(message = "enter admin Id") @Min(1) int adminId,
			@NotEmpty(message = "admin name cannot be empty") @Size(min = 3, max = 20, message = "admin name must be 3 to 20 letters") String adminName,
			@NotEmpty(message = "Please Enter Password") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{6,20}$", message = "Enter password size in between 6 and 10") String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
	}
	
	
}