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

import com.cg.hbm.entites.Admin;
import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.exceptions.BookingDetailsNotFoundException;
import com.cg.hbm.exceptions.ListEmptyException;
import com.cg.hbm.pojo.MBooking;
import com.cg.hbm.service.IAdminService;
import com.cg.hbm.service.IBookingDetailsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin/v1")	//Mapping controller with these url
public class AdminController 
{
	@Autowired					//Bean object of service layer
	IAdminService service;
	
	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	
	//Get mapping for show admin by admin name and password
	@GetMapping(path = "/adminlogin/{adminName}/{password}")
	public ResponseEntity<Admin> showAdminByAdminnameAndPassword(@PathVariable String adminName, @PathVariable String password) 
	{
		//Setting up logger
		LOGGER.info("Called Get mapping showAdminByAdminnameAndPassword() method");
		Admin admin = service.signIn(adminName,password);
		if(admin==null) 
		{
			return new ResponseEntity("Sorry admin not available!", HttpStatus.NOT_FOUND);
		}
		else 
		{
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		}
		
	}

	
	
	}

