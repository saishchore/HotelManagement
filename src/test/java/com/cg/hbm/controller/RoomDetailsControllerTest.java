package com.cg.hbm.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.exceptions.RoomDetailsNotFoundException;
import com.cg.hbm.pojo.MRoomDetails;
import com.cg.hbm.service.IBookingDetailsService;
import com.cg.hbm.service.IRoomDetailsService;
import com.cg.hbm.service.IRoomDetailsServiceImpl;


@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
public class RoomDetailsControllerTest 
{
		//Making proxy object of RoomDetail controller class and for that class we going to test
		@InjectMocks
		RoomDetailsController roomController;
		
		//Making proxy object of RoomDetail service
		@Mock
		IRoomDetailsServiceImpl roomService;
		
		//Logger Declare
		static final Logger LOGGER = LoggerFactory.getLogger(RoomDetailsControllerTest.class);
		
		//Testing ShowAllHotel Method From Controller
		@Test
		public void showAllRoomDetailsTest() 
		{
			//Setting up logger
			LOGGER.info("Called showAllRoomDetailsTest() method");
			MRoomDetails room=new MRoomDetails(1,2500.0,"450","AC",1);
			List<MRoomDetails> roomList = new ArrayList<MRoomDetails>();
			Mockito.when(roomService.showAllRoomDetails()).thenReturn(roomList);
			assertEquals(roomController.showAllRoomDetails().getStatusCode(),HttpStatus.OK);
		}
		
		//Testing UpdateRoomDetails Method From Controller
		@Test
		public void updateRoomDetailsTest() 
		{
			//Setting up logger
			LOGGER.info("Called updateRoomDetailsTest() method");
			MRoomDetails room = new MRoomDetails();
			assertEquals(roomController.updateRoomDetail(room).getStatusCode(),HttpStatus.OK);
		}

		//Testing addHotel Method From Controller
		@Test
		public void addRoomDetailsTest()
		{
			//Setting up logger
			LOGGER.info("Called addRoomDetailsTest() method");
			MRoomDetails room = new MRoomDetails();
			assertEquals(roomController.addRoomDetail(room).getStatusCode(),HttpStatus.OK);
		}
		
		//Testing ShowHotel Method From Controller
		@Test
		public void showRoomDetails()// throws HotelNotFoundException
		{
			//Setting up logger
			LOGGER.info("Called showRoomDetails() method");
			MRoomDetails r1 = new MRoomDetails();//(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com");
			r1.setRoomNo("450");
			r1.setRoomType("AC");
			r1.setRatePerDay(2500.0);
			r1.setAvailable(true);
			r1.setHotelId(1);
			Mockito.when(roomService.showRoomDetails(r1.getRoomId())).thenReturn(r1);
			assertEquals(roomController.showRoomDetails(1).getStatusCode(),HttpStatus.OK);
		}
		
		//Testing RemoveHotel Method From Controller
		@Test
		public void removeRoomDetailsTest()
		{
			//Setting up logger
			LOGGER.info("Called removeRoomDetailsTest() method");
			MRoomDetails room = new MRoomDetails();
			room.setRoomId(201);
			Mockito.when(roomService.removeRoomDetails(room.getRoomId())).thenReturn(room);
			assertEquals(roomController.removeRoom(201).getStatusCode(),HttpStatus.OK);
		}
}
