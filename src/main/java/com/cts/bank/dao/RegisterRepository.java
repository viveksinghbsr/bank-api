package com.cts.bank.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cts.bank.entity.User;

public interface RegisterRepository extends CrudRepository<User,Integer>{
	
	@Query(value="SELECT user_id FROM users WHERE account_number=:accountNumber",nativeQuery=true)
	@Transactional
	int getId(@Param("accountNumber") String accountNumber);

	
}
