package com.cg.hbm.service;

import java.util.List;

import com.cg.hbm.entites.Hotel;
import com.cg.hbm.exceptions.HotelListEmptyException;
import com.cg.hbm.exceptions.HotelNotFoundException;
import com.cg.hbm.pojo.MHotel;

public interface IHotelService 						//Service layer method
{
	public MHotel addHotel(MHotel hotel);
	public MHotel updateHotel(MHotel hotel);
	public MHotel removeHotel(int hotelId);
	public List<MHotel> showAllHotels();
	public MHotel showHotel(int id);
	public List<MHotel> showHotelByName(String hotelName);
	public List<MHotel> showHotelByCity(String city);
}
