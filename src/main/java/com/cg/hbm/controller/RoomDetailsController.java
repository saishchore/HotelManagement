package com.cg.hbm.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/room/v1")								//Mapping controller with these url
public class RoomDetailsController 						//Payment Controller
{

	@Autowired
	IRoomDetailsService service;						//Bean Object of service class

	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(RoomDetailsController.class);

	//PostMapping method for add room details
	@PostMapping(path="/addRoom")
    public ResponseEntity<MRoomDetails> addRoomDetail(@Valid @RequestBody MRoomDetails room) 
	{
		//setting logger info
		LOGGER.info("Called Post mapping addRoomDetail() method");
		MRoomDetails roomDetails = service.addRoomDetail(room);
		if(roomDetails==null)
    	{
    		return new ResponseEntity("Sorry! Room not added!", HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<MRoomDetails>(roomDetails, HttpStatus.OK);
    }
	
	//GetMapping method for get all room details
    @GetMapping(path = "/getallroomdetails")
    public ResponseEntity<List<MRoomDetails>> showAllRoomDetails() 
    {
    	//setting logger info
    	LOGGER.info("Called Get mapping showAllRoomDetails() method");
    	List<MRoomDetails> mRoomList =  service.showAllRoomDetails();
    	if(mRoomList.isEmpty())
    	{
    		return new ResponseEntity("Sorry! Room not available!", HttpStatus.NOT_FOUND);
    	}
    	else
    		return new ResponseEntity<List<MRoomDetails>>(mRoomList, HttpStatus.OK);
    }
    
    //PostMapping method for get all room details by hotel id
    @GetMapping(path = "/getbyhotelid/{hotelId}")
    public ResponseEntity<List<MRoomDetails>> showAllRoomDetails(@PathVariable int hotelId) 
    {
    	//setting logger info
    	LOGGER.info("Called Get mapping showAllRoomDetails() method");
    	List<MRoomDetails> mRoomList =  service.showAllRoomDetails(hotelId);
    	if(mRoomList.isEmpty())
    	{
    		return new ResponseEntity("Sorry! Room not available!", HttpStatus.NOT_FOUND);
    	}
    	else
    		return new ResponseEntity<List<MRoomDetails>>(mRoomList, HttpStatus.OK);
    }
    
    //PostMapping method for get room details by id
    @GetMapping(path = "/getroombyid/{roomId}")
	public ResponseEntity<MRoomDetails> showRoomDetails(@PathVariable Integer roomId) 
    {
    	//setting logger info
    	LOGGER.info("Called Get mapping showRoomDetails() method");
		MRoomDetails room = service.showRoomDetails(roomId);
		return new ResponseEntity<MRoomDetails>(room, HttpStatus.OK);
	}
    
  //PostMapping method for update room details
	@PutMapping(path="/updateroom")
	public ResponseEntity<MRoomDetails> updateRoomDetail(@Valid @RequestBody MRoomDetails mRoom) 
	{
		//setting logger info
		LOGGER.info("Called Put mapping updateRoomDetail() method");
		MRoomDetails mRoomList = service.updateRoomDetail(mRoom);
		return new ResponseEntity<MRoomDetails>(mRoomList, HttpStatus.OK);
	}
	
	//PostMapping method for delete room details by id
	@DeleteMapping(path="/removeroom/{roomId}")
	public ResponseEntity<MRoomDetails> removeRoom(@PathVariable Integer roomId) 
	{
		//setting logger info
		LOGGER.info("Called Delete mapping removeRoomDetails() method");
		MRoomDetails mRoomList = service.removeRoomDetails(roomId);
		return new ResponseEntity<MRoomDetails>(mRoomList, HttpStatus.OK);
	}
}
