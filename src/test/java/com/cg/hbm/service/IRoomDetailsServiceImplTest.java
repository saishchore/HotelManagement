package com.cg.hbm.service;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.exceptions.RoomDetailsNotFoundException;
import com.cg.hbm.pojo.MHotel;
import com.cg.hbm.pojo.MRoomDetails;
import com.cg.hbm.repository.IRoomDetailsRepository;


@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
@ExtendWith(MockitoExtension.class)		//Extend Mockito Extension class here for mock testing
public class IRoomDetailsServiceImplTest 
{
	//Making proxy object of RoomDetail repository class and for that class we going to test
	@Mock
	IRoomDetailsRepository roomdetailsRepository;
	
	//Making proxy object of RoomDetail service
	@InjectMocks
	IRoomDetailsServiceImpl roomImpl; 
	
	//Making proxy object of RoomDetail repository class and for that class we going to test
	@Mock
	RoomDetails room;
	
	//Bean object of service layer
	@Autowired
	IRoomDetailsServiceImpl roomService;
	
	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(IRoomDetailsServiceImplTest.class);
	
	//Testing addPaymentTest Method From Service level Test
	@Test
	public void shouldreturnAllRoomDetailsTest()
	{
		//Setting up logger
		LOGGER.info("Called shouldreturnAllRoomDetailsTest() method");
		
		List<RoomDetails> mockRoom = new ArrayList<>();
		Hotel hotel=new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com");
		
		RoomDetails r1=new RoomDetails();
		r1.setRoomId(101);
		r1.setRoomNo("450");
		r1.setRoomType("AC");
		r1.setRatePerDay(2500.0);
		r1.setAvailable(true);
		r1.setHotel(hotel);
		mockRoom.add(r1);
		Mockito.when(roomdetailsRepository.findAll()).thenReturn(mockRoom);
		List<MRoomDetails> realRoomDetails = roomImpl.showAllRoomDetails();
		assertEquals("AC", realRoomDetails.get(0).getRoomType());
	}
	
	//Testing addPaymentTest Method From Service level Test
	@Test
	public void shouldReturnAllRoomDetailsByIdTest() 
	{
		//Setting up logger
		LOGGER.info("Called shouldReturnAllRoomDetailsByIdTest() method");
		
		List<RoomDetails> mockRoom = new ArrayList<>();
		Hotel hotel=new Hotel(1,"Pune","Radisson Blu","Kharadi","5 Star",5000,"radissonblu@gmail.com","12345","56789","www.RadissonBlu.com");
		
		RoomDetails r1=new RoomDetails();
		r1.setRoomId(1);
		r1.setRoomNo("450");
		r1.setRoomType("AC");
		r1.setRatePerDay(2500.0);
		r1.setAvailable(true);
		r1.setHotel(hotel);
		mockRoom.add(r1);
		roomdetailsRepository.saveAll(mockRoom);
		Mockito.when(roomdetailsRepository.findById(1)).thenReturn(Optional.of(r1));
		MRoomDetails realRoomDetails = roomImpl.showRoomDetails(1);
		assertEquals("AC", realRoomDetails.getRoomType());
		
	}
	
		
	//Functional Testing
	//Testing showRoomDetailsUnitTest Method From Service level Test	
	@Test
	public void showAllRoomDetailsUnitTest()
	{
		//Setting up logger
		LOGGER.info("Called showAllRoomDetailsUnitTest() method");
		
		List<MRoomDetails> room = roomService.showAllRoomDetails();
		assertNotNull(room,"Room Details found");
		assertEquals("101", room.get(1).getRoomNo(),"Room Type is perfect");
	}
	
	//Testing showRoomDetailsUnitTest Method From Service level Test	
	@Test
	public void showRoomDetailsUnitTest()
	{
		//Setting up logger
		LOGGER.info("Called showAllRoomDetailsUnitTest() method");
			
		MRoomDetails room = roomService.showRoomDetails(2);
		assertNotNull(room,"Room Details found");
		assertEquals("101", room.getRoomNo(),"Room Type is perfect");
	}
	
	//Testing addRoomDetailsUnitTest Method From Service level Test
	@Test
	public void addRoomDetailsUnitTest()
	{
		//Setting up logger
		LOGGER.info("Called addRoomDetailsUnitTest() method");
		
		MRoomDetails r1=new MRoomDetails();
		r1.setRoomNo("450");
		r1.setRoomType("AC");
		r1.setRatePerDay(2500.0);
		r1.setAvailable(true);
		r1.setHotelId(1);
		r1=roomService.addRoomDetail(r1);
		assertNotNull(r1,"Room details found");
		assertEquals("450",r1.getRoomNo(),"Room No is correct");
	}
	
	//Testing updateRoomDetailsUnitTest Method From Service level Test
	@Test
	public void updateRoomDetailsUnitTest()
	{
		//Setting up logger
		LOGGER.info("Called updateRoomDetailsUnitTest() method");
		
		MRoomDetails r1=new MRoomDetails();
		r1.setRoomId(4);
		r1.setRoomNo("450");
		r1.setRoomType("AC");
		r1.setRatePerDay(2500.0);
		r1.setAvailable(true);
		r1.setHotelId(1);
		r1=roomService.updateRoomDetail(r1);
		assertNotNull(r1,"Room details found");
		assertEquals("450",r1.getRoomNo(),"Room No is correct");
	}
	
	//Testing removeRoomDetailsUnitTest Method From Service level Test
	@Test
    public void removeRoomDetailsUnitTest() 
    {
		//Setting up logger
		LOGGER.info("Called removeRoomDetailsUnitTest() method");
		
        MRoomDetails r1=new MRoomDetails();
        r1=roomService.removeRoomDetails(1);
        
        assertNotNull(r1);
        assertEquals(4,r1.getRoomId());
    }
}





