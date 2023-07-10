package com.cg.hbm.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.hbm.controller.AdminControllerTest;
import com.cg.hbm.entites.Admin;
import com.cg.hbm.entites.User;

@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
public class AdminTest 
{
	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(AdminTest.class);
	
	//Testing getter methods for admin class
	@Test
	public void getTest()
	{
		//Setting up logger
		LOGGER.info("Called getTest() method");
		
		Admin admin= new Admin(1,"shravan","ssk123");
		
		assertEquals(admin.getAdminName(),"shravan");
		assertEquals(admin.getAdminId(),1);
		assertEquals(admin.getPassword(),"ssk123");
	}

	//Testing setter methods for admin class
	@Test
	 public void setTest() 
	{
		//Setting up logger
		LOGGER.info("Called setTest() method");
		
		Admin admin= new Admin();
		admin.setAdminName("shravan");
		admin.setAdminId(1);
		admin.setPassword("ssk123");
			
		assertEquals(admin.getAdminName(),"shravan");
		assertEquals(admin.getAdminId(),1);
		assertEquals(admin.getPassword(),"ssk123");
 
	 }
}
