package com.cg.hbm.exceptions;

public class ListEmptyException extends RuntimeException 	//Extends Runtime Exception and handling exception at runtime only
{
       public ListEmptyException(String message) {
		super(message);
	}
}
