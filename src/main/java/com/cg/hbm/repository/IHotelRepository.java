package com.cg.hbm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.cg.hbm.entites.Hotel;

//Dao layer method
@Repository
public interface IHotelRepository  extends JpaRepository<Hotel, Integer> //Annotation is used to make these class as repository and extends JpaRepository to get all functions
{
	
	List<Hotel> findByEmail(String email);
	
	@Query(value="select h from Hotel h where h.hotelName =:hotelName")  //Writing customized query for that method
	List<Hotel> findByHotelName(String hotelName);
     
	
	@Query(value="select h from Hotel h where h.city =:city")
	List<Hotel> findByCity(String city);
}
