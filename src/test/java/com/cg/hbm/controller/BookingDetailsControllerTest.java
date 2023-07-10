package com.cg.hbm.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
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

import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.exceptions.BookingDetailsNotFoundException;
import com.cg.hbm.exceptions.HotelListEmptyException;
import com.cg.hbm.exceptions.HotelNotFoundException;
import com.cg.hbm.exceptions.ListEmptyException;
import com.cg.hbm.pojo.MBooking;
import com.cg.hbm.pojo.MHotel;
import com.cg.hbm.service.IBookingDetailsServiceImpl;
import com.cg.hbm.service.IHotelServiceImpl;

@SpringBootTest				//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)		//Using JUnit4 for testing
public class BookingDetailsControllerTest 
{
	//Making proxy object of hotel controller class and for that class we going to test
	@InjectMocks
	BookingController bookingController;
	
	//Making proxy object of hotel service
	@Mock
	IBookingDetailsServiceImpl bookingService;
	
	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(BookingDetailsControllerTest.class);
	
	//Testing ShowAllBookingDetails Method From Controller
	@Test
	public void showAllBookingDetailsTest() throws ListEmptyException
	{
		//Setting up logger
		LOGGER.info("Called showAllBookingDetailsTest() method");
		LocalDate l = LocalDate.of(2021, 12, 15);
		LocalDate m = LocalDate.of(2021, 12, 30);
		MBooking mb=new MBooking(1, l, m, 2, 2, 1000.0, 2, 1);
		List<MBooking> bookingList=new ArrayList<MBooking>();
		bookingList.add(mb);
		Mockito.when(bookingService.showAllBookingDetails()).thenReturn(bookingList);
		assertEquals(bookingController.showAllBookingDetails().getStatusCode(),HttpStatus.OK);
		
	}
	
	//Testing updateBookingDetails Method From Controller
	@Test
	public void updateBookingDetailsTest() throws BookingDetailsNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called updateBookingDetailsTest() method");
		MBooking mb=new MBooking();
		assertEquals(bookingController.updateBookingDetails(mb,20).getStatusCode(),HttpStatus.OK);
		
	}
	
	//Testing addBookingDetails Method From Controller
	@Test
	public void addBookingDetailsTest() throws BookingDetailsNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called addBookingDetailsTest() method");
		MBooking mb=new MBooking();
		assertEquals(bookingController.addBookingDetails(mb,40).getStatusCode(),HttpStatus.OK);
		
	}
	
	//Testing showBookingDetailsById Method From Controller
	@Test
	public void showBookingDetailsByIdTest() throws BookingDetailsNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called showBookingDetailsByIdTest() method");
		LocalDate l = LocalDate.of(2021, 12, 15);
		LocalDate m = LocalDate.of(2021, 12, 30);
		MBooking mb=new MBooking(1, l, m, 2, 2, 1000.0, 2, 1);
		Mockito.when(bookingService.showBookingDetails(mb.getBookingId())).thenReturn(mb);
		assertEquals(bookingController.showBookingDetails(1).getStatusCode(),HttpStatus.OK);
	
	}
	
	//Testing removeBookingDetails Method From Controller
	@Test
	public void removeBookingDetailsTest() throws BookingDetailsNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called removeBookingDetailsTest() method");
		MBooking mb=new MBooking();
		mb.setBookingId(10);
		Mockito.when(bookingService.removeBookingDetails(mb.getBookingId())).thenReturn(mb);
		assertEquals(bookingController.removeBookingDetails(10).getStatusCode(),HttpStatus.OK);
		
	}
	
}
