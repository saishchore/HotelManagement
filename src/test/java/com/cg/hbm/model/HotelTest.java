package com.cg.hbm.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.hbm.controller.AdminControllerTest;
import com.cg.hbm.entites.Hotel;

@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
public class HotelTest 
{
	//Logger Declare
		static final Logger LOGGER = LoggerFactory.getLogger(HotelTest.class);
	
	//Testing getter methods for Hotel class
	@Test
	public void getTest()
	{
		//Setting up logger
		LOGGER.info("Called getTest() method");
		
		Hotel hotel = new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","7894561230","8794561230","www.RadissonBlu.com");
		assertEquals(hotel.getCity(),"Pune");
		assertEquals(hotel.getHotelName(),"Radisson Blu");
		assertEquals(hotel.getAddress(),"Kharadi");
		assertEquals(hotel.getDescription(),"5 Star");
		assertEquals(hotel.getAvgRatePerDay(),5000);
		assertEquals(hotel.getEmail(),"radissonblu@gmail.com");
		assertEquals(hotel.getPhone1(),"7894561230");
		assertEquals(hotel.getPhone2(),"8794561230");
		assertEquals(hotel.getWebsite(),"www.RadissonBlu.com");
	}
	
	//Testing setter methods for Hotel class
	@Test
	public void setTest()
	{
		//Setting up logger
		LOGGER.info("Called setTest() method");
		
		Hotel hotel = new Hotel();
		
		hotel.setCity("Pune");
		hotel.setHotelName("Radisson Blu");
		hotel.setAddress("Kharadi");
		hotel.setDescription("5 Star");
		hotel.setAvgRatePerDay(5000);
		hotel.setEmail("radissonblu@gmail.com");
		hotel.setPhone1("7894561230");
		hotel.setPhone2("8794561230");
		hotel.setWebsite("www.RadissonBlu.com");
		
		assertEquals(hotel.getCity(),"Pune");
		assertEquals(hotel.getHotelName(),"Radisson Blu");
		assertEquals(hotel.getAddress(),"Kharadi");
		assertEquals(hotel.getDescription(),"5 Star");
		assertEquals(hotel.getAvgRatePerDay(),5000);
		assertEquals(hotel.getEmail(),"radissonblu@gmail.com");
		assertEquals(hotel.getPhone1(),"7894561230");
		assertEquals(hotel.getPhone2(),"8794561230");
		assertEquals(hotel.getWebsite(),"www.RadissonBlu.com");
	}
}
