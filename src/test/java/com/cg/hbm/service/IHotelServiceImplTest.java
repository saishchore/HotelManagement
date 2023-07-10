package com.cg.hbm.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import com.cg.hbm.entites.Hotel;
import com.cg.hbm.exceptions.HotelListEmptyException;
import com.cg.hbm.exceptions.HotelNotFoundException;
import com.cg.hbm.pojo.MHotel;
import com.cg.hbm.repository.IHotelRepository;

@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
@ExtendWith(MockitoExtension.class)		//Extend Mockito Extension class here for mock testing
public class IHotelServiceImplTest 
{
	//Making proxy object of hotel repository
	@Mock
	IHotelRepository hotelRepository;
	
	//Making proxy object of hotel service class and for that class we are going to test
	@InjectMocks
	IHotelServiceImpl hotelImpl;
	
	//Bean object of service layer
	@Autowired
	IHotelServiceImpl hotelService;
	
	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(IHotelServiceImplTest.class);
	
	//Testing showAllHotelsTest Method From Service level Test
	@Test
	public void showAllHotelsTest() throws HotelListEmptyException
	{
		//Setting up logger
		LOGGER.info("Called showAllHotelsTest() method");
		
		List<Hotel> mockHotel = new ArrayList<>();
		mockHotel.add(new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com"));
		mockHotel.add(new Hotel(2,"Pune","Novotel","Baner","4.5 Star",4000,"novotel@gmail.com","753159","852123","www.Novotel.com"));
		mockHotel.add(new Hotel(3,"Pune","Royal Orchid","Hinjewadi","5 Star",4500,"royalorchid@gmail.com","12345","56789","www.RoyalOrchid.com"));
		Mockito.when(hotelRepository.findAll()).thenReturn(mockHotel);
		List<MHotel> realHotel = hotelImpl.showAllHotels();
		assertEquals("Pune", realHotel.get(0).getCity());
	}
	
	//Testing showAllHotelsTestFail Method From Service level Test
	@Test
	public void showAllHotelsTestFail() throws HotelListEmptyException
	{
		//Setting up logger
		LOGGER.info("Called showAllHotelsTestFail() method");
		
		List<Hotel> mockHotel = new ArrayList<>();
		mockHotel.add(new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com"));
		mockHotel.add(new Hotel(2,"Pune","Novotel","Baner","4.5 Star",4000,"novotel@gmail.com","753159","852123","www.Novotel.com"));
		mockHotel.add(new Hotel(3,"Pune","Royal Orchid","Hinjewadi","5 Star",4500,"royalorchid@gmail.com","12345","56789","www.RoyalOrchid.com"));
		Mockito.when(hotelRepository.findAll()).thenReturn(mockHotel);
		List<MHotel> realHotel = hotelImpl.showAllHotels();
		assertNotEquals("Pune1", realHotel.get(0).getCity());
	}
	
	//Testing showHotelTest Method From Service level Test
	@Test
	public void showHotelTest() throws HotelNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called showHotelTest() method");
		
		List<Hotel> mockHotel = new ArrayList<>();
		mockHotel.add(new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com"));
		mockHotel.add(new Hotel(2,"Pune","Novotel","Baner","4.5 Star",4000,"novotel@gmail.com","753159","852123","www.Novotel.com"));
		mockHotel.add(new Hotel(3,"Pune","Royal Orchid","Hinjewadi","5 Star",4500,"royalorchid@gmail.com","12345","56789","www.RoyalOrchid.com"));
		hotelRepository.saveAll(mockHotel);
		Mockito.when(hotelRepository.findById(1)).thenReturn(Optional.of(new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com")));
		MHotel realHotel = hotelImpl.showHotel(1);
		assertNotEquals("Royal Orchid", realHotel.getHotelName());
	}
	
	//Testing showHotelTestFail Method From Service level Test
	@Test
	public void showHotelTestFail() throws HotelNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called showHotelTestFail() method");
		
		List<Hotel> mockHotel = new ArrayList<>();
		mockHotel.add(new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com"));
		mockHotel.add(new Hotel(2,"Pune","Novotel","Baner","4.5 Star",4000,"novotel@gmail.com","753159","852123","www.Novotel.com"));
		mockHotel.add(new Hotel(3,"Pune","Royal Orchid","Hinjewadi","5 Star",4500,"royalorchid@gmail.com","12345","56789","www.RoyalOrchid.com"));
		hotelRepository.saveAll(mockHotel);
		Mockito.when(hotelRepository.findById(1)).thenReturn(Optional.of(new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com")));
		MHotel realHotel = hotelImpl.showHotel(1);
		assertNotEquals("Novotel", realHotel.getHotelName());
	}
	
	
	//Functional Testing
	
	//ShowHotel Method Functional Testing
	@Test
	public void showHotelUnitTest() throws HotelNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called showHotelUnitTest() method");
		
		MHotel hotel = hotelService.showHotel(1);
		assertNotNull(hotel,"Hotel found");
		assertEquals("Kharadi", hotel.getAddress(),"Address is perfect");
	}
	
	//ShowAllHotel Method Functional Testing
	@Test
	public void showAllHotelUnitTest() throws HotelNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called showAllHotelUnitTest() method");
		
		List<MHotel> hotel = hotelService.showAllHotels();
		assertNotNull(hotel,"Hotel found");
		assertEquals("Kharadi", hotel.get(1).getAddress(),"Address is perfect");
	}
	
	//AddHotel Method Functional Testing
	@Test
	public void addHotelUnitTest() throws HotelNotFoundException 
	{
		//Setting up logger
		LOGGER.info("Called addHotelUnitTest() method");
		
		MHotel hotel = new MHotel();
		hotel.setAddress("Pimpri1");
		hotel.setAvgRatePerDay(2000);
		hotel.setCity("Pune");
		hotel.setDescription("3 Star");
		hotel.setEmail("abc@g.com");
		hotel.setHotelName("ABCDE");
		hotel.setPhone1("7856497894");
		hotel.setPhone2("8456124567");
		hotel.setWebsite("www.abcde.com");
		hotel = hotelService.addHotel(hotel);
		assertNotNull(hotel,"Hotel found");
		assertEquals("Pimpri1", hotel.getAddress(),"Address is perfect");
	}
	
	//UpdateHotel Method Functional Testing
	@Test
	public void updateHotelUnitTest() throws HotelNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called updateHotelUnitTest() method");
		
		MHotel hotel = new MHotel();
		hotel.setAddress("pimpri");
		hotel.setAvgRatePerDay(2000);
		hotel.setCity("Pune");
		hotel.setDescription("3 Star");
		hotel.setEmail("abc@g.com");
		hotel.setHotelName("ABCDE");
		hotel.setPhone1("7856497894");
		hotel.setPhone2("8456124567");
		hotel.setWebsite("www.abcde.com");
	   	hotel.setHotelId(3);
		hotel = hotelService.updateHotel(hotel);
		assertNotNull(hotel,"Hotel found");
		assertEquals("pimpri", hotel.getAddress(),"Address is perfect");
	}
		
	//RemoveHotel Method Functional Testing
	@Test
	public void removeHotelUnitTest() throws HotelNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called removeHotelUnitTest() method");
		
		MHotel h1 = new MHotel();
		h1.setHotelId(3);
	   	h1.setAddress("Pimpri1");
	   	h1.setAvgRatePerDay(2000);
	   	h1.setCity("Pune");
	   	h1.setDescription("3 Star");
	   	h1.setEmail("abc@g.com");
	   	h1.setHotelName("ABCDE");
	   	h1.setPhone1("7856497894");
	   	h1.setPhone2("8456124567");
	   	h1.setWebsite("www.abcde.com");
	   	h1 = hotelImpl.removeHotel(h1.getHotelId());
	   	
	   	assertNotNull(h1,"Hotel found");
		assertNotEquals(3, h1.getHotelId(),"Remove done properly");
	}
}
