package com.cg.hbm.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.hbm.exceptions.BookingDetailsNotFoundException;
import com.cg.hbm.exceptions.PaymentsNotFoundException;
import com.cg.hbm.pojo.MBooking;
import com.cg.hbm.pojo.MPayment;
import com.cg.hbm.service.IPaymentServiceImpl;

@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
@ExtendWith(MockitoExtension.class)
public class PaymentControllerTest 
{
	//Making proxy object of hotel service
	@Mock
	IPaymentServiceImpl paymentService;
	
	//Making proxy object of hotel controller class and for that class we going to test
	@InjectMocks
	PaymentController paymentController;
	
	//Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(BookingDetailsControllerTest.class);
	
	@Test
	public void addPaymentControllerTest() throws PaymentsNotFoundException
	{
		//Setting up logger
		LOGGER.info("Called signInControllerTest() method");
		MPayment mp=new MPayment(5,1000,6);
		Mockito.when(paymentService.addPayment(mp)).thenReturn(mp);
		assertEquals(paymentController.addPayment(mp).getStatusCode(),HttpStatus.OK);
		
	}

}