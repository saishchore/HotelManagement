package com.cg.hbm.exceptions;

public class HotelListEmptyException extends RuntimeException		//Extends Runtime Exception and handling exception at runtime only
{

	 public HotelListEmptyException(String message) {
		 
		super(message);
		
	}
}

