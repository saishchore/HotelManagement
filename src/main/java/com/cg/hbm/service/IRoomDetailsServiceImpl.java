package com.cg.hbm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.controller.BookingController;
import com.cg.hbm.entites.Hotel;
import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.exceptions.HotelListEmptyException;
import com.cg.hbm.exceptions.HotelNotFoundException;
import com.cg.hbm.exceptions.RoomDetailsListEmptyException;
import com.cg.hbm.exceptions.RoomDetailsNotFoundException;
import com.cg.hbm.exceptions.RoomExistException;
import com.cg.hbm.pojo.MHotel;
import com.cg.hbm.pojo.MRoomDetails;
import com.cg.hbm.repository.IHotelRepository;
import com.cg.hbm.repository.IRoomDetailsRepository;

@Service								//Implementation of service layer method by extend that method
public class IRoomDetailsServiceImpl implements IRoomDetailsService 
{
	@Autowired							//Bean Object of service class
	IRoomDetailsRepository roomdetailsRepository;
	
	@Autowired 							//Bean Object of service class
    IHotelRepository hotelrepository;
	
	
	
	//Declare Logger
	static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);
	

	@Override							//Override method of service class
	@Transactional
	public MRoomDetails removeRoomDetails(int roomId) 
	{
		//setting logger info
		LOGGER.info("Called removeRoomDetails() method of RoomDetailsService");
		RoomDetails searchRoom = roomdetailsRepository.findById(roomId).orElse(null);
		//Hotel hotel = hotelrepository.findById(roomDetails.getHotelId()).orElse(null);
		if (searchRoom==null)
		{
			 throw new RoomDetailsNotFoundException("Room not found");	//Throwing runtime exception
		}
		else
		{
			MRoomDetails roomDetails=new MRoomDetails();
			roomDetails.setRoomId(searchRoom.getRoomId());
			roomDetails.setRoomNo(searchRoom.getRoomNo());
			roomDetails.setRoomType(searchRoom.getRoomType());
			roomDetails.setRatePerDay(searchRoom.getRatePerDay());
			roomDetails.setAvailable(searchRoom.isAvailable());
			roomDetails.setHotelId(searchRoom.getHotel().getHotelId());
			
			roomdetailsRepository.deleteById(roomId);
			return roomDetails;
		}  
	}


	@Override												//Override method of service class
	@Transactional
	public MRoomDetails addRoomDetail(MRoomDetails roomDetails) 
	{
		
		//setting logger info
		LOGGER.info("Called addRoomDetail() method of RoomDetailsService");
		Hotel hotel = hotelrepository.findById(roomDetails.getHotelId()).orElse(null);
		boolean find=false;
		if(hotel==null)
		{
			throw new HotelNotFoundException();
		}
		else
		{
			List<RoomDetails> length=hotel.getRoomdetails();
						
			for(int i=0;i<length.size();i++)
			{
				
				if((hotel.getRoomdetails().get(i).getRoomNo()).equals(roomDetails.getRoomNo()))
				{
					find=true;
					throw new RoomExistException();
				}
			}
			if(find==false)
			{
				RoomDetails room=new RoomDetails();
				room.setRoomId(roomDetails.getRoomId());
				room.setRoomNo(roomDetails.getRoomNo());
				room.setRoomType(roomDetails.getRoomType());
				room.setRatePerDay(roomDetails.getRatePerDay());
				room.setAvailable(roomDetails.isAvailable());
				room.setHotel(hotel);
				room=roomdetailsRepository.save(room);
				roomDetails.setRoomId(room.getRoomId());

			}
			
			
		}
		return roomDetails;
		
	}

	@Override												//Override method of service class
	@Transactional
	public List<MRoomDetails> showAllRoomDetails() 
	{
		//setting logger info
		LOGGER.info("Called showAllRoomDetails() method of RoomDetailsService");	
	    List<RoomDetails> roomDetails =  roomdetailsRepository.findAll();
	    List<MRoomDetails> mRoomDetails= new ArrayList<MRoomDetails>();
		if(roomDetails.isEmpty())
		{
			throw new RoomDetailsListEmptyException();		//Throwing runtime exception
		}
		else
		{
			for(RoomDetails roomDetails1:roomDetails)
			{
				MRoomDetails mRoomDetails1 = new MRoomDetails();
				mRoomDetails1.setRoomId(roomDetails1.getRoomId());
				mRoomDetails1.setRoomNo(roomDetails1.getRoomNo());
				mRoomDetails1.setRoomType(roomDetails1.getRoomType());
				mRoomDetails1.setRatePerDay(roomDetails1.getRatePerDay());
				mRoomDetails1.setHotelId(roomDetails1.getHotel().getHotelId());
				mRoomDetails1.setAvailable(roomDetails1.isAvailable());
				mRoomDetails.add(mRoomDetails1);
			}
		}
		return mRoomDetails;
	}
	
	@Override																		//Override method of service class
	@Transactional
	public MRoomDetails updateRoomDetail(MRoomDetails roomDetails) 
	{
		//setting logger info
		LOGGER.info("Called updateRoomDetail() method of RoomDetailsService");
		
		Hotel hotel = hotelrepository.findById(roomDetails.getHotelId()).orElse(null);
		
		RoomDetails searchRoom = roomdetailsRepository.findById(roomDetails.getRoomId()).orElse(null);
		
		if (searchRoom==null)
		{
			throw new RoomDetailsNotFoundException("Room Details List is Empty");	//Throwing runtime exception
		}
		else if(hotel == null)
		{
			throw new HotelNotFoundException();
		}
		else
		{
			RoomDetails roomDetails1=new RoomDetails();
			roomDetails1.setRoomId(roomDetails.getRoomId());
			roomDetails1.setRoomNo(roomDetails.getRoomNo());
			roomDetails1.setRoomType(roomDetails.getRoomType());
			roomDetails1.setRatePerDay(roomDetails.getRatePerDay());
			roomDetails1.setAvailable(roomDetails.isAvailable());
			roomDetails1.setHotel(hotel);
			roomDetails1=roomdetailsRepository.save(roomDetails1);
			return roomDetails;
		}
	    
	}

	@Override															//Override method of service class
	@Transactional
	public MRoomDetails showRoomDetails(int roomDetailsId) 
	{
		//setting logger info
		LOGGER.info("Called showRoomDetails() method of RoomDetailsService");
		RoomDetails room=roomdetailsRepository.findById(roomDetailsId).orElse(null);
		if(room!=null) 
		{
			MRoomDetails mRoomDetails = new MRoomDetails();
			mRoomDetails.setRoomId(room.getRoomId());
			mRoomDetails.setRoomNo(room.getRoomNo());
			mRoomDetails.setRoomType(room.getRoomType());
			mRoomDetails.setRatePerDay(room.getRatePerDay());
			mRoomDetails.setAvailable(room.isAvailable());
			mRoomDetails.setHotelId(room.getHotel().getHotelId());
			return mRoomDetails;
		}
		else 
		{			
			throw new RoomDetailsNotFoundException("Room not found");	//Throwing runtime exception

		}
	}

	@Override															//Override method of service class
	public List<MRoomDetails> showAllRoomDetails(int hotelId) 
	{
		//setting logger info
		LOGGER.info("Called showAllRoomDetails() method of RoomDetailsService");
		Hotel hotel = hotelrepository.findById(hotelId).orElse(null);
		if(hotel == null)
		{
			throw new HotelNotFoundException();
		}
		else
		{
			List<RoomDetails> roomDetails =  roomdetailsRepository.showAllRoomDetails(hotelId);
			List<MRoomDetails> rMRoomDetails= new ArrayList<MRoomDetails>();
			for(RoomDetails roomDetailsList:roomDetails)
			{
				MRoomDetails mRoomDetails = new MRoomDetails();
				mRoomDetails.setRoomId(roomDetailsList.getRoomId());
				mRoomDetails.setRoomNo(roomDetailsList.getRoomNo());
				mRoomDetails.setRoomType(roomDetailsList.getRoomType());
				mRoomDetails.setRatePerDay(roomDetailsList.getRatePerDay());
				mRoomDetails.setHotelId(roomDetailsList.getHotel().getHotelId());
				mRoomDetails.setAvailable(roomDetailsList.isAvailable());
				rMRoomDetails.add(mRoomDetails);
			}
			return rMRoomDetails;
		}
	
	}

	
}





