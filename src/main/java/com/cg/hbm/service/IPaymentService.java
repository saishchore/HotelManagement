package com.cg.hbm.service;

import com.cg.hbm.entites.Payments;
import com.cg.hbm.pojo.MPayment;

public interface IPaymentService 						//Service layer method
{
	public MPayment addPayment(MPayment payment);
}
