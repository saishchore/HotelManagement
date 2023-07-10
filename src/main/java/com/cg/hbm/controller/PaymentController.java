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


import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.exceptions.BookingDetailsNotFoundException;
import com.cg.hbm.exceptions.ListEmptyException;
import com.cg.hbm.pojo.MBooking;
import com.cg.hbm.pojo.MPayment;
import com.cg.hbm.service.IBookingDetailsService;
import com.cg.hbm.service.IPaymentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/payment/v1")								//Mapping controller with these url
public class PaymentController 								//Payment Controller
{
	@Autowired
	IPaymentService paymentService;							//Bean Object of service class
	
	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

	//PostMapping method for add payment
	@PostMapping(path="/addPayment")
    public ResponseEntity<MPayment> addPayment(@Valid @RequestBody MPayment payment) 
	{
		//setting logger info
		LOGGER.info("Called Post mapping addPayment() method");
		MPayment mPayment = paymentService.addPayment(payment);
		if(mPayment==null)
        {
            return new ResponseEntity("Sorry! payments not available!", HttpStatus.NOT_FOUND);
        }
        else
        {
        	return new ResponseEntity<MPayment>(mPayment, HttpStatus.OK);
        }
    }
	
}
