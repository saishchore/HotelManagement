package com.cg.hbm.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.controller.BookingController;
import com.cg.hbm.entites.Admin;
import com.cg.hbm.exceptions.AdminNotFoundException;
import com.cg.hbm.repository.IAdminRepository;

@Service									//Implementation of service layer method by extend that method
public class IAdminServiceImpl implements IAdminService
{
	@Autowired								//Bean Object of service class
	IAdminRepository adminrepository;

	//Declare Logger
	static final Logger LOGGER = LoggerFactory.getLogger(IAdminServiceImpl.class);
	
	@Override								//Override method of service class
	@Transactional
	public Admin signIn(Admin admin) 
	{
		//setting logger info
		LOGGER.info("Called signIn() method of AdminService");
		return adminrepository.signIn(admin.getAdminName(),admin.getPassword());
	}
	
	@Override								//Override method of service class
	@Transactional
	public Admin signIn(String adminName,String password) 
	{
		//Setting up logger
		LOGGER.info("Called signIn() method of AdminService");
		Admin admin = adminrepository.findByAdminnameAndPassword(adminName,password);
         if(admin!=null) {
        	 Admin a1 = new Admin();
        	 a1.setAdminId(admin.getAdminId());
        	 a1.setAdminName(admin.getAdminName());
        	 a1.setPassword(admin.getPassword());
        	 return a1;
         }
         else {
        	 throw new AdminNotFoundException();   //throw runtime exception
         }
		
	}

//	@Override
//	public Admin signOut(Admin admin) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
