package com.cg.hbm.exceptions;

public class RoomDetailsNotFoundException extends RuntimeException		//Extends Runtime Exception and handling exception at runtime only 
{
public	RoomDetailsNotFoundException(String message) 
	{
		super(message);
	}
}
