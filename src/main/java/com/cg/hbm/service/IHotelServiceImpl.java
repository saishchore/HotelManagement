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
import com.cg.hbm.exceptions.HotelExistException;
import com.cg.hbm.exceptions.HotelListEmptyException;
import com.cg.hbm.exceptions.HotelNotFoundException;
import com.cg.hbm.pojo.MHotel;
import com.cg.hbm.repository.IHotelRepository;
import com.cg.hbm.repository.IRoomDetailsRepository;

@Service									//Implementation of service layer method by extend that method
public class IHotelServiceImpl  implements IHotelService 
{
    @Autowired 								//Bean Object of service class
    IHotelRepository hotelrepository;
    
    //Declare Logger    
	static final Logger LOGGER = LoggerFactory.getLogger(IHotelServiceImpl.class);
    
    @Transactional
    @Override									//Override method of service class
    public MHotel addHotel(MHotel hotel) 
    {
    	//setting logger info
    	LOGGER.info("Called addHotel() method of HotelService");
    	List<Hotel> hotel1 = hotelrepository.findByEmail(hotel.getEmail());
    	if(!(hotel1.isEmpty()))
    	{
    		throw new HotelExistException();	//Throwing runtime exception
    	}
    	else
    	{
    		Hotel hotelEntity = new Hotel();
    		hotelEntity.setAddress(hotel.getAddress());
    		hotelEntity.setAvgRatePerDay(hotel.getAvgRatePerDay());
    		hotelEntity.setCity(hotel.getCity());
    		hotelEntity.setDescription(hotel.getDescription());
    		hotelEntity.setEmail(hotel.getEmail());
    		hotelEntity.setHotelName(hotel.getHotelName());
    		hotelEntity.setPhone1(hotel.getPhone1());
    		hotelEntity.setPhone2(hotel.getPhone2());
    		hotelEntity.setWebsite(hotel.getWebsite());
    		hotelEntity.setImageUrl(hotel.getImageUrl());
    		hotelEntity = hotelrepository.save(hotelEntity);
    		hotel.setHotelId(hotelEntity.getHotelId());
    		
    		return hotel;
    	}
    }
    
    
    @Transactional
    @Override											//Override method of service class
    public MHotel updateHotel(MHotel hotel) 
    {
    	//setting logger info
    	LOGGER.info("Called updateHotel() method of HotelService");
    	Hotel searchHotel = hotelrepository.findById(hotel.getHotelId()).orElse(null);
    	if (searchHotel==null)
    	{
    		throw new HotelNotFoundException();			//Throwing runtime exception
    	}
    	else 
    	{
    		Hotel hotel1 = new Hotel();
    		hotel1.setAddress(hotel.getAddress());
    		hotel1.setAvgRatePerDay(hotel.getAvgRatePerDay());
    		hotel1.setCity(hotel.getCity());
    		hotel1.setDescription(hotel.getDescription());
    		hotel1.setEmail(hotel.getEmail());
    		hotel1.setHotelName(hotel.getHotelName());
    		hotel1.setPhone1(hotel.getPhone1());
    		hotel1.setPhone2(hotel.getPhone2());
    		hotel1.setWebsite(hotel.getWebsite());
    		hotel1.setImageUrl(hotel.getImageUrl());
    		hotel1.setHotelId(hotel.getHotelId());
    		hotel1 = hotelrepository.save(hotel1);
            //hotel.setHotelId(h1.getHotelId());
            return hotel;
    		
        }   
            
	}
    
    
    @Transactional
    @Override																//Override method of service class
    public List<MHotel> showAllHotels() 
    {
    	//setting logger info
    	LOGGER.info("Called showAllHotels() method of HotelService");
    	List<Hotel> list = hotelrepository.findAll();
		if(list.size()==0)
		{
			throw new HotelListEmptyException("Hotel List is Empty");		//Throwing runtime exception
		}
		else
		{
			List<MHotel> mList1 = new ArrayList<MHotel>();
			for(Hotel hotel : list)
			{
				MHotel mHotel = new MHotel();
				mHotel.setHotelId(hotel.getHotelId());
				mHotel.setAddress(hotel.getAddress());
				mHotel.setAvgRatePerDay(hotel.getAvgRatePerDay());
				mHotel.setCity(hotel.getCity());
				mHotel.setDescription(hotel.getDescription());
				mHotel.setEmail(hotel.getEmail());
				mHotel.setHotelName(hotel.getHotelName());
				mHotel.setPhone1(hotel.getPhone1());
				mHotel.setPhone2(hotel.getPhone2());
				mHotel.setWebsite(hotel.getWebsite());
				mHotel.setImageUrl(hotel.getImageUrl());
				mList1.add(mHotel);
			}
			return mList1;
		}
    }
    
    
    @Transactional
    @Override														//Override method of service class
    public MHotel showHotel(int id) 
    {
    	//setting logger info
    	LOGGER.info("Called showHotel() method of HotelService");
        Hotel hotel = hotelrepository.findById(id).orElse(null);
        if(hotel!=null)
        {
        	MHotel mHotel = new MHotel();
        	mHotel.setHotelId(hotel.getHotelId());
        	mHotel.setAddress(hotel.getAddress());
        	mHotel.setAvgRatePerDay(hotel.getAvgRatePerDay());
        	mHotel.setCity(hotel.getCity());
        	mHotel.setDescription(hotel.getDescription());
        	mHotel.setEmail(hotel.getEmail());
        	mHotel.setHotelName(hotel.getHotelName());
        	mHotel.setPhone1(hotel.getPhone1());
        	mHotel.setPhone2(hotel.getPhone2());
        	mHotel.setWebsite(hotel.getWebsite());
        	mHotel.setImageUrl(hotel.getImageUrl());
            return mHotel;
        }
        else 
        {
        	 throw new HotelNotFoundException();					//Throwing runtime exception
        }
    }
    
