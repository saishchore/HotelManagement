package com.cg.hbm.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.controller.BookingController;
import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.entites.Payments;
import com.cg.hbm.pojo.MPayment;
import com.cg.hbm.repository.IBookingDetailsRepository;
import com.cg.hbm.repository.IPaymentRepository;

@Service									//Implementation of service layer method by extend that method
public class IPaymentServiceImpl implements IPaymentService
{
	@Autowired								//Bean Object of service class
	IPaymentRepository paymentrepository;
	
	@Autowired								//Bean Object of service class
	IBookingDetailsRepository booking;

	//Declare Logger
	static final Logger LOGGER = LoggerFactory.getLogger(IPaymentServiceImpl.class);

	
	@Override								//Override method of service class
	@Transactional
	public MPayment addPayment(MPayment payment) 
	{
		//setting logger info
		LOGGER.info("Called addPayment() method of PaymentService");
		BookingDetails b1 = booking.findById(payment.getBookingId()).orElse(null);
		Payments p1 = new Payments();
		p1.setBookingdetails(b1);
		p1.setAmount(payment.getAmount());
		
		p1 = paymentrepository.save(p1);
		payment.setPaymentId(p1.getPaymentId());
		return payment;
		//paymentrepository.save(payment);
	}

}
