package com.cg.hbm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

 

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
//import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.hbm.controller.AdminController;
import com.cg.hbm.exceptions.HotelNotFoundException;
import com.cg.hbm.exceptions.PaymentsNotFoundException;
import com.cg.hbm.pojo.MHotel;
import com.cg.hbm.pojo.MPayment;
import com.cg.hbm.repository.IPaymentRepository;

@SpringBootTest							//Annotation is used to tell that class is sprig boot test class and used for testing purpose
@RunWith(SpringJUnit4ClassRunner.class)	//Using JUnit4 for testing
@ExtendWith(MockitoExtension.class)		//Extend Mockito Extension class here for mock testing
public class IPaymentServiceImplTest 
{
	//Bean object of service layer
    @Autowired
    IPaymentServiceImpl paymentService;
    
    //Making proxy object of payment service class and for that class we are going to test
    @InjectMocks
    IPaymentServiceImpl paymentImplMock;
    
    //Making proxy object of payment repository
    @Mock
    IPaymentRepository paymentRepository;
    
    //Logger Declare
  	static final Logger LOGGER = LoggerFactory.getLogger(IPaymentServiceImplTest.class);
    
    //Testing addPaymentTest Method From Service level Test
    @Test
    public void addPaymentTest() throws PaymentsNotFoundException
    {
    	//Setting up logger
    	LOGGER.info("Called addPaymentTest() method");
        MPayment p=new MPayment();
        p.setAmount(2000.0);
        p.setBookingId(2);
              
        p=paymentService.addPayment(p);
        assertNotNull(p,"payment found");
        assertEquals(2,p.getBookingId(),"booking id is perfect");
        
    }

 

}