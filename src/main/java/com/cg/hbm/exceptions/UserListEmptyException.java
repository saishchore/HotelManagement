package com.cg.hbm.exceptions;

public class UserListEmptyException extends RuntimeException		//Extends Runtime Exception and handling exception at runtime only
{
	public UserListEmptyException (String message) {
		super(message);
	}
}
