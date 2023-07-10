package com.cg.hbm.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.controller.BookingController;
import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.entites.Hotel;
import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.entites.User;
import com.cg.hbm.exceptions.BookingDetailsNotFoundException;
import com.cg.hbm.exceptions.HotelNotFoundException;
import com.cg.hbm.exceptions.ListEmptyException;
import com.cg.hbm.exceptions.RoomDetailsNotFoundException;
import com.cg.hbm.exceptions.UserNotFoundException;
import com.cg.hbm.pojo.MBooking;
import com.cg.hbm.pojo.MRoomDetails;
import com.cg.hbm.repository.IBookingDetailsRepository;
import com.cg.hbm.repository.IHotelRepository;
import com.cg.hbm.repository.IRoomDetailsRepository;
import com.cg.hbm.repository.IUserRepository;

@Service											//Implementation of service layer method by extend that method
public class IBookingDetailsServiceImpl implements IBookingDetailsService 
{
	@Autowired										//Bean Object of service class
	IBookingDetailsRepository bookingdetailsrepository;

	@Autowired										//Bean Object of repository class
    IRoomDetailsRepository roomRepository;
	
	@Autowired 										//Bean Object of repository class
	IHotelRepository hotelrepository;
	
	@Autowired										//Bean Object of repository class
	IUserRepository userRepository;
	
	@Autowired
	IRoomDetailsService roomService;
	 
	//Declare Logger
	static final Logger LOGGER = LoggerFactory.getLogger(IBookingDetailsServiceImpl.class);

	
	@Override										//Override method of service class
	@Transactional
    public List<MBooking> showAllBookingDetails()
	{
		
		//setting logger info
		LOGGER.info("Called showAllBookingDetails() method of BookingDetailsService");
//		
//		System.out.println(roomId);
        List<BookingDetails> bookingList = bookingdetailsrepository.findAll();
        if (bookingList.isEmpty()) 
        {
            throw new ListEmptyException("Booking List is Empty");		//Throwing runtime exception
        } 
        else 
        {
        	List<MBooking> mBooking=new ArrayList<MBooking>();
        	for(BookingDetails booking:bookingList)
        	{
        		MBooking mBookingPojo=new MBooking();
        		mBookingPojo.setBookedFrom(booking.getBookedFrom());
        		mBookingPojo.setBookedTo(booking.getBookedTo());
        		mBookingPojo.setBookingId(booking.getBookingId());
        		mBookingPojo.setHotelId(booking.getHotel().getHotelId());
        		mBookingPojo.setNoOfAdults(booking.getNoOfAdults());
        		mBookingPojo.setNoOfChildren(booking.getNoOfChildren());
        		mBookingPojo.setRoomId(booking.getRoomdetails().getRoomId());
        		mBookingPojo.setTotalamount(booking.getAmount());
        		mBookingPojo.setUserId(booking.getUser().getUserId());
        		mBookingPojo.setHotelName(booking.getHotel().getHotelName());
        		mBookingPojo.setUserName(booking.getUser().getUserName());
        		mBooking.add(mBookingPojo);
        	}
            return mBooking;
        }
       
    }

	@Override									//Override method of service class
	@Transactional
	public MBooking showBookingDetails(int bookingId)
	{
		//setting logger info
		LOGGER.info("Called showBookingDetails() method of BookingDetailsService");
		BookingDetails booking = bookingdetailsrepository.findById(bookingId).orElse(null);
		if(booking!=null)
		{
			MBooking mBooking=new MBooking();
			mBooking.setBookedFrom(booking.getBookedFrom());
			mBooking.setBookedTo(booking.getBookedTo());
			mBooking.setBookingId(booking.getBookingId());
			mBooking.setNoOfAdults(booking.getNoOfAdults());
			mBooking.setNoOfChildren(booking.getNoOfChildren());
			mBooking.setRoomId(booking.getRoomdetails().getRoomId());
			mBooking.setHotelId(booking.getHotel().getHotelId());
			mBooking.setUserId(booking.getUser().getUserId());
			mBooking.setTotalamount(booking.getAmount());
			
			return mBooking;
		}
		else
		{
			throw new BookingDetailsNotFoundException();		//Throwing runtime exception
		}
	}

