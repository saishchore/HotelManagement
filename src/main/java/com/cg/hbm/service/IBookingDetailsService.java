package com.cg.hbm.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.exceptions.BookingDetailsNotFoundException;
import com.cg.hbm.exceptions.ListEmptyException;
import com.cg.hbm.pojo.MBooking;
import com.cg.hbm.pojo.MRoomDetails;

public interface IBookingDetailsService 			//Service layer method
{
	
	public MBooking addBookingDetails(MBooking bookingDetails, int userId);
	public MBooking updateBookingDetails(MBooking booking,int userId);
	public MBooking removeBookingDetails(int id);
	public List<MBooking> showAllBookingDetails();
	public MBooking showBookingDetails(int id);
	public List<MBooking> showBookingDetailsByhotelId(int hotelId);
	public List<MBooking> showBookingDetailsByroomId(int roomId);
	public List<MBooking> showBookingDetailsByuserId(int userId);
	public List<MRoomDetails> viewOccupiedRoom(LocalDate bookFrom, LocalDate bookTo, int hotelId);
}