    @Override										//Override method of service class
    @Transactional
    public MHotel removeHotel(int hotelId) 
    {
    	//setting logger info
    	LOGGER.info("Called removeHotel() method of HotelService");
        Hotel searchHotel = hotelrepository.findById(hotelId).orElse(null);
        if (searchHotel==null)
        {
        	throw new HotelNotFoundException();		//Throwing runtime exception
        }
        else 
        {
        	MHotel mHotel = new MHotel();
        	mHotel.setHotelId(searchHotel.getHotelId());
        	mHotel.setAddress(searchHotel.getAddress());
        	mHotel.setAvgRatePerDay(searchHotel.getAvgRatePerDay());
        	mHotel.setCity(searchHotel.getCity());
        	mHotel.setDescription(searchHotel.getDescription());
        	mHotel.setEmail(searchHotel.getEmail());
        	mHotel.setHotelName(searchHotel.getHotelName());
        	mHotel.setPhone1(searchHotel.getPhone1());
        	mHotel.setPhone2(searchHotel.getPhone2());
        	mHotel.setWebsite(searchHotel.getWebsite());
        	mHotel.setImageUrl(searchHotel.getImageUrl());
            hotelrepository.deleteById(searchHotel.getHotelId());
        	return mHotel;
        }
    }
    
    @Transactional
	@Override
	public List<MHotel> showHotelByName(String hotelName) {
		// TODO Auto-generated method stub
		LOGGER.info("Called showHotelByName() method of HotelService");
		List<Hotel> list = hotelrepository.findByHotelName(hotelName);
		if(list.size()==0)
		{
			throw new HotelListEmptyException("No Hotel with that name");		//Throwing runtime exception
		}
		else
		{
			List<MHotel> list1 = new ArrayList<MHotel>();
			for(Hotel hotel : list)
			{
				MHotel h1 = new MHotel();
				h1.setHotelId(hotel.getHotelId());
		    	h1.setAddress(hotel.getAddress());
		    	h1.setAvgRatePerDay(hotel.getAvgRatePerDay());
		    	h1.setCity(hotel.getCity());
		    	h1.setDescription(hotel.getDescription());
		    	h1.setEmail(hotel.getEmail());
		    	h1.setHotelName(hotel.getHotelName());
		    	h1.setPhone1(hotel.getPhone1());
		    	h1.setPhone2(hotel.getPhone2());
		    	h1.setWebsite(hotel.getWebsite());
		    	h1.setImageUrl(hotel.getImageUrl());
		    	list1.add(h1);
			}
			return list1;
		}
	}

    
	@Transactional
	@Override
	public List<MHotel> showHotelByCity(String city) {
		// TODO Auto-generated method stub
		LOGGER.info("Called showHotelByCity() method of HotelService");
		List<Hotel> list = hotelrepository.findByCity(city);
		if(list.size()==0)
		{
			throw new HotelListEmptyException("No Hotel with that city");		//Throwing runtime exception
		}
		else
		{
			List<MHotel> list1 = new ArrayList<MHotel>();
			for(Hotel hotel : list)
			{
				MHotel h1 = new MHotel();
				h1.setHotelId(hotel.getHotelId());
		    	h1.setAddress(hotel.getAddress());
		    	h1.setAvgRatePerDay(hotel.getAvgRatePerDay());
		    	h1.setCity(hotel.getCity());
		    	h1.setDescription(hotel.getDescription());
		    	h1.setEmail(hotel.getEmail());
		    	h1.setHotelName(hotel.getHotelName());
		    	h1.setPhone1(hotel.getPhone1());
		    	h1.setPhone2(hotel.getPhone2());
		    	h1.setWebsite(hotel.getWebsite());
		    	h1.setImageUrl(hotel.getImageUrl());
		    	list1.add(h1);
			}
			return list1;
		}
	}

}
