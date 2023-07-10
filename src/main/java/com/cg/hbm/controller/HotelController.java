package com.cg.hbm.controller;

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

 



import com.cg.hbm.pojo.MHotel;
import com.cg.hbm.service.IHotelService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hotel/h1")						//Mapping controller with these url
public class HotelController 						//Hotel Controller
{
    @Autowired										//Bean Object of service class
    IHotelService hotelservice;
    
    //Logger Declare
    static final Logger LOGGER = LoggerFactory.getLogger(HotelController.class);
    
    //PostMapping method for add hotel
    @PostMapping(path="/addHotel")
    public ResponseEntity<MHotel> addHotel(@Valid @RequestBody MHotel hotel) 
    {
    	//setting logger info
    	LOGGER.info("Called Post mapping addHotel() method");
    	MHotel mHotel = hotelservice.addHotel(hotel);
    	return new ResponseEntity<MHotel>(mHotel,HttpStatus.OK);
     }
    
    //PutMapping method for update hotel
    @PutMapping(path="/updateHotel")
    public ResponseEntity<MHotel> updateHotel(@Valid @RequestBody MHotel hotel) 
    {
    	//setting logger info
    	LOGGER.info("Called Put mapping updateHotel() method");
    	MHotel mHotel  = hotelservice.updateHotel(hotel);
    	return new ResponseEntity<MHotel>(mHotel,HttpStatus.OK);
    }
    
    //GetMapping method for get all hotel
    @GetMapping(path = "/getallhotels")
    public ResponseEntity<List<MHotel>> showAllHotels() 
    {
    	//setting logger info
    	LOGGER.info("Called Get mapping showAllHotels() method");
    	List<MHotel> mList =  hotelservice.showAllHotels();
    
    	if(mList.isEmpty())
    	{
    		return new ResponseEntity("Sorry! hotels not available!", HttpStatus.NOT_FOUND);
    	}
    	else
    		return new ResponseEntity<List<MHotel>>(mList, HttpStatus.OK);
    }
    
    //GetMapping method for get hotel by id
    @GetMapping(path = "/gethotelbyid/{id}")
    public ResponseEntity<MHotel> showHotel(@PathVariable Integer id) 
    {
    	//setting logger info
    	LOGGER.info("Called Get mapping showHotel() method");
    	MHotel hotel = hotelservice.showHotel(id);
    	if(hotel==null) 
    	{
    		return new ResponseEntity("Sorry! hotel not available!", HttpStatus.NOT_FOUND);
    	}
    	else 
    	{
    		return new ResponseEntity<MHotel>(hotel, HttpStatus.OK);
    	}
     
	}
    
    //DeleteMapping method for remove hotel
	@DeleteMapping(path="/removehotel/{id}")
    public ResponseEntity<MHotel> removeHotel( @PathVariable Integer id)
	{
		//setting logger info
		LOGGER.info("Called Delete mapping removeHotel() method");
		MHotel hotel  = hotelservice.removeHotel(id);
		if(hotel==null) 
		{
			return new ResponseEntity("Sorry! hotel not available!", HttpStatus.NOT_FOUND);
		}
		else 
		{
			return new ResponseEntity<MHotel>(hotel, HttpStatus.OK);
		}
       
	}
	
	
	@GetMapping(path = "/gethotelbyname/{hotelName}")
    public ResponseEntity<List<MHotel>> showHotelByName(@PathVariable String hotelName) 
    {
    	//setting logger info
    	LOGGER.info("Called Get mapping showAllHotels() method");
    	List<MHotel> list =  hotelservice.showHotelByName(hotelName);
    
    	if(list.isEmpty())
    	{
    		return new ResponseEntity("Sorry! hotels not available!", HttpStatus.NOT_FOUND);
    	}
    	else
    		return new ResponseEntity<List<MHotel>>(list, HttpStatus.OK);
    }
 @GetMapping(path = "/gethotelbycity/{city}")
    public ResponseEntity<List<MHotel>> showHotelByCity(@PathVariable String city) 
    {
    	//setting logger info
    	LOGGER.info("Called Get mapping showAllHotels() method");
    	List<MHotel> list =  hotelservice.showHotelByCity(city);
    
    	if(list.isEmpty())
    	{
    		return new ResponseEntity("Sorry! hotels not available!", HttpStatus.NOT_FOUND);
    	}
    	else
    		return new ResponseEntity<List<MHotel>>(list, HttpStatus.OK);
    }



}