	@Override													//Override method of service class
	@Transactional
	public MBooking addBookingDetails(MBooking booking, int userId) 
	{
		//setting logger info
		LOGGER.info("Called addBookingDetails() method of BookingDetailsService");
		RoomDetails room = roomRepository.findById(booking.getRoomId()).orElse(null);
		Hotel hotel = hotelrepository.findById(booking.getHotelId()).orElse(null);
		User user = userRepository.findById(userId).orElse(null);
		
		if(room==null)
		{
			throw new RoomDetailsNotFoundException("Room not found");
		}
		else if(hotel==null)
		{
			throw new HotelNotFoundException();
		}
		else if(user==null)
		{
			throw new UserNotFoundException("User not found");
		}
		else
		{
		
			BookingDetails bookingDetails = new BookingDetails();
			bookingDetails.setAmount(booking.getTotalamount());
			bookingDetails.setBookedFrom(booking.getBookedFrom());
			bookingDetails.setBookedTo(booking.getBookedTo());
			bookingDetails.setNoOfAdults(booking.getNoOfAdults());
			bookingDetails.setNoOfChildren(booking.getNoOfChildren());
			bookingDetails.setRoomdetails(room);
			bookingDetails.setHotel(hotel);
			bookingDetails.setUser(user);
			bookingDetails = bookingdetailsrepository.save(bookingDetails);
			booking.setBookingId(bookingDetails.getBookingId());
			booking.setUserId(bookingDetails.getUser().getUserId());
			booking.setUserName(bookingDetails.getUser().getUserName());
			booking.setHotelName(bookingDetails.getHotel().getHotelName());
			return booking;
		}
	}
	
	@Override														//Override method of service class
	@Transactional
	public MBooking updateBookingDetails(MBooking booking,int userId) 
	{
		//setting logger info
		LOGGER.info("Called updateBookingDetails() method of BookingDetailsService");
		BookingDetails  bookDetails = bookingdetailsrepository.findById(booking.getBookingId()).orElse(null);
		RoomDetails room = roomRepository.findById(booking.getRoomId()).orElse(null);
		Hotel hotel = hotelrepository.findById(booking.getHotelId()).orElse(null);
		User user = userRepository.findById(userId).orElse(null);
   	 	if (bookDetails==null)
        {
            throw new BookingDetailsNotFoundException();			//Throwing runtime exception
        }
   	 	else if(room==null)
		{
			throw new RoomDetailsNotFoundException("Room not found");
		}
		else if(hotel==null)
		{
			throw new HotelNotFoundException();
		}
		else if(user==null)
		{
			throw new UserNotFoundException("User not found");
		}
   	 	else 
        {  	 	
		
   	 		BookingDetails bookingDetails = new BookingDetails();
   	 		bookingDetails.setAmount(booking.getTotalamount());
   	 		bookingDetails.setBookedFrom(booking.getBookedFrom());
   	 		bookingDetails.setBookedTo(booking.getBookedTo());
   	 		bookingDetails.setNoOfAdults(booking.getNoOfAdults());
   	 		bookingDetails.setNoOfChildren(booking.getNoOfChildren());
   	 		bookingDetails.setRoomdetails(room);
   	 		bookingDetails.setHotel(hotel);
   	 		bookingDetails.setUser(user);
   	 		bookingDetails.setBookingId(booking.getBookingId());
   	 		bookingdetailsrepository.save(bookingDetails);
		
   	 		return booking;
       	 
        }   
	}

	@Override												//Override method of service class
	@Transactional
	public MBooking removeBookingDetails(int bookingId) 
	{
		//setting logger info
		LOGGER.info("Called removeBookingDetails() method of BookingDetailsService");
		BookingDetails searchBooking = bookingdetailsrepository.findById(bookingId).orElse(null);
        if (searchBooking==null)
        {	
        	throw new BookingDetailsNotFoundException();	//Throwing runtime exception
        }
        else 
        {
        	MBooking mBooking=new MBooking();
        	mBooking.setBookedFrom(searchBooking.getBookedFrom());
        	mBooking.setBookedTo(searchBooking.getBookedTo());
        	mBooking.setBookingId(searchBooking.getBookingId());
        	mBooking.setHotelId(searchBooking.getHotel().getHotelId());
        	mBooking.setNoOfAdults(searchBooking.getNoOfAdults());
        	mBooking.setNoOfChildren(searchBooking.getNoOfChildren());
        	mBooking.setRoomId(searchBooking.getRoomdetails().getRoomId());
        	mBooking.setUserId(searchBooking.getUser().getUserId());
        	mBooking.setTotalamount(searchBooking.getAmount());
        	bookingdetailsrepository.deleteById(bookingId);
        	return mBooking;
        }   
	}
	
