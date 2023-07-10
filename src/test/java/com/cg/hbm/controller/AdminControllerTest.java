package com.cg.hbm.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.hbm.controller.AdminController;
import com.cg.hbm.controller.UserController;
import com.cg.hbm.entites.Admin;
import com.cg.hbm.exceptions.UserNotFoundException;
import com.cg.hbm.pojo.MUser;
import com.cg.hbm.service.IAdminServiceImpl;


@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
public class AdminControllerTest 
{
	//Making proxy object of admin controller class and for that class we going to test
	@InjectMocks
	AdminController admincontroller;
	
	//Making proxy object of admin service
	@Mock
	IAdminServiceImpl adminservice;
	
	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(AdminControllerTest.class);
	
	//Testing ShowUser Method From Controller
	@Test
	public void signInControllerTest() throws UserNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called signInControllerTest() method");
		Admin admin = new Admin(1,"shravan","ssk123");
		Mockito.when(adminservice.signIn(admin.getAdminName(),admin.getPassword())).thenReturn(admin);
		assertEquals(admincontroller.showAdminByAdminnameAndPassword("shravan","ssk123").getStatusCode(),HttpStatus.OK);
	}
}
