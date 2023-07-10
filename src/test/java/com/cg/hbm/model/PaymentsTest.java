package com.cg.hbm.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.hbm.controller.AdminControllerTest;
import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.entites.Hotel;
import com.cg.hbm.entites.Payments;
import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.entites.User;

@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
@ExtendWith(MockitoExtension.class)		//Extend Mockito Extension class here for mock testing
public class PaymentsTest 
{
		//Logger Declare
		static final Logger LOGGER = LoggerFactory.getLogger(PaymentsTest.class);
	
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
			Payments p=new Payments(1,1000,mockb1);
			assertEquals(p.getPaymentId(),1);
			assertEquals(p.getAmount(),1000);
			assertEquals(p.getBookingdetails(),mockb1);
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
			mockb1.setAmount(1000); mockb1.setBookedFrom(l); mockb1.setBookedTo(m); mockb1.setBookingId(2);mockb1.setNoOfAdults(4);mockb1.setNoOfChildren(3);
			mockb1.setHotel(hotel);mockb1.setRoomdetails(rd);mockb1.setUser(user);
					
			Payments p=new Payments(1,1000,mockb1);
			assertEquals(p.getPaymentId(),1);
			assertEquals(p.getAmount(),1000);
			assertEquals(p.getBookingdetails(),mockb1);
		}
}
