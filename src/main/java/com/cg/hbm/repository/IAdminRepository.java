package com.cg.hbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.hbm.entites.Admin;

//Dao layer method
@Repository				//Annotation is used to make these class as repository and extends JpaRepository to get all functions
public interface IAdminRepository extends JpaRepository<Admin, Integer>
{
	@Query(value = "select a from Admin a where a.adminName=:username and a.password=:password") //Writing customized query for that method
	public Admin signIn(String username, String password);
	
	//public Admin signOut(Admin admin);
	
	@Query(value="select a from Admin a where a.adminName =:adminName and a.password=:password")  //Writing customized query for that method
	Admin findByAdminnameAndPassword(String adminName, String password);
	
}
