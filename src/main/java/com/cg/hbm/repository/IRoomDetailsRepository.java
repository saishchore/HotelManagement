package com.cg.hbm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.hbm.entites.Payments;
import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.exceptions.RoomDetailsNotFoundException;
import com.cg.hbm.pojo.MRoomDetails;

//Dao layer method
@Repository
public interface IRoomDetailsRepository extends JpaRepository<RoomDetails, Integer> //Annotation is used to make these class as repository and extends JpaRepository to get all functions
{
	@Query(value = "select r from RoomDetails r where r.hotel.hotelId=:hotelId order by r.roomNo") //Writing customized query for that method
	public List<RoomDetails> showAllRoomDetails(int hotelId);
	
	//@Query()
	RoomDetails findByroomNo(String no);
}
