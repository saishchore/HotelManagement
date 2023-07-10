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

import com.cg.hbm.exceptions.HotelListEmptyException;
import com.cg.hbm.exceptions.HotelNotFoundException;
import com.cg.hbm.pojo.MHotel;
import com.cg.hbm.service.IHotelServiceImpl;

@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
public class HotelControllerTest 
{
	//Making proxy object of hotel controller class and for that class we going to test
	@InjectMocks
	HotelController hotelController;
	
	//Making proxy object of hotel service
	@Mock
	IHotelServiceImpl hotelService;
	
	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(HotelControllerTest.class);
	
	//Testing ShowAllHotel Method From Controller
	@Test
	public void showAllHotelsTest() throws HotelListEmptyException
	{
		//Setting up logger
		LOGGER.info("Called showAllHotelsTest() method");
		MHotel hotel = new MHotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com");
		List<MHotel> hotelList = new ArrayList<MHotel>();
		hotelList.add(hotel);
		Mockito.when(hotelService.showAllHotels()).thenReturn(hotelList);
		assertEquals(hotelController.showAllHotels().getStatusCode(),HttpStatus.OK);
	}
	
	//Testing UpdateHotel Method From Controller
	@Test
	public void updateHotelTest() throws HotelNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called updateHotelTest() method");
		MHotel hotel = new MHotel();
		assertEquals(hotelController.updateHotel(hotel).getStatusCode(),HttpStatus.OK);
	}
	
	//Testing addHotel Method From Controller
	@Test
	public void addHotelTest() throws HotelNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called addHotelTest() method");
		MHotel hotel = new MHotel();
		assertEquals(hotelController.addHotel(hotel).getStatusCode(),HttpStatus.OK);
	}
	
	//Testing ShowHotel Method From Controller
	@Test
	public void showHotel() throws HotelNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called showHotel() method");
		MHotel hotel = new MHotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com");
		Mockito.when(hotelService.showHotel(hotel.getHotelId())).thenReturn(hotel);
		assertEquals(hotelController.showHotel(1).getStatusCode(),HttpStatus.OK);
	}
	
	//Testing RemoveHotel Method From Controller
	@Test
	public void removeHotelTest() throws HotelNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called removeHotelTest() method");
		MHotel hotel = new MHotel();
		hotel.setHotelId(11);
		Mockito.when(hotelService.removeHotel(hotel.getHotelId())).thenReturn(hotel);
		assertEquals(hotelController.removeHotel(11).getStatusCode(),HttpStatus.OK);
	}
	
}
