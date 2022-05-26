package com.cts.bank.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cts.bank.entity.User;

public interface LoginRepository extends CrudRepository<User,Integer>{
	
	@Query(value="SELECT * FROM users WHERE email = :email",nativeQuery=true)
	User getUser(@Param("email") String email);
	
	@Query(value="SELECT email FROM users WHERE email=:email",nativeQuery=true)
	String getEmail(@Param("email") String email);
	
	@Query(value="SELECT password FROM users WHERE email=:email",nativeQuery=true)
	String getPassword(@Param("email") String email);

	
}
