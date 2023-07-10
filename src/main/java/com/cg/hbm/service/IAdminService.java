package com.cg.hbm.service;

import com.cg.hbm.entites.Admin;

public interface IAdminService 				//Service layer method
{
	public Admin signIn(Admin admin);
	//public Admin signOut(Admin admin);
	public Admin signIn(String adminName,String password);
}
