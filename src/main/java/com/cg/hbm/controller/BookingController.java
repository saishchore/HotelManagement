package com.cg.hbm.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.pojo.MBooking;
import com.cg.hbm.pojo.MRoomDetails;
import com.cg.hbm.service.IBookingDetailsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/booking/v1")								//Mapping controller with these url
public class BookingController 								//Booking Controller
{
	@Autowired                                              //Bean Object of service class
	IBookingDetailsService service;
	
	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);
	
	//PostMapping method for add booking details
	@PostMapping(path="/addBookingDetails/{userId}")
    public ResponseEntity<MBooking> addBookingDetails(@Valid @RequestBody MBooking booking, @PathVariable int userId) 
	{
		//setting logger info
		LOGGER.info("Called Post mapping addBookingDetails() method");
		MBooking bookingDetails = service.addBookingDetails(booking,userId);
		if(bookingDetails==null)
        {
            return new ResponseEntity("Sorry! booking not available!", HttpStatus.NOT_FOUND);
        }
        else
        {
        	return new ResponseEntity<MBooking>(bookingDetails, HttpStatus.OK);
        }
    }
	
	//PutMapping method for update booking details
	@PutMapping(path="/updatebookingdetails/{userId}")
	public ResponseEntity<MBooking> updateBookingDetails(@Valid @RequestBody MBooking mBooking, @PathVariable int userId) 
	{
		//setting logger info
		LOGGER.info("Called Put mapping updateBookingDetails() method");
		MBooking mBooking1 = service.updateBookingDetails(mBooking,userId);
		return new ResponseEntity<MBooking>(mBooking1,HttpStatus.OK);
	}
	
	//GetMapping method for get all booking details
	@GetMapping(path="/getallbookingdetails")
	public ResponseEntity<List<MBooking>> showAllBookingDetails() 
	{
		//setting logger info
		LOGGER.info("Called Get mapping showAllBookingDetails() method");
		List<MBooking> booking = service.showAllBookingDetails();
		
		if(booking.isEmpty()) 
		{
			return new ResponseEntity("Sorry! Booking details are not available!", HttpStatus.NOT_FOUND); 
		}
		else
			return new ResponseEntity<List<MBooking>>(booking,HttpStatus.OK);
	}
	
		//GetMapping method for get all booking details
		@GetMapping(path="/getroomids/{bookFrom}/{bookTo}/{hotelId}")
		public ResponseEntity<List<MRoomDetails>> roomIdList(@PathVariable String bookFrom,@PathVariable String bookTo, @PathVariable int hotelId) 
		{
			//setting logger info
			LOGGER.info("Called Get mapping showAllBookingDetails() method");
			String a[] = bookFrom.split("-");
			String b[] = bookTo.split("-");
			LocalDate from = LocalDate.of(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]));
			LocalDate to = LocalDate.of(Integer.parseInt(b[0]), Integer.parseInt(b[1]), Integer.parseInt(b[2]));
			List<MRoomDetails> booking = service.viewOccupiedRoom(from,to,hotelId);
			
			if(booking.isEmpty()) 
			{
				return new ResponseEntity("Sorry! Booking details are not available!", HttpStatus.NOT_FOUND); 
			}
			else
				return new ResponseEntity<List<MRoomDetails>>(booking,HttpStatus.OK);
		}
	
	//DeleteMapping method for remove booking details by id
	@DeleteMapping(path="/removebookingdetails/{id}")
	public ResponseEntity<MBooking> removeBookingDetails( @PathVariable Integer id) 
	{
		//setting logger info
		LOGGER.info("Called Delete mapping removeBookingDetails() method");
		MBooking mBooking = service.removeBookingDetails(id);
		if(mBooking == null) 
		{
			return new ResponseEntity("Sorry! Booking details are not available!", HttpStatus.NOT_FOUND); 
		}
		else
			return new ResponseEntity<MBooking>(mBooking,HttpStatus.OK);
	}
	
	//GetMapping method for get booking details by id
	@GetMapping(path="/getbookingdetails/{id}")
	public ResponseEntity<MBooking> showBookingDetails(@PathVariable int id) 
	{
		//setting logger info
		LOGGER.info("Called Get mapping showBookingDetails() method");
		MBooking mBooking = service.showBookingDetails(id);
		if(mBooking==null) 
		{
			return new ResponseEntity("Sorry! Booking details are not available!", HttpStatus.NOT_FOUND); 
		}
		else
		{
			return new ResponseEntity<MBooking>(mBooking,HttpStatus.OK);
		}
	}
	
	
	//GetMapping method for get booking details by hotel id
	@GetMapping(path="/getbookingdetailsbyhotelId/{hotelId}")
	public ResponseEntity<List<MBooking>> showBookingDetailsByHotelId(@PathVariable int hotelId) 
	{
		//setting logger info
		LOGGER.info("Called Get mapping showBookingDetailsByHotelId() method");
		List<MBooking> b4 = service.showBookingDetailsByhotelId(hotelId);
		if(b4==null) 
		{
			return new ResponseEntity("Sorry! Booking details are not available!", HttpStatus.NOT_FOUND); 
		}
		else
		{
			return new ResponseEntity<List<MBooking>>(b4,HttpStatus.OK);
		}
	}
			
	//GetMapping method for get booking details by room id
	@GetMapping(path="/getbookingdetailsbyroomId/{roomId}")
	public ResponseEntity<List<MBooking>> showBookingDetailsByRoomId(@PathVariable int roomId) 
	{
		//setting logger info
		LOGGER.info("Called Get mapping showBookingDetailsByRoomId() method");
		List<MBooking> b5 = service.showBookingDetailsByroomId(roomId);
		if(b5==null) 
		{
			return new ResponseEntity("Sorry! Booking details are not available!", HttpStatus.NOT_FOUND); 
		}
		else
		{
			return new ResponseEntity<List<MBooking>>(b5,HttpStatus.OK);
		}
	}
	
	//GetMapping method for get booking details by userId
		@GetMapping(path="/getbookingdetailsbyuserid/{userId}")
		public ResponseEntity<List<MBooking>> showBookingDetailsByuserId(@PathVariable int userId) 
		{
			//setting logger info
			LOGGER.info("Called Get mapping showBookingDetailsByuserId() method");
			List<MBooking> b6 = service.showBookingDetailsByuserId(userId);
			if(b6==null) 
			{
				return new ResponseEntity("Sorry! Booking details are not available!", HttpStatus.NOT_FOUND); 
			}
			else
			{
						return new ResponseEntity<List<MBooking>>(b6,HttpStatus.OK);
			}
		}
}
