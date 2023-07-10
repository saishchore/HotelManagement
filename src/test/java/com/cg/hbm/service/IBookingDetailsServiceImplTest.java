package com.cg.hbm.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
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
import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.entites.Hotel;
import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.entites.User;
import com.cg.hbm.exceptions.BookingDetailsNotFoundException;
import com.cg.hbm.exceptions.ListEmptyException;
import com.cg.hbm.pojo.MBooking;
import com.cg.hbm.repository.IBookingDetailsRepository;
import com.cg.hbm.repository.IHotelRepository;
import com.cg.hbm.repository.IPaymentRepository;
import com.cg.hbm.repository.IRoomDetailsRepository;
import com.cg.hbm.repository.IUserRepository;

@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
@ExtendWith(MockitoExtension.class)		//Extend Mockito Extension class here for mock testing
public class IBookingDetailsServiceImplTest 
{
	//Bean object of service layer
	@Autowired
	IBookingDetailsServiceImpl bookingService;
	
	//Making proxy object of booking repository
	@Mock
	IBookingDetailsRepository bookingRepository;
	
	//Making proxy object of user repository
	@Mock
	IUserRepository userRepository;
	
	//Making proxy object of hotel repository
	@Mock
	IHotelRepository hotelRepository;
	
	//Making proxy object of payment repository
	@Mock
	IPaymentRepository paymentRepository;
	
	//Making proxy object of room repository
	@Mock
	IRoomDetailsRepository roomRepo;
	
	//Making proxy object of admin service class and for that class we are going to test
	@InjectMocks
	IBookingDetailsServiceImpl bookingImpl;
	
	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(IBookingDetailsServiceImplTest.class);
	
	//Testing showAllBookingDetailsTest Method From Service level Test
	@Test
	public void showAllBookingDetailsTest() throws ListEmptyException
	{
		//Setting up logger
		LOGGER.info("Called showAllBookingDetailsTest() method");
		
		User user=new User(1,"address","p@gmail.com","7894561235","Pavan@2","roleon","uname1");
		Hotel hotel=new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com");
		RoomDetails rd=new RoomDetails(1,"r5","ac",1500,true);
		LocalDate l = LocalDate.of(2021, 12, 15);
		LocalDate m = LocalDate.of(2021, 12, 30);
		List<BookingDetails> mockBooking = new ArrayList<>(); 
		BookingDetails mockb1=new BookingDetails();
		
		mockb1.setAmount(1000); mockb1.setBookedFrom(l); mockb1.setBookedTo(m); mockb1.setBookingId(2);mockb1.setNoOfAdults(4);mockb1.setNoOfChildren(3);
		mockb1.setHotel(hotel);mockb1.setRoomdetails(rd);mockb1.setUser(user);
		mockBooking.add(mockb1);

		Mockito.when(bookingRepository.findAll()).thenReturn(mockBooking);
		List<MBooking> realBooking = bookingImpl.showAllBookingDetails();
		assertEquals(4, realBooking.get(0).getNoOfAdults());
		assertEquals(1,realBooking.get(0).getHotelId());
	}
	
	//Testing showAllBookingDetailsTestFail Method From Service level Test
	@Test
	public void showAllBookingDetailsTestFail() throws ListEmptyException
	{
		//Setting up logger
		LOGGER.info("Called showAllBookingDetailsTestFail() method");
		
		User user=new User(1,"address","p@gmail.com","7894561235","Pavan@2","roleon","uname1");
		Hotel hotel=new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com");
		RoomDetails rd=new RoomDetails(1,"r5","ac",1500,true);
		LocalDate l = LocalDate.of(2021, 12, 15);
		LocalDate m = LocalDate.of(2021, 12, 30);
		List<BookingDetails> mockBooking = new ArrayList<>(); 
		BookingDetails mockb1=new BookingDetails();
		mockb1.setAmount(1000); mockb1.setBookedFrom(l); mockb1.setBookedTo(m); mockb1.setBookingId(2);mockb1.setNoOfAdults(4);mockb1.setNoOfChildren(3);
		mockb1.setHotel(hotel);mockb1.setRoomdetails(rd);mockb1.setUser(user);
		mockBooking.add(mockb1);

		Mockito.when(bookingRepository.findAll()).thenReturn(mockBooking);
		List<MBooking> realBooking = bookingImpl.showAllBookingDetails();
		assertNotEquals(3, realBooking.get(0).getNoOfAdults());
		assertNotEquals(4,realBooking.get(0).getHotelId());

	}
	
	//Testing showBookingDetailsByIdTest Method From Service level Test
	@Test
	public void showBookingDetailsByIdTest() throws BookingDetailsNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called showBookingDetailsByIdTest() method");
		
		User user=new User(1,"address","p@gmail.com","7894561235","Pavan@2","roleon","uname1");
		Hotel hotel=new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com");
		RoomDetails rd=new RoomDetails(1,"r5","ac",1500,true);
		LocalDate l = LocalDate.of(2021, 12, 15);
		LocalDate m = LocalDate.of(2021, 12, 30);
		List<BookingDetails> mockBooking = new ArrayList<>(); 
		BookingDetails mockb1=new BookingDetails();
		mockb1.setAmount(1000); mockb1.setBookedFrom(l); mockb1.setBookedTo(m); mockb1.setBookingId(2);mockb1.setNoOfAdults(4);mockb1.setNoOfChildren(3);
		mockb1.setHotel(hotel);mockb1.setRoomdetails(rd);mockb1.setUser(user);
		mockBooking.add(mockb1);

