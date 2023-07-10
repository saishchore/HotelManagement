package com.cg.hbm.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.hbm.controller.AdminControllerTest;
import com.cg.hbm.entites.User;

@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
public class UserTest 
{
	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(UserTest.class);
	
	//Testing getter methods for User class
	@Test
	public void getTest()
	{
		User user= new User(1,"ashwin","a@gmail.com","a123567","dfg","156457","lucknow");
		
		assertEquals(user.getUserName(),"ashwin");
		assertEquals(user.getEmail(),"a@gmail.com");
		assertEquals(user.getMobile(),"156457");
		assertEquals(user.getPassword(),"a123567");
		assertEquals(user.getRole(),"dfg");
		assertEquals(user.getAddress(),"lucknow");
		 
	}

	//Testing setter methods for User class
	@Test
	 public void setTest() 
	{		   
		 User user= new User();
		user.setUserName("ashwin");
		user.setEmail("a@gmail.com");
		user.setMobile("156457");
		user.setPassword("a123567");
		user.setRole("dfg");
		user.setAddress("lucknow");
			
		assertEquals(user.getUserName(),"ashwin");
		assertEquals(user.getEmail(),"a@gmail.com");
		assertEquals(user.getMobile(),"156457");
		assertEquals(user.getPassword(),"a123567");
		assertEquals(user.getRole(),"dfg");
		assertEquals(user.getAddress(),"lucknow");
	}
}
