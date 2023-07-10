package com.cg.hbm.service;

import java.util.List;
import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.exceptions.RoomDetailsNotFoundException;
import com.cg.hbm.pojo.MRoomDetails;

public interface IRoomDetailsService 								//Service layer method
{
	public MRoomDetails addRoomDetail(MRoomDetails roomDetails);
	public MRoomDetails updateRoomDetail(MRoomDetails roomDetails);
	public MRoomDetails removeRoomDetails(int roomId);
	public List<MRoomDetails> showAllRoomDetails();
	public List<MRoomDetails> showAllRoomDetails(int hotelId);
	public MRoomDetails showRoomDetails(int roomDetailsId);
}
