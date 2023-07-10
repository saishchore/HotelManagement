package com.cg.hbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hbm.entites.Payments;

//Dao layer method
public interface IPaymentRepository extends JpaRepository<Payments, Integer> //Annotation is used to make these class as repository and extends JpaRepository to get all functions
{
	
}
