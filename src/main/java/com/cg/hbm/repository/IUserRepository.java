package com.cg.hbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.cg.hbm.entites.User;

//Dao layer method
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> //Annotation is used to make these class as repository and extends JpaRepository to get all functions
{
	@Query(value = "select u from User u where u.userName =:userName and u.password=:password") //Writing customized query for that method
	User findByUsernameAndPassword(String userName, String password);
	
	@Query(value = "select u from User u where u.email=:email or u.userName=:username")
	User findExistUser(String email,String username);

}
