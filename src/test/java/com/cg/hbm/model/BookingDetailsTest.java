package com.cg.hbm.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.hbm.controller.AdminControllerTest;
import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.entites.Hotel;
import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.entites.User;

@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
public class BookingDetailsTest 
{
	//Logger Declare
		static final Logger LOGGER = LoggerFactory.getLogger(BookingDetailsTest.class);
	
	//Testing getter methods for Hotel class
	@Test
	public void getTest()
	{
		//Setting up logger
		LOGGER.info("Called getTest() method");
		
		User user=new User(1,"address","p@gmail.com","7894561235","Pavan@2","roleon","uname1");
		Hotel hotel=new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com");
		RoomDetails rd=new RoomDetails(1,"r5","ac",1500,true);
		LocalDate l = LocalDate.of(2021, 12, 15);
		LocalDate m = LocalDate.of(2021, 12, 30);
		BookingDetails mockb1=new BookingDetails();
		mockb1.setAmount(1000); mockb1.setBookedFrom(l); mockb1.setBookedTo(m); mockb1.setBookingId(2);mockb1.setNoOfAdults(4);mockb1.setNoOfChildren(3);
		mockb1.setHotel(hotel);mockb1.setRoomdetails(rd);mockb1.setUser(user);
		//BookingDetails bd=new BookingDetails(2,l,m,3,2,500.0,user,rd,hotel);
		assertEquals(mockb1.getAmount(),1000);
		assertEquals(mockb1.getBookedFrom(),l);
		assertEquals(mockb1.getBookedTo(),m);
		assertEquals(mockb1.getBookingId(),2);
		assertEquals(mockb1.getNoOfAdults(),4);
		assertEquals(mockb1.getNoOfChildren(),3);
		assertEquals(mockb1.getHotel(),hotel);
		assertEquals(mockb1.getRoomdetails(),rd);
		assertEquals(mockb1.getUser(),user);
	}
	
	//Testing setter methods for Hotel class
	@Test
	public void setTest()
	{
		//Setting up logger
		LOGGER.info("Called setTest() method");
		
		User user=new User(1,"address","p@gmail.com","7894561235","Pavan@2","roleon","uname1");
		Hotel hotel=new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com");
		RoomDetails rd=new RoomDetails(1,"r5","ac",1500,true);
		LocalDate l = LocalDate.of(2021, 12, 15);
		LocalDate m = LocalDate.of(2021, 12, 30);
		BookingDetails mockb1=new BookingDetails();
		mockb1.setAmount(1000); mockb1.setBookedFrom(l); 
		mockb1.setBookedTo(m); mockb1.setBookingId(2);
		mockb1.setNoOfAdults(4);mockb1.setNoOfChildren(3);
		mockb1.setHotel(hotel);mockb1.setRoomdetails(rd);
		mockb1.setUser(user);
		
		assertEquals(mockb1.getAmount(),1000);
		assertEquals(mockb1.getBookedFrom(),l);
		assertEquals(mockb1.getBookedTo(),m);
		assertEquals(mockb1.getBookingId(),2);
		assertEquals(mockb1.getNoOfAdults(),4);
		assertEquals(mockb1.getNoOfChildren(),3);
		assertEquals(mockb1.getHotel(),hotel);
		assertEquals(mockb1.getRoomdetails(),rd);
		assertEquals(mockb1.getUser(),user);
	}
}