	@Override									//Override method of service class
	@Transactional
	public List<MBooking> showBookingDetailsByhotelId(int hotelId)
	{
		//setting logger info
		LOGGER.info("Called showBookingDetailsByhotelId() method of BookingDetailsService");
		List<BookingDetails> bookingDetails = bookingdetailsrepository.showByhotelId(hotelId);
		List<MBooking> bMBookingDetails= new ArrayList<MBooking>();
		for(BookingDetails bookingDetailsList:bookingDetails)
		{
			MBooking mBookingDetails = new MBooking();
			mBookingDetails.setBookedFrom(bookingDetailsList.getBookedFrom());
			mBookingDetails.setBookedTo(bookingDetailsList.getBookedTo());
			mBookingDetails.setNoOfAdults(bookingDetailsList.getNoOfAdults());
			mBookingDetails.setNoOfChildren(bookingDetailsList.getNoOfChildren());
			mBookingDetails.setTotalamount(bookingDetailsList.getAmount());
			mBookingDetails.setHotelId(bookingDetailsList.getHotel().getHotelId());
			mBookingDetails.setRoomId(bookingDetailsList.getRoomdetails().getRoomId());
			mBookingDetails.setUserId(bookingDetailsList.getUser().getUserId());
			mBookingDetails.setBookingId(bookingDetailsList.getBookingId());
			mBookingDetails.setUserName(bookingDetailsList.getUser().getUserName());
			mBookingDetails.setHotelName(bookingDetailsList.getHotel().getHotelName());
			bMBookingDetails.add(mBookingDetails);
		}
		return bMBookingDetails;
//		else
//		{
//			throw new BookingDetailsNotFoundException();		//Throwing runtime exception
//		}
	}
	
	@Override									//Override method of service class
	@Transactional
	public List<MBooking> showBookingDetailsByroomId(int roomId)
	{
		//setting logger info
		LOGGER.info("Called showBookingDetailsByroomId() method of BookingDetailsService");
		List<BookingDetails> bookingDetails = bookingdetailsrepository.showByroomId(roomId);
		List<MBooking> bMBookingDetails= new ArrayList<MBooking>();
		for(BookingDetails bookingDetailsList:bookingDetails)
		{
			MBooking mBookingDetails = new MBooking();
			mBookingDetails.setBookedFrom(bookingDetailsList.getBookedFrom());
			mBookingDetails.setBookedTo(bookingDetailsList.getBookedTo());
			mBookingDetails.setNoOfAdults(bookingDetailsList.getNoOfAdults());
			mBookingDetails.setNoOfChildren(bookingDetailsList.getNoOfChildren());
			mBookingDetails.setTotalamount(bookingDetailsList.getAmount());
			mBookingDetails.setHotelId(bookingDetailsList.getHotel().getHotelId());
			mBookingDetails.setRoomId(bookingDetailsList.getRoomdetails().getRoomId());
			mBookingDetails.setUserId(bookingDetailsList.getUser().getUserId());
			mBookingDetails.setBookingId(bookingDetailsList.getBookingId());
			bMBookingDetails.add(mBookingDetails);
		}
		return bMBookingDetails;
//		else
//		{
//			throw new BookingDetailsNotFoundException();		//Throwing runtime exception
//		}
	}
	
	@Override									//Override method of service class
	@Transactional
	public List<MBooking> showBookingDetailsByuserId(int userId)
	{
		//setting logger info
		LOGGER.info("Called showBookingDetails() method of showBookingDetailsByuserId");
//		List<BookingDetails> booking = bookingdetailsrepository.findAll();
		List<BookingDetails> userbooking = bookingdetailsrepository.showByuserId(userId);
		List<MBooking> bMBookingDetails= new ArrayList<MBooking>();
//		User user = userRepository.findById(userId).orElse(null);
		if(userbooking!=null)
		{
			for(BookingDetails bookingDetailsList:userbooking)
			{
			MBooking mBooking=new MBooking();
			mBooking.setBookedFrom(bookingDetailsList.getBookedFrom());
			mBooking.setBookedTo(bookingDetailsList.getBookedTo());
			mBooking.setBookingId(bookingDetailsList.getBookingId());
			mBooking.setNoOfAdults(bookingDetailsList.getNoOfAdults());
			mBooking.setNoOfChildren(bookingDetailsList.getNoOfChildren());
			mBooking.setRoomId(bookingDetailsList.getRoomdetails().getRoomId());
			mBooking.setHotelId(bookingDetailsList.getHotel().getHotelId());
			mBooking.setTotalamount(bookingDetailsList.getAmount());
			mBooking.setHotelName(bookingDetailsList.getHotel().getHotelName());
			mBooking.setUserName(bookingDetailsList.getUser().getUserName());
			bMBookingDetails.add(mBooking);
			}
			
			return bMBookingDetails;
		}
		else
		{
			throw new BookingDetailsNotFoundException();		//Throwing runtime exception
		}
	}

	@Override
	public List<MRoomDetails> viewOccupiedRoom(LocalDate bookFrom, LocalDate bookTo, int hotelId) {
		
		List<Integer> roomIdList = bookingdetailsrepository.viewOccupiedRoom(bookFrom, bookTo, hotelId);
		List<MRoomDetails> rooms = roomService.showAllRoomDetails(hotelId);
		List<MRoomDetails> room1 = new ArrayList<MRoomDetails>();
		for(MRoomDetails r: rooms)
		{
			if(roomIdList.contains(r.getRoomId())==false)
			{
				room1.add(r);
			}
		}
		return room1;
	}
}
