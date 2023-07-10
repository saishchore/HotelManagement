package com.cg.hbm.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.hbm.controller.AdminControllerTest;
import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.pojo.MRoomDetails;


@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
public class RoomDetailsTest 
{
		//Logger Declare
		static final Logger LOGGER = LoggerFactory.getLogger(RoomDetailsTest.class);
	
		//Testing getter methods for Hotel class
		@Test
		public void getTest()
		{
			//Setting up logger
			LOGGER.info("Called getTest() method");
			
			RoomDetails room = new RoomDetails();
			
			room.setAvailable(true);
			room.setRatePerDay(2500.0);
			room.setRoomNo("450");
			room.setRoomType("AC");
			
			assertEquals(room.isAvailable(),true);
			assertEquals(room.getRatePerDay(),2500.0);
			assertEquals(room.getRoomNo(),"450");
			assertEquals(room.getRoomType(),"AC");
		}
		
		//Testing setter methods for Hotel class
		@Test
		public void setTest()
		{
			//Setting up logger
			LOGGER.info("Called setTest() method");
			
			RoomDetails room = new RoomDetails();
			
			room.setAvailable(true);
			room.setRatePerDay(2500.0);
			room.setRoomNo("450");
			room.setRoomType("AC");
						
			assertEquals(room.isAvailable(),true);
			assertEquals(room.getRatePerDay(),2500.0);
			assertEquals(room.getRoomNo(),"450");
			assertEquals(room.getRoomType(),"AC");
			
		}		
}