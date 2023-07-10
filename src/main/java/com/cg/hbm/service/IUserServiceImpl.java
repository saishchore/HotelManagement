package com.cg.hbm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.controller.BookingController;
import com.cg.hbm.entites.Hotel;
import com.cg.hbm.entites.User;
import com.cg.hbm.exceptions.UserExistException;
import com.cg.hbm.exceptions.UserListEmptyException;
import com.cg.hbm.exceptions.UserNotFoundException;
import com.cg.hbm.pojo.MHotel;
import com.cg.hbm.pojo.MUser;
import com.cg.hbm.repository.IUserRepository;

@Service								//Implementation of service layer method by extend that method
public class IUserServiceImpl implements IUserService
{
    @Autowired							//Bean Object of service class
    IUserRepository iuserrepository;

    //Declare Logger
	static final Logger LOGGER = LoggerFactory.getLogger(IUserServiceImpl.class);
    
    @Override							//Override method of service class
    @Transactional
    public MUser removeUser(int userId) 
    {
    	//setting logger info
    	LOGGER.info("Called removeUser() method of UserService");
    	 User usersearch = iuserrepository.findById(userId).orElse(null);
        if(usersearch==null)
        {
        	throw new UserNotFoundException("User not found");  //Throwing runtime exception
        }
        else 
        {
        	MUser u1 = new MUser();
        	u1.setUserId(usersearch.getUserId());
			u1.setUserName(usersearch.getUserName());
			u1.setEmail(usersearch.getEmail());
			u1.setPassword(usersearch.getPassword());
			u1.setRole(usersearch.getRole());
			u1.setMobile(usersearch.getMobile());
			u1.setAddress(usersearch.getAddress());
			iuserrepository.deleteById(usersearch.getUserId());
	       	return u1;
        }
    }

    @Override														//Override method of service class
    @Transactional
    public List<MUser> showAllUsers()
    {
    	//setting logger info
    	LOGGER.info("Called showAllUsers() method of UserService");

    	List<User> list=iuserrepository.findAll();
    	if(list.size()==0)
    	{
    		throw new UserListEmptyException("User list is empty");  //Throwing runtime exception
    	}
    	else
    	{
    		List<MUser> list1 = new ArrayList<MUser>();
			for(User user : list) 
			{
				
				MUser u1 = new MUser();
				u1.setUserId(user.getUserId());
				u1.setUserName(user.getUserName());
				u1.setEmail(user.getEmail());
				u1.setPassword(user.getPassword());
				u1.setRole(user.getRole());
				u1.setMobile(user.getMobile());
				u1.setAddress(user.getAddress());
				list1.add(u1);
			}
			return list1;
    	}
    }
    
    @Override					//Override method of service class
    @Transactional
	public MUser addUser(MUser user) 
    {
    	//setting logger info
    	LOGGER.info("Called addUser() method of UserService");

    	User user1 = iuserrepository.findExistUser(user.getEmail(), user.getUserName());
    	
    	if(user1!=null)
    	{
    		
    		throw new UserExistException();
    	}
    	else
    	{
    		
    		User users=new User();
    		users.setUserName(user.getUserName());
    		users.setEmail(user.getEmail());
    		users.setPassword(user.getPassword());
    		users.setRole(user.getRole());
    		users.setMobile(user.getMobile());
    		users.setAddress(user.getAddress());
    		users=iuserrepository.save(users);
    		user.setUserId(users.getUserId());
    		return user;
    	}
    }

	@Override													//Override method of service class
	@Transactional
	public MUser showUserById(Integer userId) 
	{
		//setting logger info
    	LOGGER.info("Called showUserById() method of UserService");

		 User user = iuserrepository.findById(userId).orElse(null);
		if(user!=null) 
		{
			MUser u1 = new MUser();
			u1.setUserId(user.getUserId());
			u1.setUserName(user.getUserName());
			u1.setEmail(user.getEmail());
			u1.setPassword(user.getPassword());
			u1.setRole(user.getRole());
			u1.setMobile(user.getMobile());
			u1.setAddress(user.getAddress());
			return u1;
		}
		else
			throw new UserNotFoundException("User not found");		//Throwing runtime exception
	}

	
	@Transactional
	@Override												//Override method of service class
	public MUser updateUser(MUser user)
	{
		//setting logger info
    	LOGGER.info("Called updateUser() method of UserService");

		User searchUser = iuserrepository.findById(user.getUserId()).orElse(null);
		
		if(searchUser==null)
		{
			throw new UserNotFoundException("User not found");	//Throwing runtime exception
		}
		else 
		{
			User users=new User();
			users.setAddress(user.getAddress());
			users.setUserId(user.getUserId());
			users.setUserName(user.getUserName());
			users.setEmail(user.getEmail());
			users.setRole(user.getRole());
			users.setPassword(user.getPassword());
			users.setMobile(user.getMobile());
			users = iuserrepository.save(users);
			return user;
		}
	}

	@Override												//Override method of service class
	public MUser showUserByUsernameAndPassword(String userName, String password) 
	{
		//setting logger info
    	LOGGER.info("Called showUserByUsernameAndPassword() method of UserService");
		User user = iuserrepository.findByUsernameAndPassword(userName,password);
		if(user!=null) 
		{
			MUser u1 = new MUser();
			u1.setUserId(user.getUserId());
			u1.setUserName(user.getUserName());
			u1.setEmail(user.getEmail());
			u1.setPassword(user.getPassword());
			u1.setRole(user.getRole());
			u1.setMobile(user.getMobile());
			u1.setAddress(user.getAddress());
			return u1;
		}
		else
			throw new UserNotFoundException("User not found");	//Throwing runtime exception
	}
        
    
}

