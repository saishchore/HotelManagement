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

import com.cg.hbm.controller.UserController;
import com.cg.hbm.exceptions.UserListEmptyException;
import com.cg.hbm.exceptions.UserNotFoundException;
import com.cg.hbm.pojo.MUser;
import com.cg.hbm.service.IUserServiceImpl;

@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class) //Using JUnit4 for testing
public class UserControllerTest 
{
		//Making proxy object of user controller class and for that class we going to test
		@InjectMocks
		UserController usercontroller;
		
		//Making proxy object of user service
		@Mock
		IUserServiceImpl userservice;
		
		//Logger Declare
		static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);
		
		//Testing ShowAllUser Method From Controller
		@Test
		public void showAllUsersTest() throws UserListEmptyException
		{
			//Setting up logger
			LOGGER.info("Called showAllUsersTest() method");
			MUser user = new MUser(1,"ashwin","a@gmail.com","a123567","dfg","156457","lucknow");
			List<MUser> userList = new ArrayList<MUser>();
			userList.add(user);
			Mockito.when(userservice.showAllUsers()).thenReturn(userList);
			assertEquals(usercontroller.showAllUsers().getStatusCode(),HttpStatus.OK);
		}
		

		//Testing UpdateUser Method From Controller
		@Test
		public void updateUserTest() throws UserNotFoundException
		{
			//Setting up logger
			LOGGER.info("Called updateUserTest() method");
			MUser user = new MUser();
			assertEquals(usercontroller.updateUser(user).getStatusCode(),HttpStatus.OK);
		}
		
		//Testing addUser Method From Controller
		@Test
		public void addUserTest() throws UserNotFoundException
		{
			//Setting up logger
			LOGGER.info("Called addUserTest() method");
			MUser user = new MUser();
			assertEquals(usercontroller.addUser(user).getStatusCode(),HttpStatus.OK);
		}

		//Testing ShowUser Method From Controller
		@Test
		public void showUserTest() throws UserNotFoundException
		{
			//Setting up logger
			LOGGER.info("Called showUserTest() method");
			MUser user = new MUser(1,"ashwin","a@gmail.com","a123567","dfg","156457","lucknow");
			Mockito.when(userservice.showUserById(user.getUserId())).thenReturn(user);
			assertEquals(usercontroller.showUserById(1).getStatusCode(),HttpStatus.OK);
		}
		
		//Testing RemoveUser Method From Controller
		@Test
		public void removeUserTest() throws UserNotFoundException
		{
			//Setting up logger
			LOGGER.info("Called removeUserTest() method");
			MUser user = new MUser();
			user.setUserId(11);
			Mockito.when(userservice.removeUser(user.getUserId())).thenReturn(user);
			assertEquals(usercontroller.removeUser(11).getStatusCode(),HttpStatus.OK);
		}
}