		bookingRepository.saveAll(mockBooking);
		Mockito.when(bookingRepository.findById(2)).thenReturn(Optional.of(mockb1));
		MBooking realBooking = bookingImpl.showBookingDetails(2);
		assertEquals(4, realBooking.getNoOfAdults());
		assertEquals(1,realBooking.getHotelId());
	}
	
	//Testing showBookingDetailsByIdTestFail Method From Service level Test
	@Test
	public void showBookingDetailsByIdTestFail() throws BookingDetailsNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called showBookingDetailsByIdTestFail() method");
		
		User user=new User(1,"address","p@gmail.com","7894561235","Pavan@2","roleon","uname1");
		Hotel hotel=new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com");
		RoomDetails rd=new RoomDetails(1,"r5","ac",1500,true);
		LocalDate l = LocalDate.of(2021, 12, 15);
		LocalDate m = LocalDate.of(2021, 12, 30);
		List<BookingDetails> mockBooking = new ArrayList<>(); 
		BookingDetails mockb1=new BookingDetails();
		mockb1.setAmount(1000); mockb1.setBookedFrom(l); mockb1.setBookedTo(m); mockb1.setBookingId(2);mockb1.setNoOfAdults(4);mockb1.setNoOfChildren(3);
		mockb1.setHotel(hotel);mockb1.setRoomdetails(rd);mockb1.setUser(user);
		mockBooking.add(mockb1);

		bookingRepository.saveAll(mockBooking);
		Mockito.when(bookingRepository.findById(2)).thenReturn(Optional.of(mockb1));
		MBooking realBooking = bookingImpl.showBookingDetails(2);
		assertNotEquals(5, realBooking.getNoOfAdults());
		assertNotEquals(5,realBooking.getHotelId());
	}
	
	
	//Functional Testing
	
	//Testing addBookingDetailsUnitTest Method From Service level Test
	@Test
	public void addBookingDetailsUnitTest()
	{
		//Setting up logger
		LOGGER.info("Called addBookingDetailsUnitTest() method");
		
		MBooking mBooking=new MBooking();
		LocalDate l = LocalDate.of(2021, 12, 15);
		LocalDate m = LocalDate.of(2021, 12, 30);
		mBooking.setBookedFrom(l);
		mBooking.setBookedTo(m);
		mBooking.setHotelId(3);
		mBooking.setNoOfAdults(4);
		mBooking.setNoOfChildren(4);
		mBooking.setRoomId(4);
		mBooking.setTotalamount(1000);
		mBooking=bookingService.addBookingDetails(mBooking,4);
		assertNotNull(mBooking,"Booking details found");
		assertEquals(4,mBooking.getNoOfAdults(),"adults count is correct");
		
	}
	
	//Testing updateBookingDetailsUnitTest Method From Service level Test
	@Test
	public void updateBookingDetailsUnitTest()
	{
		//Setting up logger
		LOGGER.info("Called updateBookingDetailsUnitTest() method");
		
		MBooking mBooking=new MBooking();
		LocalDate l = LocalDate.of(2021, 12, 15);
		LocalDate m = LocalDate.of(2021, 12, 30);
		mBooking.setBookedFrom(l);
		mBooking.setBookedTo(m);
		mBooking.setHotelId(3);
		mBooking.setNoOfAdults(5);
		mBooking.setNoOfChildren(4);
		mBooking.setRoomId(4);
		mBooking.setTotalamount(2000);
		mBooking.setBookingId(4);

		mBooking=bookingService.updateBookingDetails(mBooking,4);
		assertNotNull(mBooking,"Booking details found");
		assertEquals(5,mBooking.getNoOfAdults(),"adults count is correct");
		
	}
	
	//Testing showAllBookingDetailsUnitTest Method From Service level Test
	@Test
	public void showAllBookingDetailsUnitTest() throws BookingDetailsNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called showAllBookingDetailsUnitTest() method");
		
		List<MBooking> mBooking=bookingService.showAllBookingDetails();
		assertNotNull(mBooking,"Booking details found");
		assertEquals(5,mBooking.get(0).getNoOfAdults());
		
	}
	
	//Testing showBookingDetailsUnitTest Method From Service level Test
	@Test
	public void showBookingDetailsUnitTest() throws BookingDetailsNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called showBookingDetailsUnitTest() method");
		
		MBooking mBooking=bookingService.showBookingDetails(4);
		assertNotNull(mBooking,"Booking details found");
		assertEquals(5,mBooking.getNoOfAdults());
	}
	
	//Testing removeBookingDetailsUnitTest Method From Service level Test
	@Test
	public void removeBookingDetailsUnitTest()
	{
		//Setting up logger
		LOGGER.info("Called removeBookingDetailsUnitTest() method");
		
		MBooking mBooking=new MBooking();
		mBooking=bookingService.removeBookingDetails(4);
		assertNotNull(mBooking);
		assertEquals(4,mBooking.getBookingId());
		
	}
}
