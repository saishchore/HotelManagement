package com.cg.hbm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication				//Annotation tells its a spring boot application
public class HotelBookingApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(HotelBookingApplication.class, args); //Spring Boot application runs from here
	}

}
