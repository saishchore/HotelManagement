package com.cg.hbm.service;

import static org.junit.Assert.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.hbm.controller.AdminController;
import com.cg.hbm.entites.User;
import com.cg.hbm.exceptions.UserListEmptyException;
import com.cg.hbm.exceptions.UserNotFoundException;
import com.cg.hbm.pojo.MUser;
import com.cg.hbm.repository.IUserRepository;


@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
@ExtendWith(MockitoExtension.class)		//Extend Mockito Extension class here for mock testing
public class IUserServiceImplTest 
{
	//Making proxy object of user repository
	@Mock
	IUserRepository iUserRepository;
	
	//Making proxy object of payment service class and for that class we are going to test
	@InjectMocks
	public IUserServiceImpl userImpl;
	
	//Bean object of service layer
	@Autowired
	IUserServiceImpl iUserService;

	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(IUserServiceImplTest.class);
	
	//Testing showAllUserTest Method From Service level Test
	@Test
	public void showAllUserTest() throws UserListEmptyException
	{
		//Setting up logger
		LOGGER.info("Called showAllUserTest() method");
		List<User> mockUser = new ArrayList<>();
		mockUser.add(new User(1,"ashwin","a@gmail.com","156457","a123567","dfg","lucknow"));
		mockUser.add(new User(2,"ravichandran","b@gmail.com","123459","b123456","ghj","dehradun"));
		mockUser.add(new User(3,"thalapathy","c@gmail.com","123850","b123890","djk","hyderabad"));
		Mockito.when(iUserRepository.findAll()).thenReturn(mockUser);
		List<MUser> realUser = userImpl.showAllUsers();
		assertEquals("c@gmail.com", realUser.get(2).getEmail());
	}
	
	//Testing showAllUserTestFail Method From Service level Test
	@Test
	public void showAllUserTestFail() throws UserListEmptyException
	{
		//Setting up logger
		LOGGER.info("Called showAllUserTestFail() method");
		List<User> mockUser = new ArrayList<>();
		mockUser.add(new User(1,"ashwin","a@gmail.com","156457","a123567","dfg","lucknow"));
		mockUser.add(new User(2,"ravichandran","b@gmail.com","123459","b123456","ghj","dehradun"));
		mockUser.add(new User(3,"thalapathy","c@gmail.com","123850","b123890","djk","hyderabad"));
		Mockito.when(iUserRepository.findAll()).thenReturn(mockUser);
		List<MUser> realUser = userImpl.showAllUsers();
		assertNotEquals("d@gmail.com", realUser.get(0).getEmail());
	}
	
	//Testing showUserByIdTest Method From Service level Test
	@Test
	public void showUserByIdTest() throws UserNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called showUserByIdTest() method");
		List<User> mockUser = new ArrayList<>();
		
		iUserRepository.saveAll(mockUser);
		Mockito.when(iUserRepository.findById(1)).thenReturn(Optional.of(new User(1,"ashwin","a@gmail.com","156457","a123567","dfg","hyderabad")));
		MUser realUser = userImpl.showUserById(1);
		assertEquals("ashwin", realUser.getUserName());
	}
	
	//Testing showUserByIdTestFail Method From Service level Test
	@Test
 	public void showUserByIdTestFail() throws UserNotFoundException
 	{
		//Setting up logger
		LOGGER.info("Called showUserByIdTestFail() method");
 		List<User> mockUser = new ArrayList<>();
 		
 		iUserRepository.saveAll(mockUser);
 		Mockito.when(iUserRepository.findById(1)).thenReturn(Optional.of(new User(1,"ashwin","a@gmail.com","156457","a123567","dfg","hyderabad")));
 		MUser realUser = userImpl.showUserById(1);
 		assertNotEquals("shravan", realUser.getUserName());
 	}
  
  
	//Functional Testing
    
    //Unit testing for adding a User
	@Test
	public void addUserUnitTest() throws UserNotFoundException 
	{
		//Setting up logger
		LOGGER.info("Called addUserUnitTest() method");
		MUser user = new MUser();
		user.setUserId(3);
		user.setUserName("shravan");
		user.setEmail("ssk@gmail.com");
		user.setMobile("9523647");
		user.setPassword("ssk123");
		user.setRole("analyst");
		user.setAddress("hyderabad");
		user = iUserService.addUser(user);
		assertNotNull(user,"user found");
		assertEquals("hyderabad", user.getAddress(),"Address is perfect");
     }

	//Unit Testing for showing User
  	@Test
	public void showUserUnitTest() throws UserNotFoundException
	{
  		//Setting up logger
  		LOGGER.info("Called showUserUnitTest() method");
		MUser user = iUserService.showUserById(5);
		assertNotNull(user,"User found");
		assertEquals("hyderabad", user.getAddress(),"Address is perfect");
	}
  
  	//Unit Testing for removing User
   	@Test
	public void removeUserUnitTest() throws UserNotFoundException
	{
   		//Setting up logger
   		LOGGER.info("Called removeUserUnitTest() method");
		MUser user=new MUser();
		user=iUserService.removeUser(5);
		
		assertNotNull(user);
		assertEquals(5,user.getUserId());
		
	}
  
   	//Unit Testing for showing all users
   	@Test
	public void showAllUserUnitTest() throws UserNotFoundException
	{
   		//Setting up logger
   		LOGGER.info("Called showAllUserUnitTest() method");
		List<MUser> user = iUserService.showAllUsers();
		assertNotNull(user,"Hotel found");
		assertEquals("hyderabad", user.get(3).getAddress(),"address is perfect");
	}
  
   	//Unit Testing for updating User
   	@Test
	public void updateUserUnitTest()
	{
   		//Setting up logger
   		LOGGER.info("Called updateUserUnitTest() method");
		MUser user=new MUser();
		user.setUserId(5);
		user.setUserName("ravan");
		user.setEmail("srk@gmail.com");
		user.setMobile("95563647");
		user.setPassword("srk123");
		user.setRole("analyst");
		user.setAddress("hyderabad");
		user = iUserService.addUser(user);	
		assertNotNull(user,"user details found");
		assertEquals("ravan",user.getUserName(),"username is correct");
		
	}
}
