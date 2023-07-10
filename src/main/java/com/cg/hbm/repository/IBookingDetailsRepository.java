package com.cg.hbm.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.cg.hbm.entites.BookingDetails;

//Dao layer method
@Repository
public interface IBookingDetailsRepository  extends JpaRepository<BookingDetails, Integer> //Annotation is used to make these class as repository and extends JpaRepository to get all functions
{
	@Query(value = "select b from BookingDetails b where b.hotel.hotelId=:hotelId order by b.bookingId") //Writing customized query for that method
	public List<BookingDetails> showByhotelId(int hotelId);
	
	@Query(value = "select b from BookingDetails b where b.roomdetails.roomId=:roomId") //Writing customized query for that method
	public List<BookingDetails> showByroomId(int roomId);
	
	@Query(value = "select b from BookingDetails b where b.user.userId=:userId")		//Writing customized query for that method
	public List<BookingDetails> showByuserId(int userId);
	
	
	@Query(value = "select b.roomdetails.roomId from BookingDetails b where b.bookedFrom>=:bookFrom and b.bookedTo<=:bookTo and b.hotel.hotelId=:hotelId")
	public List<Integer> viewOccupiedRoom(LocalDate bookFrom, LocalDate bookTo, int hotelId);
}
