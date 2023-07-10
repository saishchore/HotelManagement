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
import com.cg.hbm.entites.User;
import com.cg.hbm.exceptions.UserListEmptyException;
import com.cg.hbm.exceptions.UserNotFoundException;
import com.cg.hbm.pojo.MUser;
import com.cg.hbm.service.IUserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user/v1")						//Mapping controller with these url
public class UserController 					//Payment Controller
{
    @Autowired
    IUserService service;						//Bean Object of service class
    
    //Logger Declare
	static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	//DeleteMapping method for remove user
    @DeleteMapping(path="/removeuser/{userId}")
    public ResponseEntity<MUser> removeUser( @PathVariable Integer userId) 
    {
    	//setting logger info
    	LOGGER.info("Called Delete mapping removeUser() method");
        MUser user=service.removeUser(userId);
        if(user==null) 
        {
            return new ResponseEntity("sorry! user not available",HttpStatus.NOT_FOUND);
        }
        else 
        {
            return new ResponseEntity<MUser>(user, HttpStatus.OK);
        }
    
    }
    
    //GetMapping method for get all user
    @GetMapping(path = "/getallusers")
    public ResponseEntity<List<MUser>> showAllUsers()
    {
    	//setting logger info
    	LOGGER.info("Called Get mapping showAllUsers() method");
        List<MUser> mUser =  service.showAllUsers();
        if(mUser.isEmpty())
        {
            return new ResponseEntity("Sorry! Products not available!", HttpStatus.NOT_FOUND);
        }
        else
        	return new ResponseEntity<List<MUser>>(mUser, HttpStatus.OK);
    }
    
    //PostMapping method for add user
    @PostMapping(path="/addUser")
	public ResponseEntity<MUser> addUser(@Valid @RequestBody MUser user) 
    {
    	//setting logger info
    	LOGGER.info("Called Post mapping addUser() method");
		MUser mUser = service.addUser(user);
		return new ResponseEntity<MUser>(mUser, HttpStatus.OK);
	}
	
    //GetMapping method for get user by id
	@GetMapping(path = "/getuserbyid/{userId}")
	public ResponseEntity<MUser> showUserById(@PathVariable Integer userId) 
	{
		//setting logger info
		LOGGER.info("Called Get mapping showUserById() method");
		MUser mUser = service.showUserById(userId);
		if(mUser==null) 
		{
			return new ResponseEntity("Sorry user not available!", HttpStatus.NOT_FOUND);
		}
		else 
		{
			return new ResponseEntity<MUser>(mUser, HttpStatus.OK);
		}
		
	}
	
	//GetMapping method for user login by username and password
	@GetMapping(path = "/userlogin/{userName}/{password}")
	public ResponseEntity<MUser> showUserByUsernameAndPassword(@PathVariable String userName, @PathVariable String password) 
	{
		//setting logger info
		LOGGER.info("Called Get mapping showUserByUsernameAndPassword() method");
		MUser user = service.showUserByUsernameAndPassword(userName,password);
		if(user==null) {
			return new ResponseEntity("Sorry user not available!", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<MUser>(user, HttpStatus.OK);
		}
		
	}
	
	//PutMapping method for update user
	@PutMapping(path="/updateuser")
	public ResponseEntity<MUser> updateUser(@Valid @RequestBody MUser user)
	{
		//setting logger info
		LOGGER.info("Called Put mapping updateUser() method");
		MUser mUser = service.updateUser(user);
		return new ResponseEntity<MUser>(mUser, HttpStatus.OK);
	}
	
	

}
