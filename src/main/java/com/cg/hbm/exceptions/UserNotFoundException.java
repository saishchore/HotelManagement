package com.cg.hbm.exceptions;

public class UserNotFoundException extends RuntimeException		//Extends Runtime Exception and handling exception at runtime only
{
	public UserNotFoundException (String message) 
	{
		super(message);
	}

}
