package com.cg.hbm.exceptions;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler 		//Handle each exception throw at runtime
{
			
		@ExceptionHandler(ConstraintViolationException.class) 			//Handle exception for constraint violation
		public void  springHandleNotFound(HttpServletResponse response) throws IOException
		{
		  response.sendError(HttpStatus.BAD_REQUEST.value(),"Constraint issues"); 
		}
	 
		@ExceptionHandler(MethodArgumentTypeMismatchException.class)	//Handle exception when method argument type mismatch
		public void  springMethodArgHandleIssue(HttpServletResponse response) throws IOException
		{
			  response.sendError(HttpStatus.BAD_REQUEST.value(), "Arguments mismatched......"); 
		}
		
		@ExceptionHandler(BookingDetailsNotFoundException.class) 		//Handle exception when book not found
		public void  bookDetailsNotFound(HttpServletResponse response) throws IOException
		{
		  response.sendError(HttpStatus.NOT_FOUND.value(),"No booking details found for given id"); 
		}
		
//		@ExceptionHandler(BookingExistException.class) 					//Handle exception when book not found
//		public void  bookDetailsExist(HttpServletResponse response) throws IOException
//		{
//		  response.sendError(HttpStatus.NOT_FOUND.value(),"Booking you want to add is already exist"); 
//		}
	
		@ExceptionHandler(ListEmptyException.class)						//Handle exception when booklist is empty
		public void listNotFound(HttpServletResponse response) throws IOException
		{
		response.sendError(HttpStatus.NOT_FOUND.value(),"There are no booking details to show"); 
		}
	
		@ExceptionHandler(HotelNotFoundException.class)					//Handle exception when hotel not found
		public void hotelNotFound(HttpServletResponse response) throws IOException
		{
				response.sendError(HttpStatus.NOT_FOUND.value(), "Hotel Not Found"); 
		}
		
		@ExceptionHandler(HotelExistException.class)					//Handle exception when hotel not found
		public void hotelExist(HttpServletResponse response) throws IOException
		{
				response.sendError(HttpStatus.NOT_FOUND.value(), "Hotel you are try to add with email is already exist try with new email"); 
		}
		
		@ExceptionHandler(HotelListEmptyException.class) 				//Handle exception when hotel list is empty
		public void listHotelException(HttpServletResponse response) throws IOException
		{
			  response.sendError(HttpStatus.NOT_FOUND.value(),"Hotel List is empty"); 
		}
	

		@ExceptionHandler(UserNotFoundException.class)					//Handle exception when user not found
		public void userNotFound(HttpServletResponse response) throws IOException
		{
			response.sendError(HttpStatus.NOT_FOUND.value(), "Username or Password is wrong"); 
		}
		
		@ExceptionHandler(UserExistException.class)					//Handle exception when user not found
		public void userExist(HttpServletResponse response) throws IOException
		{
			response.sendError(HttpStatus.NOT_FOUND.value(), "User you want to add with email or username is already exist try with another data"); 
		}
	      
	    @ExceptionHandler(UserListEmptyException.class) 				//Handle exception when user list is empty
		public void userListEmpty(HttpServletResponse response) throws IOException
		{
	      response.sendError(HttpStatus.NOT_FOUND.value(),"User List is empty"); 
	    }
		
		@ExceptionHandler(PaymentsNotFoundException.class) 				//Handle exception when payment not found
		public void paymentexception(HttpServletResponse response) throws IOException
		{
	      response.sendError(HttpStatus.NOT_FOUND.value(),"Payments not found"); 
	    }
		
		@ExceptionHandler(RoomDetailsNotFoundException.class) 			//Handle exception when room not found
		public void roomdetailsexception(HttpServletResponse response) throws IOException
		{
	      response.sendError(HttpStatus.NOT_FOUND.value(),"Room details not found"); 
	    }
		
		@ExceptionHandler(RoomExistException.class) 			//Handle exception when room not found
		public void roometailsExistException(HttpServletResponse response) throws IOException
		{
	      response.sendError(HttpStatus.NOT_FOUND.value(),"Room you want to add  with room no is already exist try with new room no"); 
	    }
	    
		@ExceptionHandler(RoomDetailsListEmptyException.class)			//Handle exception when roomlist is empty
		public void roomDetailsListNotFound(HttpServletResponse response) throws IOException
		{
		response.sendError(HttpStatus.NOT_FOUND.value(),"There are no room details to show"); 
		}
		
		@ExceptionHandler(AdminNotFoundException.class)			//Handle exception when roomlist is empty
		public void adminNotFoundException(HttpServletResponse response) throws IOException
		{
		response.sendError(HttpStatus.NOT_FOUND.value(),"Adminname or password is incorrect"); 
		}
		
		
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			
	        Map<String, Object> body = new LinkedHashMap<String, Object>();
	        body.put("timestamp", new Date());
	        body.put("status", status.value());
	        //Get all errors
	        List<String> errors = ex.getBindingResult()
	                .getFieldErrors()
	                .stream()
	                .map(x -> x.getDefaultMessage())
	                .collect(Collectors.toList());
	
	        body.put("errors", errors);
	        return new ResponseEntity<>(body, headers, status);
		}
}
