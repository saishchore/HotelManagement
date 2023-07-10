package com.cg.hbm.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.hbm.controller.AdminControllerTest;
import com.cg.hbm.entites.Admin;
import com.cg.hbm.exceptions.AdminNotFoundException;
import com.cg.hbm.repository.IAdminRepository;


@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
@ExtendWith(MockitoExtension.class)		//Extend Mockito Extension class here for mock testing
public class IAdminServiceImplTest 
{
	//Making proxy object of admin repository
	@Mock
	IAdminRepository adminRepositorymock;
	
	//Making proxy object of admin service class and for that class we are going to test
	@InjectMocks
	IAdminServiceImpl adminImpl;
	
	//Bean object of service layer
	@Autowired
	IAdminServiceImpl adminService;
	
	//Bean object of dao layer
	@Autowired
	IAdminRepository adminRepository;
	
	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(AdminControllerTest.class);
	
	//Testing signInUnitTest Method From Service level Test
	@Test
	public void signInUnitTest() throws AdminNotFoundException 
	{
		//Setting up logger
		LOGGER.info("Called signInUnitTest() method");
		Admin admin = adminService.signIn("saish","Saish@123");
		assertNotNull(admin,"admin found");
		assertEquals("saish", admin.getAdminName(),"admin name is perfect");
	}
}
